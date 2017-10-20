// Hello World client
// Connects REQ socket to tcp://localhost:5555
// Sends "Hello" to server.

var zmq = require('zmq');

if(process.argv.length != 5){
  console.log('node hwclient tcp://127.0.0.1:8000 5 cliente');
  process.exit(0);
}
var arg = process.argv.slice(2);
var url = arg[0];
var npet = arg[1];
var pet = arg[2];

// socket to talk to server
console.log("Connecting to hello world server...");
var requester = zmq.socket('req');

var x = 0;
requester.on("message", function(reply) {
  console.log("Received reply", x, ": [", reply.toString(), ']');
  x += 1;
  if (x === 10) {
    requester.close();
    process.exit(0);
  }
});

requester.connect(url);

for (var i = 0; i < npet; i++) {
  console.log("Sending request", i, '...');
  requester.send(pet);
}

process.on('SIGINT', function() {
  requester.close();
});
