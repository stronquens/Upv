function fib(n) {
    return (n < 2) ? 1 : fib(n - 2) + fib(n - 1);
}
console.log("iniciando ejecucion...");

setTimeout( // waits 10 ms. then runs function
    function () {
        console.log('M1: Quiero escribir ...');
    }, 
10);

var j = fib(40); // takes more than 1seg
function otherMsg(m, u) {
    console.log(m + ": El resultado es " + u);
}
otherMsg("M2", j); //M2 appears before M1 as the main thread is rarely suspended
setTimeout( // M3 appears after M1
    function () {
        otherMsg('M3', j);
    },
1);