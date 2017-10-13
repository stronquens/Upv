var net = require('net');

var dirs = {
    8001: {
        'ip': '158.42.4.23',
        'port': 80
    },
    8002: {
        'ip': '5.56.60.120',
        'port': 80
    },
    8003: {
        'ip': '158.42.4.23',
        'port': 80
    },
    8004: {
        'ip': '5.56.60.120',
        'port': 80
    },
    8005: {
        'ip': '158.42.4.23',
        'port': 80
    },
    8006: {
        'ip': '5.56.60.120',
        'port': 80
    },
    8007: {
        'ip': '158.42.4.23',
        'port': 80
    },
    8008: {
        'ip': '5.56.60.120',
        'port': 80
    }
};

for (var k in dirs) {
    console.log('var port ' + k + ' value ' + dirs[k].ip);

    net.createServer(function (socket) { // cliente original
        var serviceSocket = new net.Socket(); // servidor remoto
        console.log('Connected to ' + dirs[k].port + ' value ' + dirs[k].ip);
        serviceSocket.connect(
            dirs[k].port,
            dirs[k].ip,
            function () { // Cliente original
                socket.on('data', function (msg) {
                    serviceSocket.write(msg);
                });
                serviceSocket.on('data', function (data) {
                    socket.write(data);
                });
            }
        );
    }).listen(k, '127.0.0.1');

}

var serverControlador = net.createServer(function (prog) { // cliente original
    console.log('server: client connected');
    prog.on('data', function (msg) {
        msg = JSON.parse(msg);
        if (msg.op == 'set') {
            dirs[msg.inPort].ip = msg.remote.ip;
            dirs[msg.inPort].port = msg.remote.port;
            console.log("New Data: " + dirs[msg.inPort].ip + " " + dirs[msg.inPort].port);
        }
        prog.end();
    });
    prog.on('end', function () {
        console.log('server: client disconnected');
    });
}).listen(8000, '127.0.0.1');