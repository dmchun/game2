<center><img src="./images/paas_robot.png" width="200"></center>

# Instructions de Jeu pour Paas Robot

Dans ce jeu nous allons décrire une seule possibilité de travail avec ACS : l'implémentation via [Kubernetes](https://kubernetes.io) et des conteneurs [Docker](https://www.docker.com)

L'ensemble des étapes se repose sur la documentation Microsoft : [Fonctionnement de Azure Container Service avec Kubernetes](https://docs.microsoft.com/en-us/azure/container-service/kubernetes/container-service-kubernetes-walkthrough)

Vous allez devoir gérer vos déploiements via des containers Docker. Vous aurez donc besoin de créer un compte sur un registry Docker accessible par les environnements Azure.


## Etapes

Pour déployer votre image, vous allez devoir : 

1. Vous créer un compte DockerHub
1. Créer une image Docker avec votre code source et ses dépendances d'exécution (Node/NPM/...)
2. Créer votre cluster   Kubernetes
3. Déployer une première fois
4. Déployer les images mises à jour

## Créer votre compte et dépôt DockerHub

Nous vous conseillons donc de créer un compte pour vous même (Vous pourrez l'utiliser après ce Clouding Game) ou votre équipe sur [DockerHub](https://hub.docker.com) => SignUp !

Login = Identifiant du dépôt

## Créer/Pousser votre image Docker

* Construire une image Docker à partir d'un `Dockerfile` dans le répertoire courant

```shell
docker build -t <ID_compte_dockerhub>:masuperappl:latest .
```

* Pousser son image dans son dépôt DockerHub

```shell
docker push <ID_compte_dockerhub>:masuperappl:latest
```

_Hey n'oubliez pas qu'il faudra la reconstruire à l'udpate... Je dis ça, je ne dis rien :) _

## Créer le cluster Kubernetes 

### Par la console

https://portal.azure.com/#blade/HubsExtension/Resources/resourceType/Microsoft.ContainerService%2FcontainerServices

### Par la CLI

```shell
az acs create --orchestrator-type kubernetes --resource-group <myResourceGroup> --name <myK8sCluster> --generate-ssh-keys --agent-count 1
```
_Remplacer les valeurs entre chevrons par les votres_

## Se connecter au cluster

### Par la console

### Par la CLI
```shell
az acs kubernetes get-credentials --resource-group=<myResourceGroup> --name=<myK8sCluster>
```
_Remplacer les valeurs entre chevrons par les votres_

Et tester : 
```shell
kubectl get nodes
```

## Déployer une première fois

Il faut créer un fichier de configuration Kubernetes au format YAML => https://docs.microsoft.com/en-us/azure/container-service/kubernetes/container-service-kubernetes-walkthrough#run-the-application

**Template:**

```yaml
apiVersion: apps/v1beta1
kind: Deployment
metadata:
  name: <project_name>
spec:
  replicas: 1
  template:
    metadata:
      labels:
        app: <project_name>
    spec:
      containers:
      - name: <project_name>
        image: <id_depot_docker_hub>/<image_name>:latest
        ports:
        - containerPort: <open_port_container>
---
apiVersion: v1
kind: Service
metadata:
  name: <project_name>
spec:
  type: LoadBalancer
  ports:
  - port: <port_a_exposer>
  selector:
    app: <project_name>
```




Adapter les noms d'application, port 

* Puis déployer le fichier sur Azure

```shell
kubectl create -f azure-kub-app.yml
```

* Surveillez le déploiement par la console Web ou par CLI

```shell
kubectl get service sqli-clouding-game --watch
```


## Vous êtes lancés ... en vrac ...

### Scaler

https://docs.microsoft.com/en-us/azure/container-service/kubernetes/container-service-tutorial-kubernetes-scale

```shell
kubectl scale --replicas=5 deployment/<project_name>
```

### Updater

https://docs.microsoft.com/en-us/azure/container-service/kubernetes/container-service-tutorial-kubernetes-app-update

```shell
kubectl set image deployment <project_name> <project_name>=<id_depot_docker_hub>/<image_name>:latest
```

_Tips : Vous voulez mettre à jour de manière transparente?? il vous faudra peut-être plusieurs pods actifs..._

