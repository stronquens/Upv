var zmq = require('zmq')
var publisher = zmq.socket('pub')
var aux = require("./auxfunctions1718.js");

// node publisher 8000 5 marca as
var args = process.argv.slice(2);
var port = args[0];
var nmen = args[1];

var desc = args.slice(2);

publisher.bind('tcp://*:' + port, function (err) {
  if (err)
    console.log(err)
  else
    console.log("Listening on " + port + "...")
})
var indice = 0;
for (var i = 0; i < nmen; i++) {
  if (indice == desc.length) {
    indice = 0;
  }
  lanzar(indice,i);
  indice++;
}
function lanzar(indice, iteracion) {
  setTimeout(function () {
    console.log('sent: '+desc[indice]+' iteracion: '+iteracion);
    //publisher.send(desc[indice] + aux.randNumber(0, 100));
    publisher.send(""+desc[indice] + iteracion);
    
  }, 1000 * i)
}

process.on('SIGINT', function () {
  publisher.close()
  console.log('\nClosed')
})