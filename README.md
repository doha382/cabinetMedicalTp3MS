# TP3 – Architecture Microservices (REST)
## Gestion d’un Cabinet Médical



---

## Contexte

Ce TP correspond à la **troisième phase** du projet pédagogique évolutif  
**Gestion d’un Cabinet Médical**.

Il consiste à **faire évoluer l’architecture SOA du TP2** vers une  
**architecture microservices REST**, basée sur des microservices **totalement autonomes**, chacun disposant de sa **propre API** et de sa **propre base de données**, avec un **API Gateway** comme point d’entrée unique.

---

## Objectifs du TP

- Mettre en place une architecture **microservices**
- Découpler totalement les services (code et données)
- Supprimer tout module de persistance partagé
- Introduire un **API Gateway** pour l’exposition des APIs
- Mettre en œuvre la communication **REST inter-services**
- Comprendre la différence entre **SOA et Microservices**

---

## Architecture globale

L’architecture est basée sur :
- Des **microservices métiers autonomes** (Patient, Médecin, Rendez-vous, Consultation)
- Un **service composite** pour l’agrégation des données (Dossier Patient)
- Un **API Gateway** servant de point d’entrée unique pour les clients externes
- Une **base de données par microservice**

Les clients n’accèdent jamais directement aux microservices, toutes les requêtes passent par le Gateway.

---

## Structure du projet

```text
cabinetMedicalTp3MS/
│
├── api-gateway                  # API Gateway (point d’entrée externe)
│
├── patient-service              # Microservice Patient (API + DB)
├── medecin-service              # Microservice Médecin (API + DB)
├── rendezvous-service           # Microservice Rendez-vous (API + DB)
├── consultation-service         # Microservice Consultation (API + DB)
│
├── dossier-service              # Service composite (agrégation REST)
│
└── pom.xml                      # Projet parent (packaging pom)

---

## Déploiement et exécution

**Tests REST Client**
1️⃣ Consultation Service
### GET – Lister toutes les consultations
GET http://localhost:8085/internal/api/v1/consultations
### POST – Créer une consultation
![GET Consultations](screenshots/get_consultations.png)
![POST Consultation](screenshots/post_consultations.png)


2️⃣ Rendez-vous Service
### GET – Récupérer un rendez-vous 
GET http://localhost:8084/internal/api/v1/rendezvous
### POST – Créer un rendez-vous
![GET RendezVous](screenshots/get_rendezvous.png)
![POST RendezVous](screenshots/post_rendezvous.png)


3️⃣ Patient Service
### GET – Lister tous les patients
GET http://localhost:8082/internal/api/v1/patients
### POST – Créer un patient
![GET Patients](screenshots/get_patients.png)
![POST Patient](screenshots/post_patients.png)

4️⃣ Médecin Service
### GET – Lister tous les médecins
GET http://localhost:8083/internal/api/v1/medecins
### POST – Créer un médecin
![GET Medecins](screenshots/get_medecins.png)
![POST Medecin](screenshots/post_medecins.png)

##Outils utilisés
Java 21 (OpenJDK Temurin) – langage et runtime

Spring Boot 3.1 – framework principal pour les microservices

Spring Data JPA – accès aux bases de données

H2 Database – base de données embarquée pour tests

Maven 3.9 – gestion des dépendances et build

IntelliJ IDEA – IDE pour le développement

REST Client – tests REST manuels

Lombok – génération automatique de getters/setters, constructeurs, etc.

API Gateway (Spring Cloud Gateway) – point d’entrée unique pour tous les microservices

Git / GitHub – versionning du code source


