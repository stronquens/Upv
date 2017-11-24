#!/bin/bash

node myworker_vp tcp://mi-IP-externa:8060 WORKER1 Ready DONE &
node myworker_vp tcp://mi-IP-externa:8060 WORKER2 Ready OK &
node mybroker_vp

for i in {1..100}
do
    node myclient_vp tcp://localhost:8059 "cliente $i" work true &
done
wait;