#!/bin/bash

node mybroker_vp &
node myworker_vp tcp://localhost:8060 WORKER1 Ready DONE &
node myworker_vp tcp://localhost:8060 WORKER2 Ready OK &

for i in {1..100}
do
    node myclient_vp tcp://localhost:8059 "cliente $i" work true &
done
wait;