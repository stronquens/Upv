// ROUTER-ROUTER request-reply broker in NodeJS
var aux = require("./auxfunctions1718.js");
var zmq = require('zmq'),
    frontend = zmq.socket('router'),
    backend = zmq.socket('router');

var args = process.argv.slice(2);
var fePortNbr = args[0] || 8059;
var bePortNbr = args[1] || 8060;
var verbose = args[2] || true;

var list = aux.orderedList();
aux.ordered = list.ordered;
aux.data = list.data;
var clients = [];

frontend.bindSync('tcp://*:' + fePortNbr);
backend.bindSync('tcp://*:' + bePortNbr);

frontend.on('message', function () {
    var args = Array.apply(null, arguments);
    if (aux.data.length > 0) {
        var myWorker = aux.lowest().id;
        var m = [myWorker, ''].concat(args);
        //backend.send(m);
        sendToWorker(m);
    } else
        clients.push({
            id: args[0],
            msg: args.slice(2)
        });
});

function processPendingClient(workerID) {
    if (clients.length > 0) {
        var nextClient = clients.shift();
        var m = [workerID, '', nextClient.id, ''].concat(nextClient.msg);
        backend.send(m);
        return true;
    } else
        return false;
}

backend.on('message', function () {
    var args = Array.apply(null, arguments);
    var load = args.pop();
    console.log('Broker receiv wID (%s) load (%s) ',args[0],load.toString());    
    if (args.length == 3) {
        if (!processPendingClient(args[0]))
            aux.insert({'id': args[0],'load': -load});
            //workers.push(args[0]);
    } else {
        var workerID = args[0];
        args = args.slice(2);
        frontend.send(args);
        if (!processPendingClient(workerID))
            aux.insert({'id': args[0],'load': -load});
            //workers.push(workerID);
    }
});

function sendToWorker(msg) {
    if (verbose) {
        console.log('Sending client (%s) request to worker (%s) through backend.',
            msg[2], msg[0]);
        aux.showMessage(msg);
    }
    backend.send(msg);
}

setTimeout(function () {
    console.log('Terminado lbbroker');
    process.exit();
}, 20000)

