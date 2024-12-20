# bpi-project

Gestion des bénéficiaires effectifs.

# Documentation pour Lancer et Utiliser le Projet Spring Boot

## Introduction

Ce projet est un service développé avec les technologies suivantes :

- **Spring Boot 3.3**
- **Java 17**
- **Maven 3.9.8**

## Pré-requis

Avant de commencer, assurez-vous d'avoir installé sur votre machine :

1. Java 17
2. Maven 3.9.8
3. Une base de données PostgreSQL (version 16.4 utilisée pour ce projet)

## Étapes pour lancer le projet

### 1. Cloner le projet

Cloner le dépôt du projet à l'aide de la commande suivante :

```bash
$ git clone https://github.com/diallomatine/bpi-project.git
```

### 2. Accéder au dossier du projet

```bash
$ cd bpi-project
```

### 3. Créer une base de données

Créer une base de données nommée `bpi-exo-abdoul` dans PostgreSQL.

### 4. Vérifier les dépendances Maven

Lancer la commande suivante pour télécharger les dépendances du projet :

```bash
$ mvn clean install
```

### 5. Lancer le projet

Exécutez la commande suivante pour démarrer le projet :

```bash
$ mvn spring-boot:run
```

### 6. Initialisation de la base de données

Une fois le projet démarré, exécutez le script SQL suivant pour insérer des données :

```sql
INSERT INTO entreprise (id, nom)
VALUES (1, 'Société A'),
       (2, 'Société B'),
       (3, 'Société C'),
       (4, 'Société D');

INSERT INTO personne_physique (id, prenom, nom)
VALUES (1, 'Yvette', 'Yvette'),
       (2, 'Zoé', 'Zoé'),
       (3, 'Xavier', 'Xavier');

INSERT INTO investissements (id, entreprise_investisseur_id, personne_investisseur_id, entreprise_investi_id, pourcentage)
VALUES (1, NULL, 1, 1, 90.00),
       (2, 1, NULL, 2, 50.00),
       (3, 2, NULL, 3, 60.00),
       (4, NULL, 2, 1, 20.00);
```

Ce script peut être exécuté dans votre outil de gestion de base de données, comme PgAdmin ou tout autre client SQL.

### 7. Tester l'API

Vous pouvez interroger l'API en utilisant l'URL suivante :

```bash
http://localhost:8080/api/beneficiaire?idEntreprise=1&filtre=TOUS
```

#### Paramètres disponibles pour le filtre :

Le paramètre `filtre` peut prendre l'une des valeurs suivantes :

```java
public enum FiltreBeneficiaireEnum {
    TOUS,
    PERSONNE_PHYSIQUE,
    BENEFICIAIRE_EFFECTIF;
}
```

- **TOUS** : Retourne tous les bénéficiaires.
- **PERSONNE_PHYSIQUE** : Retourne uniquement les personnes physiques.
- **BENEFICIAIRE_EFFECTIF** : Retourne uniquement les bénéficiaires effectifs.

## Exemple de réponse de l'API

Un exemple de réponse JSON pourrait ressembler à ceci :

```json
[
  {
    "id": 1,
    "nom": "Société A",
    "beneficiaires": [
      {
        "type": "PERSONNE_PHYSIQUE",
        "prenom": "Yvette",
        "nom": "Yvette",
        "pourcentage": 90.00
      },
      {
        "type": "ENTREPRISE",
        "nom": "Société B",
        "pourcentage": 50.00
      }
    ]
  }
]
```

## Observations et Améliorations

### Travail effectué

Dans cet exercice, seules les fonctionnalités de base pour la récupération des bénéficiaires d'une entreprise ont été implémentées.

### Améliorations envisagées

1. Réduction du nombre de DTOs en optimisant la structure des réponses.
2. Faire en sorte que les requêtes renvoient directement les objets d'entités au lieu des IDs pour simplifier le traitement des données.
3. Amélioration de la lisibilité et de la propreté du code.

### Limitations

1. Les parties optionnelles de l'exercice n'ont pas été réalisées par manque de temps.
2. Une planification inadéquate ce week-end a limité les avancées.
3. Bien que minimal, le travail réalisé montre la faisabilité de l'ensemble de l'exercice avec plus de temps.

## Notes supplémentaires

- Assurez-vous que le port `8080` est disponible sur votre machine.
- Adaptez les informations de connexion à la base de données dans le fichier `application.properties` ou `application.yml` selon votre configuration.

## Conclusion

Avec ces étapes, vous êtes prêt à lancer, initialiser et interroger l'API de votre projet Spring Boot. Si vous avez des questions ou des problèmes, consultez votre équipe ou la documentation officielle de Spring Boot.

