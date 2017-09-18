


# PAAS Azure

*App Service Web Apps* est une plateforme de calcul entièrement gérée, optimisée pour l’hébergement de sites et d’applications web. Cette offre PaaS (Plateforme en tant que service) de Microsoft Azure vous permet de donner la priorité à votre logique métier tandis qu’Azure gère l’infrastructure servant à exécuter et à faire évoluer vos applications.

[App Service Web - Get Started nodejs](https://docs.microsoft.com/fr-fr/azure/app-service-web/app-service-web-get-started-nodejs)
```
TODO
```


# FAAS

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