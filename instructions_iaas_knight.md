[Créer une application Node.js sur Azure]('https://docs.microsoft.com/fr-fr/azure/app-service/app-service-web-get-started-nodejs')

[Liste des commandes Azure CLI ]('https://docs.microsoft.com/fr-fr/azure/virtual-machines/linux/cli-manage') 

#Etapes Iaas pour Web UI et CLI 
####Créer un groupe de ressources (si exisidéjà définit passer à l'étape suivante)

####Web UI:
Faire Groupes de ressources > Ajouter, puis suivre les instructions

####CLI:
```
az group create --name <testResourceGroup> --location <northeurope>
```

##Créer une VM

####Web UI:
Faire Nouveau > Compute > puis choisir son type de distribution, puis suivre les instructions

####CLI: Ubuntu
```
az vm create --resource-group <nomDuGroupeRessource> --name <nomDeVM> --image UbuntuLTS --generate-ssh-keys
```

####CLI: Windows
```
az vm create --resource-group myResourceGroup --name <nomDeVM> --image win2016datacenter --admin-username <nomUtilisateur> --admin-password <motDePasse>
```

[Info]('https://docs.microsoft.com/en-us/azure/virtual-machines/windows/cli-ps-findimage')

##Ouvrir le port 8080
####Web UI:
Faire Groupes de ressources > "Sa ressource" > "NomVM"NSG > "Inbound security rules", puis ajouter une nouvelle règle pour 8080

#####CLI:
```
az vm open-port --port 8080 --resource-group <nomDuGroupeRessource> --name <nomDeVM>
```

##Sur la VM:
*   utiliser ssh pour s'y connecter

####Installer et configurer son environnement
*   Node.js
*   Npm
*   Git
*   Editeur de texte (en option)

####Cloner dépôt Git:
https://github.com/sqli-nantes/clouding-game

####Exécuter l'application.
#Bon courage !! A disposition en cas de besoin :-)  




