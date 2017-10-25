
(defglobal ?*nod-gen* = 0)
(defglobal ?*f* = 0)

;; =========================================================
;; ===                   HECHOS                           ==
;; =========================================================


(deffacts Grafo
	( Camino Origen a Destino b Coste 10 Tipo ambos )
	( Camino Origen a Destino c Coste 8 Tipo pie )
	( Camino Origen a Destino e Coste 10 Tipo ambos )

	( Camino Origen b Destino a Coste 10 Tipo ambos)
	( Camino Origen b Destino c Coste 5 Tipo pie)	
	( Camino Origen b Destino f Coste 6 Tipo pie)
	
	( Camino Origen c Destino a Coste 8 Tipo pie)
	( Camino Origen c Destino b Coste 5 Tipo pie)
	( Camino Origen c Destino d Coste 6 Tipo pie)	
	( Camino Origen c Destino g Coste 6 Tipo pie)
	( Camino Origen c Destino h Coste 6 Tipo pie)
	
	( Camino Origen d Destino c Coste 6 Tipo pie)
	( Camino Origen d Destino h Coste 14 Tipo ambos)
	
	( Camino Origen e Destino a Coste 10 Tipo ambos)
	( Camino Origen e Destino i Coste 20 Tipo pie)
	( Camino Origen e Destino j Coste 9 Tipo ambos)
	
	( Camino Origen f Destino b Coste 6 Tipo pie)	
	( Camino Origen f Destino k Coste 10 Tipo pie)
	( Camino Origen f Destino l Coste 6 Tipo pie)
	
	( Camino Origen g Destino c Coste 6 Tipo pie)	
	( Camino Origen g Destino h Coste 8 Tipo pie)	
	( Camino Origen g Destino l Coste 9 Tipo pie)
	( Camino Origen g Destino m Coste 12 Tipo pie)
	
	( Camino Origen h Destino d Coste 14 Tipo ambos)
	( Camino Origen h Destino g Coste 8 Tipo pie)
	( Camino Origen h Destino i Coste 12 Tipo ambos)
	( Camino Origen h Destino c Coste 6 Tipo pie)
	
	( Camino Origen i Destino e Coste 20 Tipo pie)
	( Camino Origen i Destino h Coste 12 Tipo ambos)
	( Camino Origen i Destino o Coste 2 Tipo pie)
	
	( Camino Origen j Destino o Coste 7 Tipo ambos)
	( Camino Origen j Destino e Coste 9 Tipo ambos)
	
	( Camino Origen k Destino l Coste 2 Tipo ambos)
	( Camino Origen k Destino f Coste 10 Tipo pie)
	
	( Camino Origen l Destino p Coste 6 Tipo ambos)
	( Camino Origen l Destino m Coste 7 Tipo ambos)
	( Camino Origen l Destino g Coste 9 Tipo pie)
	( Camino Origen l Destino k Coste 2 Tipo ambos)
	( Camino Origen l Destino f Coste 6 Tipo pie)
	
	( Camino Origen m Destino q Coste 2 Tipo pie)
	( Camino Origen m Destino g Coste 12 Tipo pie)
	( Camino Origen m Destino l Coste 7 Tipo ambos)
	
	( Camino Origen n Destino q Coste 6 Tipo pie)
	( Camino Origen n Destino o Coste 8 Tipo ambos)
	
	( Camino Origen o Destino n Coste 8 Tipo ambos)
	( Camino Origen o Destino j Coste 7 Tipo ambos)
	( Camino Origen o Destino i Coste 2 Tipo pie)
	
	( Camino Origen p Destino r Coste 4 Tipo ambos)
	( Camino Origen p Destino q Coste 2 Tipo pie)
	( Camino Origen p Destino l Coste 6 Tipo ambos)
	
	( Camino Origen q Destino r Coste 3 Tipo pie)
	( Camino Origen q Destino m Coste 2 Tipo pie)
	( Camino Origen q Destino n Coste 6 Tipo pie)
	( Camino Origen q Destino p Coste 2 Tipo pie)

	( Camino Origen r Destino p Coste 4 Tipo ambos)
	( Camino Origen r Destino q Coste 3 Tipo pie)
	
	( Nodo Letra a Tipo bicicleta Barrio 1 )
	
	( Nodo Letra b Tipo bicicleta Barrio 2 )
	( Nodo Letra c Tipo normal Barrio 2 )
	( Nodo Letra d Tipo normal Barrio 2 )
	( Nodo Letra e Tipo normal Barrio 2 )
	( Nodo Letra j Tipo bicicleta Barrio 2 )
	
	( Nodo Letra f Tipo normal Barrio 3 )
    	( Nodo Letra g Tipo normal Barrio 3 )
	( Nodo Letra h Tipo bicicleta Barrio 3 )
	( Nodo Letra i Tipo normal Barrio 3 )
	( Nodo Letra o Tipo normal Barrio 3 )

	( Nodo Letra k Tipo bicicleta Barrio 4 )
	( Nodo Letra l Tipo normal Barrio 4 )
	( Nodo Letra m Tipo bicicleta Barrio 4 )
	( Nodo Letra n Tipo bicicleta Barrio 4 )

    	( Nodo Letra p Tipo normal Barrio 5 )
	( Nodo Letra q Tipo normal Barrio 5 )

	( Nodo Letra r Tipo bicicleta Barrio 6 )

	(arco_min a 10)
	(arco_min b 5)
	(arco_min c 5)
	(arco_min d 6)
	(arco_min e 9)
	(arco_min f 6)
	(arco_min g 6)
	(arco_min h 6)
	(arco_min i 2)
	(arco_min j 7)
	(arco_min k 2)
	(arco_min l 2)
	(arco_min m 2)
	(arco_min n 6)
	(arco_min o 2)
	(arco_min p 2)
	(arco_min q 2)
	(arco_min r 3)
	
	( Recorrido Actual a Destino r Bici false CosteTotal 0 Nivel 0)
)

