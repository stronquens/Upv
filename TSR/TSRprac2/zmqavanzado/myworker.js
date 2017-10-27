 // myworker server in NodeJS
 var zmq = require('zmq'),
 responder = zmq.socket('req');

var backendURL = 'tcp://localhost:8060';
var myID = 'NONE';
var connText = 'id';
var replyText = 'World';

if (myID != 'NONE')
 responder.identity = myID;
responder.connect(backendURL);
responder.on('message', function (client, delimiter, msg) {
 setTimeout(function () {
     responder.send([client, '', replyText]);
 }, 1000);
});
responder.send(connText);