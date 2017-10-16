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

//for (var k in dirs) {
    //console.log('var port ' + k + ' value ' + dirs[k].ip);

var server1 = net.createServer(function (socket) { // cliente original
        var serviceSocket1 = new net.Socket(); // servidor remoto
        console.log('Connected to ' + dirs[8001].port + ' value ' + dirs[8001].ip);
        serviceSocket1.connect(
            dirs[8001].port,
            dirs[8001].ip,
            function () { // Cliente original
                socket.on('data', function (msg) {
                    serviceSocket1.write(msg);
                });
                serviceSocket1.on('data', function (data) {
                    socket.write(data);
                });
            }
        );
    }).listen(8001, '127.0.0.1');

    var server2 = net.createServer(function (socket) { // cliente original
        var serviceSocket2 = new net.Socket(); // servidor remoto
        console.log('Connected to ' + dirs[8002].port + ' value ' + dirs[8002].ip);
        serviceSocket2.connect(
            dirs[8002].port,
            dirs[8002].ip,
            function () { // Cliente original
                socket.on('data', function (msg) {
                    serviceSocket2.write(msg);
                });
                serviceSocket2.on('data', function (data) {
                    socket.write(data);
                });
            }
        );
    }).listen(8002, '127.0.0.1');

    var server3 = net.createServer(function (socket) { // cliente original
        var serviceSocket3 = new net.Socket(); // servidor remoto
        console.log('Connected to ' + dirs[8003].port + ' value ' + dirs[8003].ip);
        serviceSocket3.connect(
            dirs[8003].port,
            dirs[8003].ip,
            function () { // Cliente original
                socket.on('data', function (msg) {
                    serviceSocket3.write(msg);
                });
                serviceSocket3.on('data', function (data) {
                    socket.write(data);
                });
            }
        );
    }).listen(8003, '127.0.0.1');

//}

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