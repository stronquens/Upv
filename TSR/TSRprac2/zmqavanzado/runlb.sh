node lbbroker &
node lbworker WORKER1 &
node lbworker WORKER2 &
node lbworker WORKER3 &

for i in {1..100}
do
    node myclient_vp tcp://localhost:8059 "cliente $i" work true &
done
wait;