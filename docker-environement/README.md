EN GROOOOOOOOOOOOOOOOOOOOOOOOOOOOOS :

1. Lancer Docker Compose

- ouvrir un terminal et se placer dans le répertoire du fichier **docker-compose.yml**
- exécuter la commande : 
``docker-compose up -d``

2. Initialiser le Replica Set MongoDB

- après le démarrage des conteneurs, il faut se connecter au shell MongoDB de l'un des membres du Replica Set
- par exemple, pour se connecter à **rs1** : 
``docker exec -it rs1 mongo``
- une fois dans le shell MongoDB, exécute la commande suivante pour initialiser le Replica Set :
````
rs.initiate({
  _id: "rs0",
  members: [
      { _id: 0, host: "rs1:27017" },
      { _id: 1, host: "rs2:27017" },
      { _id: 2, host: "rs3:27017" }
  ]
})
````

3. Vérifier l'état du Replica Set

- toujours dans le shell MongoDB, tu peux vérifier l'état du Replica Set en exécutant :
``rs.status()``

4. Gestion des Conteneurs

- pour arrêter les conteneurs, exécute :
``docker-compose down``