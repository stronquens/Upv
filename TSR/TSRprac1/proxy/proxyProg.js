var net = require('net');

//var args = process.argv.slice(2, process.argv.length); 
if (process.argv.length < 4) {
    console.log("Error need more arguments");
    return;
}
var LOCAL_PORT = 8001;
var LOCAL_PORT2 = LOCAL_PORT+1;
var LOCAL_IP = '127.0.0.1';
var REMOTE_IP = process.argv[2].toString(); // test 5.56.60.120 o 158.42.4.23
var REMOTE_PORT = process.argv[3];


var server = net.createServer(function (socket) { // cliente original
    var serviceSocket = new net.Socket(); // servidor remoto
    serviceSocket.connect(
        parseInt(REMOTE_PORT),
        REMOTE_IP,
        function () { // Cliente original
            socket.on('data', function (msg) {
                serviceSocket.write(msg);
            });
            serviceSocket.on('data', function (data) {
                socket.write(data);
            });
        }
    );
}).listen(LOCAL_PORT, LOCAL_IP);

var serverprog = net.createServer(function (prog) { // cliente original
    console.log('server: client connected');
    prog.on('data', function (msg) {
        msg = JSON.parse(msg);
        REMOTE_IP = msg.remote_ip;
        REMOTE_PORT = msg.remote_port;
        console.log("New Data: "+REMOTE_IP+" "+REMOTE_PORT);
        prog.end(); 
    });
    prog.on('end', function () {
        console.log('server: client disconnected');
    });
}).listen(LOCAL_PORT2, LOCAL_IP);


console.log("TCP server accepting connection on port: " + LOCAL_PORT);
console.log("TCP server accepting connection on port: " + LOCAL_PORT2);
// node proxyProg.js 158.42.4.23 80