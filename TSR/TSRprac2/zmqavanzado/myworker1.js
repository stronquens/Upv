 // myworker server in NodeJS
 var zmq = require('zmq'),
 responder = zmq.socket('req');

var args = process.argv.slice(2);
//var backendURL = args[0] || 'tcp://localhost:8062';
var backendURL = 'tcp://localhost:8062';
var myID = args[0] || 'NONE';
var myClass = args[1] || 'R';
var connText = args[2] || 'id';
var replyText = args[3] || 'World';
var verbose = args[4] || true;

if (myID != 'NONE')
 responder.identity = myID;

responder.connect(backendURL);

if (verbose) {
 console.log('Worker (%s) connected to %s', myID, backendURL);
}
responder.on('message', function (client, delimiter, msg) {
 if (verbose) {
     console.log('Worker (%s), class (%s) has received request "%s" from client (%s)',
         myID, myClass, msg.toString(), client);
 }
 setTimeout(function () {
     responder.send([client, '', replyText,myClass]);
     if (verbose) {
         console.log('Worker (%s) has sent its reply "%s"',
             myID, replyText, myClass);
     }
 }, 1000);
});
responder.send([connText, myClass]);
if (verbose) {
 console.log('Worker (%s), class (%s) has sent its first connection message: "%s"',
     myID, myClass, connText);
}

setTimeout(function () {
 console.log('Terminado' + myID);
 process.exit();
}, 20000)