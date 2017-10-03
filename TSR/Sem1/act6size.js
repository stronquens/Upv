var fs = require('fs');

var args = process.argv.slice(2, process.argv.length); // elimina los 2 primeros args que no valen

function peso(args) {
    var res = []; // valor en bytes de cada argumento
    var count = 0; // contador para saber cuando un callback es el ultimo

    return function () {
        args.forEach((file, index) => { // recorre los args
            fs.readFile(file, (err, data) => { // callback que calcula valor bytes de cada fichero async
                res[index] = data.length;
                count++;
                if (count == args.length) { // Si es el ultimo elemento que queda por insertar calcula el max
                    // maximo indice en res
                    var maxIndex = res.reduce((iMax, x, i, arr) => x > arr[iMax] ? i : iMax, 0);
                    // Imprime el indice de args y res
                    console.log("" + args[maxIndex] + ": " + res[maxIndex] + " bytes");
                }
            })
        })
    }
}
peso(args)();
// No capturo los errores pq sino se alargaria el codigo, se asume que se insertan bien 
// los nombres de los ficheros y existen de verdad
// Lanzamiento: node act6size act2events.js act2example.js act3example.js act4server.js act6size.js