// args ip server ip local .tostring, enviar mi ip al serverf
var net = require('net');

if (process.argv.length == 6) {
    IP_remota = process.argv[2].toString();
    PUERTO_remoto = process.argv[3];
    IP_proxy = process.argv[4].toString();
    PUERTO_proxy = process.argv[5];
    console.log('IP remota ' + IP_remota + ' Puerto remoto' + PUERTO_remoto); // nuevos valores proxy
    console.log('IP proxy ' + IP_proxy + ' Puerto proxy' + PUERTO_proxy); // proxy
} else {
    console.log('número de argumentos incorrecto');
    process.exit();
}

var client = net.connect({
        port: PUERTO_proxy,
        host: IP_proxy
    },
    function () { //connect listener
        console.log('client connected');
        Peticion = JSON.stringify({
            'remote_ip': IP_remota,
            'remote_port': PUERTO_remoto
        });
        client.write(Peticion);
    }
);
client.on('data',
    function (data) {
        console.log(data.toString());
        client.end(); // finaliza el cliente
    }
);
client.on('end',
    function () {
        console.log('client disconnected');
    }
);
//node programador 5.56.60.120 80 127.0.0.1 8002