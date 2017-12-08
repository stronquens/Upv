 // myworker server in NodeJS
 var zmq = require('zmq'),
     aux = require('./auxfunctions1718.js'),
     responder = zmq.socket('req');

 var args = process.argv.slice(2);
 var backendURL =  'tcp://localhost:8060';
 var myID = args[0] || 'NONE';
 var connText = args[1] || 'id';
 var replyText = args[2] || 'World';
 var verbose = args[3] || true;

 // Eliminar en linux para que use getLoad()
 var carga = Math.random() * (10 - 0);
 
 if (myID != 'NONE')
     responder.identity = myID;
 responder.connect(backendURL);
 if (verbose) {
     console.log('Worker (%s) connected to %s', myID, backendURL);
 }
 responder.on('message', function (client, delimiter, msg) {
     if (verbose) {
         console.log('Worker (%s) has received request "%s" from client (%s)',
             myID, msg.toString(), client);
     }
     setTimeout(function () {
         //responder.send([client, '', replyText,aux.getLoad()]);
         responder.send([client, '', replyText,carga]);
         if (verbose) {
             console.log('Worker (%s) has sent its reply "%s" and load (%f)',
                 //myID, replyText,aux.getLoad().toString());
                 myID, replyText,carga);
         }
     }, 1000);
 });
 //responder.send([connText,aux.getLoad().toString()]);
 responder.send([connText,carga]);
 if (verbose) {
     console.log('Worker (%s) has sent its first connection message: "%s" con carga de (%s)',
     myID, connText, carga.toString());
     //myID, connText, aux.getLoad().toString());
 }

 setTimeout(function () {
     console.log('Terminado' + myID);
     process.exit();
 }, 20000)