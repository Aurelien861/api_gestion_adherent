#!/bin/bash

# Attendre que MongoDB soit prêt
until mongo --host rs1 --eval "print('attendre la connexion à MongoDB...')" &>/dev/null; do
  sleep 1
done

echo "MongoDB démarré. Initialisation du Replica Set..."

# Initialiser le Replica Set
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

echo "Replica Set initialisé."
