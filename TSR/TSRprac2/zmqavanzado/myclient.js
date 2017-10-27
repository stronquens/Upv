// myclient in NodeJS
var zmq = require('zmq'),
    requester = zmq.socket('req');

var brokerURL = 'tcp://localhost:8059';
var myID = 'NONE';
var myMsg = 'Hello';

if (myID != 'NONE')
    requester.identity = myID;
requester.connect(brokerURL);
console.log('Client (%s) connected to %s', myID, brokerURL)

requester.on('message', function (msg) {
    console.log('Client (%s) has received reply "%s"', myID, msg.toString());
    process.exit(0);
});
requester.send(myMsg);