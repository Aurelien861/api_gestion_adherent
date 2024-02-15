#!/bin/bash

# Démarrer MongoDB en arrière-plan
mongod --replSet rs0 --bind_ip_all --port 27017 &

# Attendre que MongoDB démarre
until mongo --eval "print('attendre le démarrage de MongoDB')" &>/dev/null; do
  sleep 1
done

# Initialiser le Replica Set seulement s'il n'est pas déjà configuré
if mongo --eval "rs.status()" | grep -q "NotYetInitialized"; then
  mongo --eval "
    rs.initiate({
      _id: 'rs0',
      members: [
        { _id: 0, host: 'rs1:27017' },
        { _id: 1, host: 'rs2:27017' },
        { _id: 2, host: 'rs3:27017' }
      ]
    })
  "
fi

# Garder le conteneur actif une fois le script terminé
tail -f /dev/null