;; =========================================================
;; ===              H E U R I S T I C A                   ==
;; =========================================================

; h(n)=|DistBarrios(n)|*min(Cam(n))*Sit(n) 

(deffunction heuristica (?bar1 ?bar2 ?min ?bici ?flag)
	(bind ?bar (abs (- ?bar1 ?bar2))) 												;|DistBarrios(n)|
	(if (eq ?bar 0) then (bind ?bar (+ ?bar 1)))
	(bind ?sit (if (or (eq ?bici true) (eq ?flag bicicleta)) then 0.5 else 1)) 		;Sit(n) 
	(bind ?mult (* (* ?bar ?min) ?sit))
	(return ?mult) 																	;|DistBarrios(n)|*min(Cam(n))*Sit(n) 
)

(deffunction control (?c ?bar1 ?bar2 ?min ?bici ?flag)
	(bind ?*f* (heuristica ?bar1 ?bar2 ?min ?bici ?flag))
	(bind ?*f* (+ ?*f* ?c))
	(bind ?*f* (div ?*f* 1)) 	; redondear entero
)

; =========================   Iniciar programa con (inicio) problemas en mac ================= 
(deffunction inicio ()
    (reset)
	(printout t "Profundidad Maxima:= " )
	(bind ?prof (read))
	(printout t "Tipo de Busqueda " crlf "    1.- Anchura" crlf "    2.- Profundidad" crlf )
	(bind ?a (read))
	(if (= ?a 1)
	       then    (set-strategy breadth)
	       else   (set-strategy depth))
    (printout t " Ejecuta run para poner en marcha el programa " crlf)
	(assert (profundidad-maxima ?prof))
	(set-salience-evaluation when-activated)
	;(run)
)

;; =========================================================
;; ===                       Reglas                       ==
;; =========================================================

