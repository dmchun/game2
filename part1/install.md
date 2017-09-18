# Installation Commune

Cette première partie va préparer votre compte et votre poste pour les interactions avec Azure

## 1. Installation de Azure CLI

Les instructions sur le site de Microsoft : https://docs.microsoft.com/en-us/cli/azure/install-azure-cli?view=azure-cli-latest

## 2. Préparation de votre environnement Azure

### 2.A Par le portail (Défaut)

1. Aller sur le portail Azure : https://portal.azure.com/
2. Se loguer avec son compte SQLI (********@sqli.com)

#### 2.A.1 Créer un nouveau resource group
1. Sélectionner le menu resource groupe
2. Cliquer sur Add
3. Indiquer un nom : `clouding-game-<login-sql>`
4. Choisir la Subscription `NAI1 - Agence Nantes`
5. Choisir la Resource group `East US 2`

_Nous choisissons pour ce jeu, la localisation qui nous coutera le moins cher, mais pour des besoins client, on pourra préférer `West Europe` notamment pour respecter une localisation des données en Europe ou bien améliorer les temps de réponse_

### 2.B Par la CLI (Avancé)

1. Se loguer
```
az login
```
Réponse attendue : `To sign in, use a web browser to open the page https://aka.ms/devicelogin and enter the code ********* to authenticate.`

2. Ouvrir un navigateur sur https://aka.ms/devicelogin et saisir le code fourni en réponse précédente
3. Cliquer sur son compte sqli en cliquant dessus

Réponse attendue dans la CLI:
```
[
  {
    "cloudName": "AzureCloud",
    "id": "<id-subscription>",
    "isDefault": true,
    "name": "*** - **** *****",
    "state": "Enabled",
    "tenantId": "******-*****-****-*****-********",
    "user": {
      "name": "*******@sqli.com",
      "type": "user"
    }
  }
]
```

Votre CLI est authorisée sur le portail Azure par votre compte SQLI

#### 2.A.1 Créer un nouveau resource group
En une seule commande, vous pouvez créer un resource group : 
```
az group create -n clouding-game-<login_sqli> -l westus2
```
Réponse attendue :
{
  "id": "/subscriptions/<id-subscription>/resourceGroups/clouding-game-grenaudin",
  "location": "westus2",
  "managedBy": null,
  "name": "clouding-game-<login_sqli>",
  "properties": {
    "provisioningState": "Succeeded"
  },
  "tags": null
}
