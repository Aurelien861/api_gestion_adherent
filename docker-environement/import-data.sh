#!/bin/bash
mongoimport --host mongo --db gestionadherentbdd --collection commandes --type json --file /data/Commandes.json --jsonArray --mode upsert
mongoimport --host mongo --db gestionadherentbdd --collection groupes --type json --file /data/Groupes.json --jsonArray --mode upsert
mongoimport --host mongo --db gestionadherentbdd --collection materiels --type json --file /data/Materiels.json --jsonArray --mode upsert
mongoimport --host mongo --db gestionadherentbdd --collection membres --type json --file /data/Membres.json --jsonArray --mode upsert
