# CAAS Azure Container Service - The Robot

*Azure Container Service* est un environnement d'exécution de container Docker qui se base entièrement sur l'orchestrateur Kubernetes. A la croisée entre le PAAS (Plateform As A Service) et un nouveau concept appelé le CAAS (Container As A Service). Redoutable pour gérer finement la scalabilité d'une application et gérer des problématiques de déploiement tels que : A/B Testing, Blue/Green Deployment ou Infrastructure immuable.

[Azure Container Service](https://docs.microsoft.com/en-us/azure/container-service/kubernetes/container-service-kubernetes-walkthrough)
```
TODO
```


# PAAS Azure - The Ninja

*App Service Web Apps* est une plateforme de calcul entièrement gérée, optimisée pour l’hébergement de sites et d’applications web. Cette offre PaaS (Plateforme en tant que service) de Microsoft Azure vous permet de donner la priorité à votre logique métier tandis qu’Azure gère l’infrastructure servant à exécuter et à faire évoluer vos applications.

[App Service Web - Get Started nodejs](https://docs.microsoft.com/fr-fr/azure/app-service-web/app-service-web-get-started-nodejs)
```
TODO
```


# FAAS - The extraterrestre

*Azure Functions* vous permet d’exécuter votre code dans un environnement sans serveur et sans avoir à créer une machine virtuelle ou à publier une application web au préalable

[Functions - Create first Azure function](https://docs.microsoft.com/fr-fr/azure/azure-functions/functions-create-first-azure-function)

Code source de la function
```
    context.log('JavaScript HTTP trigger function processed a request.');

    if (req.query.name || (req.body && req.body.name)) {
        context.res = {
            // status: 200, /* Defaults to 200 */
            body: "Hello " + (req.query.name || req.body.name)
        };
    }
    else {
        context.res = {
            status: 400,
            body: "Please pass a name on the query string or in the request body"
        };
    }
    context.done();
```