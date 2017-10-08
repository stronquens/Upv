
(defglobal ?*nod-gen* = 0)
(deffacts Grafo
	( Camino Origen a Destino b Coste 10 Tipo ambos )
	( Camino Origen a Destino c Coste 8 Tipo pie )
	( Camino Origen a Destino e Coste 10 Tipo ambos )

	( Camino Origen b Destino f Coste 6 Tipo pie)
	( Camino Origen b Destino c Coste 5 Tipo pie)
	
	( Camino Origen c Destino g Coste 6 Tipo pie)
	( Camino Origen c Destino h Coste 6 Tipo pie)
	( Camino Origen c Destino d Coste 14 Tipo pie)
	
	( Camino Origen d Destino h Coste 14 Tipo ambos)
	
	( Camino Origen e Destino i Coste 20 Tipo pie)
	( Camino Origen e Destino j Coste 9 Tipo ambos)
	
	( Camino Origen f Destino k Coste 10 Tipo pie)
	( Camino Origen f Destino l Coste 6 Tipo pie)
	
	( Camino Origen g Destino l Coste 9 Tipo pie)
	( Camino Origen g Destino m Coste 12 Tipo pie)
	( Camino Origen g Destino h Coste 8 Tipo pie)
	
	( Camino Origen h Destino i Coste 12 Tipo ambos)
	
	( Camino Origen i Destino o Coste 2 Tipo pie)
	
	( Camino Origen j Destino o Coste 7 Tipo ambos)
	
	( Camino Origen k Destino l Coste 2 Tipo ambos)
	
	( Camino Origen l Destino p Coste 6 Tipo ambos)
	( Camino Origen l Destino m Coste 7 Tipo ambos)
	
	( Camino Origen m Destino q Coste 2 Tipo pie)
	
	( Camino Origen n Destino q Coste 6 Tipo pie)
	
	( Camino Origen o Destino n Coste 8 Tipo ambos)
	
	( Camino Origen p Destino r Coste 4 Tipo ambos)
	( Camino Origen p Destino q Coste 3 Tipo pie)
	
	( Camino Origen q Destino r Coste 3 Tipo pie)
	
	
	( Nodo Letra a Tipo normal Distrito 0 )
	
	( Nodo Letra b Tipo bicicleta Distrito 1 )
	( Nodo Letra b Tipo bicicleta Distrito 1 )
	( Nodo Letra d Tipo normal Distrito 1 )
	( Nodo Letra e Tipo normal Distrito 1 )
	( Nodo Letra j Tipo bicicleta Distrito 1 )
	
	( Nodo Letra f Tipo normal Distrito 2 )
    ( Nodo Letra g Tipo normal Distrito 2 )
	( Nodo Letra h Tipo bicicleta Distrito 2 )
	( Nodo Letra i Tipo normal Distrito 2 )
	( Nodo Letra o Tipo normal Distrito 2 )

	( Nodo Letra k Tipo bicicleta Distrito 3 )
	( Nodo Letra l Tipo normal Distrito 3 )
	( Nodo Letra m Tipo bicicleta Distrito 3 )
	( Nodo Letra n Tipo bicicleta Distrito 3 )

    ( Nodo Letra p Tipo normal Distrito 4 )
	( Nodo Letra q Tipo normal Distrito 4 )

	( Nodo Letra r Tipo bicicleta Distrito 5 )
	
	( Recorrido Actual a Destino b Bici false CosteTotal 0 Nivel 0)
)

(defrule PieXaY
	(declare (salience 70))
	?r <- ( Recorrido Actual ?ori Destino ?dest Bici false CosteTotal ?costet Nivel ?n )
	?c1 <- ( Camino Origen ?ori Destino ?d Coste ?coste Tipo ?t )
	
 => 
	(assert(Recorrido Actual ?d Destino ?dest Bici false CosteTotal (+ ?costet ?coste) Nivel (+ ?n 1)))
	(bind ?*nod-gen* (+ ?*nod-gen* 1))
)

(defrule BiciXaY
	(declare (salience 90))
	?r <- ( Recorrido Actual ?ori Destino ?dest Bici true CosteTotal ?costet Nivel ?n )
	?c1 <- ( Camino Origen ?ori Destino ?d Coste ?coste Tipo ambos )
=>
	(assert(Recorrido Actual ?d Destino ?dest Bici true CosteTotal (+ ?costet (/ ?coste 2)) Nivel (+ ?n 1)))
	(bind ?*nod-gen* (+ ?*nod-gen* 1))
)

(defrule cogerBici
(declare (salience 50))
	?r <- ( Recorrido Actual ?ori $?a Bici false CosteTotal ?cost $?b )
	?n <- ( Nodo Letra ?ori Tipo bicicleta $?)
=>
	(assert (Recorrido Actual ?ori $?a Bici true CosteTotal (+ ?cost 1) $?b))
)

(defrule dejarBici
(declare (salience 40))
	?r <- ( Recorrido Actual ?ori $?a Bici true CosteTotal ?cost $?b )
	?n <- ( Nodo Letra ?ori Tipo bicicleta $?)
=>
	(assert (Recorrido Actual ?ori $?a Bici false CosteTotal (+ ?cost 1) $?b))
)

(defrule parada
(declare (salience 100))
	?r <- ( Recorrido Actual ?act Destino ?act Bici false CosteTotal ?cost Nivel ?n )
=>
	(printout t "LLEGO AL FINALCON COSTE  " ?cost crlf)
	(printout t "SOLUCION ENCONTRADA EN EL NIVEL " ?n crlf)
	(printout t "NUMERO DE NODOS EXPANDIDOS O REGLAS DISPARADAS " ?*nod-gen* crlf)
	(halt)
)
