// Hello World server
// Binds REP socket to tcp://*:5555
// Expects "Hello" from client, replies with "world"

var zmq = require('zmq');

if(process.argv.length != 5){
  console.log('node hwserver 8000 1 texto nuevo');
  process.exit(0);
}
var arg = process.argv.slice(2);
var port = arg[0];
var secs = arg[1]*1000;
var text = arg[2];

// socket to talk to clients
var responder = zmq.socket('rep');

responder.on('message', function(request) {
  console.log("Received request: [", request.toString(), "]");

  // do some 'work'
  setTimeout(function() {

    // send reply back to client.
    responder.send(request.toString()+" "+text);
  }, secs);
});

responder.bind('tcp://*:'+port, function(err) {
  if (err) {
    console.log(err);
  } else {
    console.log("Listening on "+port+"...");
  }
});

process.on('SIGINT', function() {
  responder.close();
});
