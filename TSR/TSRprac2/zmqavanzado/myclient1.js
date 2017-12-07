// myclient in NodeJS
var zmq = require('zmq'),
    requester = zmq.socket('req');

var args = process.argv.slice(2);
//var brokerURL = args[0] || 'tcp://localhost:8061';
var brokerURL = 'tcp://localhost:8061';
var myID = args[0] || 'NONE';
var myClass = args[1] || 'R';
var myMsg = args[2] || 'Hello';

if (myID != 'NONE')
    requester.identity = myID;

requester.connect(brokerURL);
console.log('Client (%s), class (%s) connected to %s', myID,myClass, brokerURL)

requester.on('message', function (msg) {
    console.log('Client (%s) has received reply "%s"', myID, msg.toString());
    process.exit(0);
});
requester.send([myMsg,myClass]);

setTimeout(function () {
    console.log('Terminado ' + myID);
    process.exit();
}, 20000)