var zmq = require('zmq')
var publisher = zmq.socket('pub')
var aux = require("./auxfunctions1718.js");

var args = process.argv.slice(2);
var port = args[0];
var nmen = args[1];
var desc1 = args[2];
var desc2 = args[3];

publisher.bind('tcp://*:'+port, function(err) {
  if(err)
    console.log(err)
  else
    console.log("Listening on "+port+"...")
})

for (var i=1 ; i<nmen ; i++)
    setTimeout(function() {
        console.log('sent');
        publisher.send(desc1 + aux.randNumber(0,100));
        publisher.send(desc2 + aux.randNumber(0,100));
    }, 1000 * i)

process.on('SIGINT', function() {
  publisher.close()
  console.log('\nClosed')
})
// node publisher 8000 5 marca as