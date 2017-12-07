 // ROUTER-ROUTER request-reply broker in NodeJS with classIDs
 var zmq = require('zmq'),
     frontend = zmq.socket('router'),
     backend = zmq.socket('router');
 var args = process.argv.slice(2);
 var fePortNbr = 8061;
 var bePortNbr = 8062;
 var workers = [];
 var clients = [];
 var classIDs = [];
 if (args.length > 0) {
     classIDs = args;
 } else {
     classIDs = ['R', 'G', 'B'];
 }
 for (var i in classIDs) {
     workers[classIDs[i]] = [];
     clients[classIDs[i]] = [];
 }

 frontend.bindSync('tcp://*:' + fePortNbr);
 backend.bindSync('tcp://*:' + bePortNbr);

 frontend.on('message', function () {
     var args = Array.apply(null, arguments);
     var classID = args.pop();
     if (workers[classID].length > 0) {
         var myWorker = workers[classID].shift();
         var m = [myWorker, ''].concat(args);
         backend.send(m);
     } else
         clients[classID].push({
             id: args[0],
             msg: args.slice(2)
         });
 });

 function processPendingClient(workerID, classID) {
     if (clients[classID].length > 0) {
         var nextClient = clients[classID].shift();
         var m = [workerID, '', nextClient.id, ''].concat(nextClient.msg);
         backend.send(m);
         return true;
     } else
         return false;
 }

 backend.on('message', function () {
     var args = Array.apply(null, arguments);
     var classID = args.pop();
     if (args.length == 4) {
         if (!processPendingClient(args[0], classID))
             workers[classID].push(args[0]);
     } else {
         var workerID = args[0];
         args = args.slice(2);
         frontend.send(args);
         if (!processPendingClient(workerID, classID))
             workers[classID].push(workerID);
     }
 });
 setTimeout(function () {
     console.log('Terminado mybroker1');
     process.exit();
 }, 20000)