(defrule PieXaY
	(declare (salience (- 0 ?*f*)))
	(Recorrido Actual ?ori Destino ?dest Bici false CosteTotal ?costet Nivel ?n)
	(Camino Origen ?ori Destino ?d Coste ?coste Tipo ?t)
	(profundidad-maxima ?prof)

	( Nodo Letra ?ori Tipo ?flag Barrio ?level1 )
	( Nodo Letra ?dest $?algo2 Barrio ?level2 )
	(arco_min ?ori ?min)

	(test (< ?n ?prof))
	(test (control (+ ?costet ?coste) ?level1 ?level2 ?min false ?flag))
 => 
	(assert(Recorrido Actual ?d Destino ?dest Bici false CosteTotal (+ ?costet ?coste) Nivel (+ ?n 1)))
	(bind ?*nod-gen* (+ ?*nod-gen* 1))
)

(defrule BiciXaY
	(declare (salience (- 0 ?*f*)))
	( Recorrido Actual ?ori Destino ?dest Bici true CosteTotal ?costet Nivel ?n )
	( Camino Origen ?ori Destino ?d Coste ?coste Tipo ambos )
	(profundidad-maxima ?prof)

	( Nodo Letra ?ori Tipo ?flag Barrio ?level1 )
	( Nodo Letra ?dest $?algo2 Barrio ?level2 )
	(arco_min ?ori ?min)

	(test (< ?n ?prof))
	;(test (neq ?d ?dest))
	(test (control (+ ?costet (div ?coste 2)) ?level1 ?level2 ?min true ?flag))	
=>
	(assert(Recorrido Actual ?d Destino ?dest Bici true CosteTotal (+ ?costet (div ?coste 2)) Nivel (+ ?n 1)))
	(bind ?*nod-gen* (+ ?*nod-gen* 1))
)

(defrule dejarBici
	(declare (salience (- 0 ?*f*)))
	( Recorrido Actual ?ori Destino ?dest Bici true CosteTotal ?costet Nivel ?n )
	( Nodo Letra ?ori Tipo bicicleta Barrio ?level1)
	(profundidad-maxima ?prof)

	( Nodo Letra ?dest $?algo2 Barrio ?level2 )
	(arco_min ?ori ?min)
	
	(test (< ?n ?prof))
	(test (control (+ ?costet 1) ?level1 ?level2 ?min true bicicleta))	
=>
	(assert (Recorrido Actual ?ori Destino ?dest Bici false CosteTotal (+ ?costet 1) Nivel (+ ?n 1)))
	(bind ?*nod-gen* (+ ?*nod-gen* 1))
)

(defrule cogerBici
	(declare (salience (- 0 ?*f*)))
	( Recorrido Actual ?ori Destino ?dest Bici false CosteTotal ?costet Nivel ?n )
	( Nodo Letra ?ori Tipo bicicleta Barrio ?level1)
	(profundidad-maxima ?prof)

	( Nodo Letra ?dest $?algo2 Barrio ?level2 )
	(arco_min ?ori ?min)
	
	(test (< ?n ?prof))
	(test (control (+ ?costet 1) ?level1 ?level2 ?min false bicicleta))	
=>
	(assert (Recorrido Actual ?ori Destino ?dest Bici true CosteTotal (+ ?costet 1) Nivel (+ ?n 1)))
	(bind ?*nod-gen* (+ ?*nod-gen* 1))
)

(defrule parada
	(declare (salience (- 0 ?*f*)))
	( Recorrido Actual ?act Destino ?act Bici false CosteTotal ?costet Nivel ?n )
	
	( Nodo Letra ?act Tipo ?flag Barrio ?level1 )
	(arco_min ?act ?min)
	
	(test (control ?costet ?level1 ?level1 ?min false ?flag))	
=>
	(printout t "LLEGO AL FINALCON COSTE  " ?costet crlf)
	(printout t "SOLUCION ENCONTRADA EN EL NIVEL " ?n crlf)
	(printout t "NUMERO DE NODOS EXPANDIDOS O REGLAS DISPARADAS " ?*nod-gen* crlf)
	(halt)
)
