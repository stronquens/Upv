;; =========================================================
;; ===     A N C H U R A   Y    P R O F U N D I D A D   ====
;; =========================================================

(deffacts base_hechos

	(usuario origen A destino M bicicleta false coste1 0 nivel 0)	
	
	(estacion A)	
	(estacion B)
	(estacion H)
	(estacion J)
	(estacion K)
	(estacion M)
	(estacion N)
	(estacion R)

	(camino A B coste 10 tipo bicicleta)
	(camino A C coste 8 tipo pie)
	(camino A E coste 10 tipo bicicleta)
	(camino B C coste 5 tipo pie)
	(camino B F coste 6 tipo pie)
	(camino C D coste 6 tipo pie)
	(camino C H coste 6 tipo pie)
	(camino C G coste 6 tipo pie)
	(camino D H coste 14 tipo bicicleta)
	(camino E I coste 20 tipo pie)
	(camino E J coste 9 tipo bicicleta)
	(camino F K coste 10 tipo pie)
	(camino F L coste 6 tipo pie)
	(camino G H coste 8 tipo pie)
	(camino G L coste 9 tipo pie)
	(camino G M coste 12 tipo pie)
	(camino H I coste 12 tipo bicicleta)
	(camino I O coste 2 tipo pie)
	(camino J O coste 7 tipo bicicleta)
	(camino K L coste 2 tipo bicicleta)
	(camino L M coste 7 tipo bicicleta)
	(camino L P coste 6 tipo bicicleta)
	(camino M Q coste 2 tipo pie)
	(camino N Q coste 6 tipo pie)
	(camino N O coste 8 tipo bicicleta)
	(camino P Q coste 2 tipo pie)
	(camino P R coste 4 tipo bicicleta)
	(camino Q R coste 3 tipo pie)
	
)

(defrule ir_a_pie
	?f <- (usuario origen ?o destino ?d bicicleta false coste1 ?c nivel ?n)
	(camino ?o ?dd coste ?cn tipo ?)
	
	=>
	(assert(usuario origen ?dd destino ?d bicicleta false coste1 (+ ?c ?cn) nivel (+ ?n 1))))

(defrule ir_en_bici
	?f <- (usuario origen ?o destino ?d bicicleta true coste1 ?c nivel ?n)
	(camino ?o ?dd coste ?cn tipo bicicleta)
	=>
	(assert(usuario origen ?dd destino ?d bicicleta true coste1 (+ ?c (/ ?cn 2)) nivel (+ ?n 1))))

(defrule coger_bici
	?f <- (usuario origen ?o destino ?d bicicleta false coste1 ?c nivel ?n)
	(estacion ?o)

	=>
	(assert(usuario origen ?o destino ?d bicicleta true coste1 (+ ?c 1) nivel (+ ?n 1))))

(defrule dejar_bici
	?f <- (usuario origen ?o destino ?d bicicleta true coste1 ?c nivel ?n)
	(estacion ?o)

	=>
	(assert(usuario origen ?o destino ?d bicicleta false coste1 (+ ?c 1) nivel (+ ?n 1))))


(defrule objetivo
	(declare (salience 100))
	?f <-(usuario origen ?d destino ?d bicicleta false coste1 ?c nivel ?n)
	
	=>
	(printout t "DESTINO ALCANZADO EN EL NIVEL: " ?n crlf)
	(printout t "COSTE TOTAL: " ?c crlf)
	(halt))
