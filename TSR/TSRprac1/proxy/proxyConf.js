var net = require('net');

//var args = process.argv.slice(2, process.argv.length); 
if (process.argv.length<4){
    console.log("Error need more arguments");
    return;
}
var LOCAL_PORT = 8001;
var LOCAL_IP = '127.0.0.1';
var REMOTE_IP = process.argv[2].toString(); // test 5.56.60.120:80
var REMOTE_PORT = process.argv[3];


var server = net.createServer(function (socket) {// cliente original

    var serviceSocket = new net.Socket(); // servidor remoto
    serviceSocket.connect(
        parseInt(REMOTE_PORT),
        REMOTE_IP,
        function () {// Cliente original
            socket.on('data', function (msg) {
                serviceSocket.write(msg);
            });
            serviceSocket.on('data', function (data) {
                socket.write(data);
            });
        }
    );

}).listen(LOCAL_PORT, LOCAL_IP);
console.log("TCP server accepting connection on port: " + LOCAL_PORT);