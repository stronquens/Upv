var zmq = require('zmq')
var subscriber = zmq.socket('sub')

var args = process.argv.slice(2);
var endpoint = args[0];
var descriptor = args[1];

subscriber.on("message", function(reply) {
  console.log('Received message: ', reply.toString());
})

subscriber.connect(endpoint.toString())//"tcp://localhost:8688"
subscriber.subscribe(descriptor.toString())

process.on('SIGINT', function() {
  subscriber.close()
  console.log('\nClosed')
})
//node subscriber tcp://localhost:8000 marca