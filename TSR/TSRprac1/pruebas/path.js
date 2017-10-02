// normalize. A partir de una tira representando el path, interpreta los separadores y los
// nombres especiales, y devuelve una nueva tira que corresponde a esa misma ruta
// normalizada
var path = require('path');
path.normalize('/a/.///b/d/../c/')
// '/a/b/c'


// join. A partir de una lista variable de argumentos, los une y normaliza el path
// resultante, devolviendo la tira que corresponde al path normalizado
var url = '/index.html';
path.join(process.cwd(), 'static', url);
// '/home/nico/static/index.html'


// basename, extname y dirname. Permiten extraer los distintos componentes de un
// path
var a = '/a/b/c.html'
path.basename(a)
// 'c.html'
path.extname(a)
// '.html'
path.dirname(a)
// '/a/b'

// exists. Permite comprobar la existencia o no de un path concreto
var path = require('path')
path.exists('/etc', function(exists){
 console.log("Does the file exist?", exists)})
// Does the file exist? true