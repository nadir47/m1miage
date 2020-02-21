# DATA CONTROLER & ANONYMISER - BACKLOG 📈✅

## Description de la Solution
### Caractéristiques de la Solution

Création du socle d'un projet qui vérifie et anonymise des données. L'application lira et écrirera des fichiers au format CSV. 

À l'avenir l'appli devra lire et écrire d'autres formats de données. 

Le projet doit pouvoir être éxecuté de deux manière différentes, l'une pour vérifier les données et l'autre pour les anonymiser.


### Acteurs du Projet

* 🐬 - Émerite NEOU - Maître d'ouvrage - [emerite-neou](https://github.com/emerite-neou)
* 🇩🇿 - Nadir NADJEM - [NadirOmega](https://github.com/NadirOmega)
* 🇫🇷 - Yannis LE GUEN - [yLGN](https://github.com/yLGN) 
 
### Hébergement

*	🌍 On-premise

### Application utilisée

*	IDE
	*	Eclipse - [www.eclipse.org](https://www.eclipse.org/)

### Langage de programmation, Librairies & Frameworks

* Java
* JUnits
* JSON
* Log4j

### Base de données

*	anon.json
*	check.json
*	desc.json

### Document de référence

[Énoncé](https://github.com/emerite-neou/2019-DAUPHINE-M1/blob/master/projet/sujet.md)

## Aspects fonctionnels

### Service Level Agreement

* Vérifier des données à partir d'un fichier CSV et d'une base de règles.
* Anonymiser des données à partir d'un fichier CSV et d'une base de règles.

## Généralités fonctionnelles

### Lots & Fonctionnalités Principales Associées 

|Lot |Fonctionnalité |Contenu|
|:--------:|:-------------:|:-----|
| 1 |  FP1 | Vérifier des données  |
| 2 |    FP2  |Anonymyser des données|

### Cas d’utilisations

#### Cas d’utilisation « FP1 - Vérifier des données »
« En tant que Bob,
Je veux donner une liste de données, un fichier décrivant le fichier de données, un fichier contenant les règles de vérification et je veux vérifier automatiquement que les données correspondent au type attendu. Afin de pouvoir obtenir des données 100% vérifiées dans un fichier dont le nom est donné préalablement par BOB.»

#### Cas d’utilisation « FP2 - Anonymiser des données »
« En tant que Bob,
Je veux donner une liste de données, un fichier décrivant le fichier de données, un fichier contenant les règles d'anonymisation. Afin de pouvoir obtenir des données 100% vérifiées dans un fichier dont le nom est donné préalablement par BOB.»

## Développement de l'application
Pour des raisons d'optimisation de ressources et compte-tenu de la taille du projet, nous avons orienté nos features sur des aspects techniques et non fonctionnels. 

### Features & package associés 
| Feature | Description |Package |Classes|
|:--------:|:------------|:------------|:-------------|
| F_00 | Squellete de l'application (Protoypage)| anonymisation,IO-handling-utils, Launcher, mappers, meta-data, readers (cfg & csv), verification,writers | All (Protoypage)|
| F_10 | Fournir des outils nécessaires aux oppérations de lecture / écriture (parse)| IO-handling-utils| JsonExtractor, & StringUtils |
| F_20 | Fournir des outils d'écriture dans différents formats de façon indiférente à notre application |writers| Writer, WriterCSV & WriterFactory|
| F_30 | Fournir des outils de lecture dans différents formats de façon (CSV, JSON, ...) |readers.cfg_reader & readers.document_reader| CfgReader, CfgReaderFactory & JsonReader, CsvReader, DocumentReader, DocumentReaderFactory|
| F_40 | Modéliser une structure de données en tableur et lui associer les fonctionnalité FP1 et FP2 |meta_data & mappers|Column, LineMetaData, AnonymisationRuleMapper, DesTypeMapper, VerificationRUleMapper|
| F_50 | Coder la fonctionnalité FP1 : la vérification|verification |AllVerificationsRules, Verification|
| F_60 | Coder la fonctionnalité FP2 : l'anonymisation|verification |AllANonymisationRules, Anonymisation|


## Roadmap projet
1. **Push du backlog** (Cahier des charges) --> 22/02/2020
2. **Kick-off** --> 22/02/2020 :
	1. Livraison F_00 --> 22/02/2020
	2. Livraison F_10 --> 23/02/2020
	3. Livraison F_20 --> 24/02/2020
	4. Livraison F_30 --> 25/02/2020
	5. Livraison F_40 --> 26/02/2020
	6. Livraison F_50 --> 27/02/2020
	7. Livraison F_60 --> 28/02/2020
3. **Fonctionnalité bonus** :
	* Traçabilité (Log 4j)
	* Features F_70 --> 04/02/2020    
4. **Rendu** --> 05/03/2020
5. **Rapport** --> 08/03/2020

**NB1** : Cette roadmap correspond aux demandes obligatoires du projet. Il se peut que des fonctionnalités bonus soient ajoutées. Ainsi, si bonne conduite de projet il y a

**NB2** : Un projet scolaire est toujours une vitrine pour notre avenir professionnel. Bien que non demandé par le professeur et donc hors-scope voici quelques fonctionnalités que nous ajouterons s'il reste du temps :

* IHM
* Lien avec le cours de Systemes Repartis --> Fonctionnalités à distance.
