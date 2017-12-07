#!/bin/bash

# Este fichero es meramente explicativo, no es ejecutable
node mybroker &

node myworker_vp tcp://localhost:8060 WORKER1 Ready Answer1 &
node myworker_vp tcp://localhost:8060 WORKER2 Ready Answer2 &
node myworker_vp tcp://localhost:8060 WORKER3 Ready Answer3 &

# Matamos el ultimo worker y ejecutamos 3 clientes
node myclient & node myclient & node myclient &
# El resultado es que un cliente se queda esperando sin ser atendido mientras los otros reciben
# respuesta y terminan la ejecucion

killall node
# eliminamos todos los procesos de node y realizamos la misma operacion con
node mybroker2 &
# El resultado tras matar un worker y lanzar tres clientes es, que el cliente que antes no era atendido 
# por nadie ahora si que es atendido por uno de los otros 2 workers operativos y por tanto los 3 clientes
# terminan su ejecucion