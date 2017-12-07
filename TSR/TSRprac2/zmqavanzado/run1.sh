#!/bin/bash

node mybroker1 &
node myworker1 WORKER1 R Ready DONE1 &
node myworker1 WORKER2 G Ready DONE2 &
node myworker1 WORKER3 B Ready DONE3 &

for i in {1..33}
do
    node myclient1 "cliente $i" R work &
done
for i in {34..68}
do
    node myclient1 "cliente $i" G work &
done
for i in {69..100}
do
    node myclient1 "cliente $i" B work &
done
wait;