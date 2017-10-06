// args ip server ip local .tostring, enviar mi ip al serverf
var net = require('net');

if (process.argv.length == 4) {
    IP_remota = process.argv[2].toString();
    IP_local = process.argv[3].toString();
    console.log('IP remota ' + IP_remota);
} else {
    console.log('número de argumentos incorrecto');
    process.exit();
}

var client = net.connect({
        port: 8000,
        host: IP_remota
    },
    function () { //connect listener
        console.log('client connected');
        Peticion = '{ip:'+IP_local+'}';
        
        client.write(Peticion);
    });
client.on('data',
    function (data) {
        console.log(data.toString());
        client.end(); // finaliza el cliente
    });
client.on('end',
    function () {
        console.log('client disconnected');
    });