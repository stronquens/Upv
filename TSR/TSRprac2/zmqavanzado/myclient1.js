// myclient in NodeJS
var zmq = require('zmq'),
    requester = zmq.socket('req');

var args = process.argv.slice(2);
var brokerURL = args[0] || 'tcp://localhost:8059';
var myID = args[1] || 'NONE';
var myMsg = args[2] || 'Hello';

if (myID != 'NONE')
    requester.identity = myID;
requester.connect(brokerURL);
console.log('Client (%s) connected to %s', myID, brokerURL)

requester.on('message', function (msg) {
    console.log('Client (%s) has received reply "%s"', myID, msg.toString());
    process.exit(0);
});
requester.send(myMsg);

setTimeout(function(){
    console.log('Terminado '+myID);
    process.exit();
},20000)