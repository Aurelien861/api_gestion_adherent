#!/bin/bash

mongod --replSet rs0 --bind_ip_all --port 27017 &

until mongo --host rs1 --eval "print('attendre la connexion à rs1')" &>/dev/null; do
  sleep 1
done

until mongo --host rs2 --eval "print('attendre la connexion à rs2')" &>/dev/null; do
  sleep 1
done

until mongo --host rs3 --eval "print('attendre la connexion à rs3')" &>/dev/null; do
  sleep 1
done

mongo --host rs1 <<EOF
rs.initiate({
  _id: "rs0",
  members: [
    { _id: 0, host: "rs1:27017" },
    { _id: 1, host: "rs2:27017" },
    { _id: 2, host: "rs3:27017" }
  ]
})
EOF
