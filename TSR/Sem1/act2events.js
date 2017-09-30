/**
 * Created by stronquens on 30/9/17.
 */
var ev = require('events');
var emitter = new ev.EventEmitter;

// Definiciones
function Listener() {
    this.cont1 = 0 ;
    this.cont2 = 0 ;
}
Listener.prototype.event1 = function () {
    //console.log(`Listener activo: ${ this.cont1 } eventos de tipo uno.`);
    console.log("Listener activo: " + ++this.cont1 + " eventos de tipo uno.");

}
Listener.prototype.event2 = function () {
    this.cont2++;
    if(this.cont2 <= this.cont1){
        console.log("Hay mas eventos de tipo uno");

    }else{
        console.log("Evento dos");
    }
}
Listener.prototype.event3 =function () {
    console.log("Evento tres."+time2);
    if(time2 < 15000){
        clearInterval(interval2);
        time2 = time2*3;
        setInterval(function () { emitter.emit("dos")}, time2 );
    }else{
        clearInterval(interval2);
        time2 = 18000;
        setInterval(function () { emitter.emit("dos")}, time2 );
    }
}

/// Añado eventos
var lis = new Listener();
emitter.on("uno", function () {lis.event1()});
emitter.on("dos", function () {lis.event2()});
emitter.on("tres", function () {lis.event3()});


// Ejecucion
setInterval( function () { emitter.emit("uno")}, 3000 );
var time2 = 2000;
var interval2 = setInterval( function () { emitter.emit("dos")}, time2 );
setInterval( function () { emitter.emit("tres")}, 10000 );

