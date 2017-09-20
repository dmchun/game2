# Partie 2 : Les specs changent !

A 10 jours de la mise en production, la MOA se réveille... Pour améliorer l'expérience utilisateur, il est nécessaire de lui répondre personnellement : Dynamisez votre service !

## Spécifications (c'est pas du swagger mais c'est swag quand même non?)

Exposez un nouveau service REST qui répond sur une requête GET sur /hello/:name (id est dynamique) la réponse suivante : 
  * Code Retour : 200
  * Header : Content-Type='text/plain'
  * Contenu : This is hello for ${name}!
  
    _Remplacez ${name} par le paramètre du path_

## Instructions :

1. Prendre en compte les modifications
2. Appelez les organisateurs avant la mise à jour
    * Fournir l'URL
3. Appelez les organisateurs après la mise à jour