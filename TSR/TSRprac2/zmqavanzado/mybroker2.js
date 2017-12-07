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

// Reply awaiting period, in ms.
const answerInterval = 2000;
// Array of busy workers. Each slot contains an array with all
// the segments being needed for resending the current message
// being processed by that worker.
var busyWorkers = [];
// Send a message to a worker.
function sendToWorker(msg) {
    var myWorker = msg[0];
    // Send the message.
    backend.send(msg);
    // Initialise busyWorkers slot object.
    busyWorkers[myWorker] = {};
    // Recall that such message has been sent.
    busyWorkers[myWorker].msg = msg.slice(2);
    // Set a timeout of its response.
    busyWorkers[myWorker].timeout = setTimeout(generateTimeoutHandler(myWorker), answerInterval);
}
// Function that sends a message to a worker, or 
// holds the message if no worker is available now.
// Parameter 'args' is an array of message segments.
function sendRequest(args) {
    if (workers.length > 0) {
        var myWorker = workers.shift();
        var m = [myWorker, ''].concat(args);
        sendToWorker(m);
    } else {
        clients.push({
            id: args[0],
            msg: args.slice(2)
        });
    }
}
// Function that creates the handler for a reply
// timeout.
function generateTimeoutHandler(workerID) {
    return function () {
        // Get the message to be resent.
        var msg = busyWorkers[workerID].msg;
        // Remove that slot from the busyWorkers array.
        delete busyWorkers[workerID];
        // Resend that message.
        sendRequest(msg);
    }
}

frontend.bindSync('tcp://*:' + fePortNbr);
backend.bindSync('tcp://*:' + bePortNbr);

frontend.on('message', function () {
    var args = Array.apply(null, arguments);
    sendRequest(args);
});

function processPendingClient(workerID) {
    if (clients.length > 0) {
        var nextClient = clients.shift();
        var m = [workerID, '', nextClient.id, ''].concat(nextClient.msg);
        sendToWorker(m);
        return true;
    } else
        return false;
}

backend.on('message', function () {
    var args = Array.apply(null, arguments);
    if (args.length == 3) {
        if (!processPendingClient(args[0]))
            workers.push(args[0]);
    } else {
        var workerID = args[0];
        clearTimeout(busyWorkers[workerID].timeout);
        args = args.slice(2);
        frontend.send(args);
        if (!processPendingClient(workerID))
            workers.push(workerID);
    }
});