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
	
	( Recorrido Actual a Destino b CosteTotal 0 Nivel 0)
)


(defrule PieXaY
	?c1 <- (Camino Origen ?o Destino ?d Coste ?coste Distrito ?dist)
	?r <- (Recorrido Actual ?o Destino ?dest CosteTotal ?ct Nivel ?n)

 => 
	(printout t ?o crlf)
	()
)




