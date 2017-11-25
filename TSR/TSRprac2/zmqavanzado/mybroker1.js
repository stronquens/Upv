// ROUTER-ROUTER request-reply broker in NodeJS
var aux = require("./auxfunctions1718.js");
var zmq = require('zmq'),
    frontend = zmq.socket('router'),
    backend = zmq.socket('router');

var args = process.argv.slice(2);
var fePortNbr = args[0] || 8059;
var bePortNbr = args[1] || 8060;
var verbose = args[2] || true;

var workers = [];
var clients = [];
// Array with the counters of how many requests have been processed
// by each worker.
var requestsPerWorker = [];

frontend.bindSync('tcp://*:' + fePortNbr);
backend.bindSync('tcp://*:' + bePortNbr);

frontend.on('message', function () {
    var args = Array.apply(null, arguments);
    if (workers.length > 0) {
        var myWorker = workers.shift();
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
    if (args.length == 3) {
        requestsPerWorker[args[0]] = 0;
        if (!processPendingClient(args[0]))
            workers.push(args[0]);
    } else {
        requestsPerWorker[args[0]]++;
        var workerID = args[0];
        args = args.slice(2);
        frontend.send(args);
        if (!processPendingClient(workerID))
            workers.push(workerID);
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
// Function that shows the service statistics.
function showStatistics() {
    var totalAmount = 0;
    console.log('Current amount of requests served by each worker:');
    for (var i in requestsPerWorker) {
        console.log(' %s : %d requests', i, requestsPerWorker[i]);
        totalAmount += requestsPerWorker[i];
    }
    console.log('Requests already served (total): %d', totalAmount);
}
// Show the statistics each time [Ctrl]+[C] is pressed.
process.on('SIGINT', showStatistics);

setTimeout(function () {
    showStatistics();
    console.log('Terminado mybroker_vp');
    process.exit();
}, 20000)