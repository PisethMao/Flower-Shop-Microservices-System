# Flower Shop Microservices System

![Java](https://img.shields.io/badge/Java-Spring_Boot-6DB33F?logo=springboot&logoColor=white)
![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-Config%20%7C%20Eureka-6DB33F?logo=spring&logoColor=white)
![Vault](https://img.shields.io/badge/HashiCorp-Vault-000000?logo=vault&logoColor=white)
![Kafka](https://img.shields.io/badge/Apache-Kafka-231F20?logo=apachekafka&logoColor=white)
![Debezium](https://img.shields.io/badge/Debezium-CDC-EA4335)
![Schema Registry](https://img.shields.io/badge/Schema-Registry-3F51B5)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?logo=postgresql&logoColor=white)
![Oracle](https://img.shields.io/badge/Oracle-Database-F80000?logo=oracle&logoColor=white)
![Docker Compose](https://img.shields.io/badge/Docker-Compose-2496ED?logo=docker&logoColor=white)

A Spring Boot microservices learning project for building a **Flower Shop System** step by step.

This repository is currently in the **infrastructure and platform foundation stage**.  
The current focus is on building a proper microservices base before implementing full flower shop business features.

---

## Table of Contents

- [Overview](#overview)
- [Current Progress](#current-progress)
- [Project Goal](#project-goal)
- [Tech Stack](#tech-stack)
- [Project Modules](#project-modules)
- [Architecture Diagrams](#architecture-diagrams)
- [Current Learning Stage](#current-learning-stage)
- [Architecture Overview](#architecture-overview)
- [Architecture Flow](#architecture-flow)
- [Current Focus](#current-focus)
- [Future Direction](#future-direction)
- [Summary](#summary)

---

## Overview

This project is designed to practice how a real microservices system is built in the correct sequence, starting from infrastructure first and business logic later.

The system currently includes:

- centralized configuration with **Spring Cloud Config Server**
- external configuration management with a separate **config repository**
- secret management with **HashiCorp Vault**
- service discovery with **Eureka Server**
- infrastructure provisioning with **Docker Compose**
- relational database setup with **PostgreSQL** and **Oracle Database**
- event streaming infrastructure with **Apache Kafka**
- change data capture with **Debezium**
- schema management with **Schema Registry**

At this stage, the project focuses on infrastructure readiness, configuration flow, service registration, database preparation, and CDC integration.

---

## Current Progress

The following tasks have been completed so far:

- Initialized the project structure
- Created and configured **Spring Cloud Config Server**
- Created a separate **config repository**
- Connected Config Server to the external config repository
- Moved repository URI, username, and password into environment variables
- Added Docker Compose setup for **PostgreSQL**
- Added Docker Compose setup for **Kafka**
- Added Docker Compose setup for **HashiCorp Vault**
- Configured **Config Server** with **Vault**
- Configured config clients to load secrets from **Vault through Config Server**
- Added two microservices:
  - `order-service`
  - `product-service`
- Configured **Eureka Server**
- Configured microservices to register with **Eureka**
- Added Docker Compose setup for **Oracle Database**
- Prepared **Oracle** for **Debezium** CDC
- Configured **Debezium**
- Configured **Schema Registry**
- Integrated **Debezium with Schema Registry**

---

## Project Goal

The goal of this project is to understand how to build a microservices system in a proper sequence, beginning with infrastructure and configuration before business logic.

This project is being developed progressively to practice:

- externalized configuration management
- secure secret handling
- service discovery
- infrastructure setup with Docker Compose
- consistent configuration across microservices
- relational database integration
- CDC-based event streaming
- schema-aware event architecture
- foundations for future inter-service communication

---

## Tech Stack

### Backend
- **Java**
- **Spring Boot**
- **Spring Cloud Config Server**
- **Spring Cloud Netflix Eureka**

### Secret Management
- **HashiCorp Vault**

### Infrastructure
- **Docker Compose**
- **PostgreSQL**
- **Oracle Database**
- **Apache Kafka**

### Change Data Capture and Event Schema
- **Debezium**
- **Schema Registry**

### Configuration
- **External Config Repository**
- **Environment Variables**

---

## Project Modules

### `config-server`
Centralized configuration server responsible for loading configuration from the external config repository and integrating with HashiCorp Vault.

### `eureka-server`
Service registry used for service discovery between microservices.

### `order-service`
Microservice client that loads configuration from Config Server and registers itself with Eureka.

### `product-service`
Microservice client that loads configuration from Config Server and registers itself with Eureka.

### `config-repo`
External repository that stores configuration files for all microservices.

### `deployment/postgres`
Docker Compose setup for PostgreSQL.

### `deployment/kafka`
Docker Compose setup for Kafka and related messaging infrastructure.

### `deployment/vault-server`
Docker Compose setup for HashiCorp Vault.

### `deployment/oracle`
Docker Compose setup for Oracle Database.

---

## Architecture Diagrams

### Project Setup Diagram

<p align="center">
  <img src="docs/images/project-setup-diagram.png" alt="Flower Shop Microservices System Setup Diagram" width="1000"/>
</p>

### Updated Architecture Diagram

This diagram shows how the project has evolved from the earlier configuration stage into the current infrastructure stage with Docker Compose, Vault, Eureka, Oracle, Debezium, and Schema Registry.

<p align="center">
  <img src="docs/images/project-setup-before-now-diagram.png" alt="Flower Shop Microservices System Before and Now Diagram" width="1000"/>
</p>

### Eureka Service Discovery Diagram

This diagram highlights the **Eureka Server** setup and shows how microservices register with and discover services through Eureka.

<p align="center">
  <img src="docs/images/eureka-service-discovery-diagram.png" alt="Eureka Service Discovery Diagram" width="1000"/>
</p>

### Oracle, Debezium, and Schema Registry Infrastructure Diagram

This diagram shows the next infrastructure expansion of the project with **Oracle Database**, **Debezium**, and **Schema Registry** added to the architecture.

It highlights how the system is evolving beyond configuration and service discovery into a stronger event-driven platform that supports:

- enterprise database usage with **Oracle**
- database change capture with **Debezium**
- event streaming through **Kafka**
- schema consistency through **Schema Registry**

<p align="center">
  <img src="docs/images/oracle-debezium-infrastructure-diagram.png" alt="Oracle Debezium and Schema Registry Infrastructure Diagram" width="1000"/>
</p>

## Debezium and Schema Registry Integration Diagram

This diagram shows the infrastructure update completed today, where **Debezium** is configured together with **Schema Registry** in the Flower Shop Microservices System.

It highlights the current platform flow:

- **Oracle Database** acts as the CDC source
- **Debezium Connector** captures database changes
- **Apache Kafka** transports CDC events
- **Schema Registry** manages event schemas
- **Config Server**, **Vault**, and **Eureka Server** remain part of the core microservices foundation

<p align="center">
  <img src="docs/images/debezium-schema-registry-diagram.png" alt="Debezium and Schema Registry Integration Diagram" width="1000"/>
</p>

### PostgreSQL Database Setup Diagram

This diagram shows the infrastructure update completed today, where **PostgreSQL database cluster** is configured as part of the Flower Shop Microservices System.

It highlights the current platform improvement:

- **PostgreSQL cluster** is prepared for stronger database infrastructure
- database services are organized for better scalability and availability
- the project continues evolving from basic service setup into a more production-style platform
- **Config Server**, **Vault**, **Eureka Server**, **Oracle**, **Debezium**, and **Schema Registry** remain part of the overall system foundation

<p align="center">
  <img src="docs/images/postgresql-database-cluster-diagram.png" alt="PostgreSQL Database Cluster Diagram" width="1000"/>
</p>

---

## Current Learning Stage

The project has now moved beyond basic configuration and service registration.

### Oracle Database
**Oracle Database** is added through Docker Compose as part of the infrastructure layer.

It is included for:

- enterprise database practice
- persistent data storage
- future service data integration
- CDC source preparation

### Debezium
**Debezium** is introduced to support change data capture.

At this stage, the focus is on configuring Oracle and Debezium so the system can capture database changes and publish them as events.

This helps practice:

- Oracle container setup with Docker Compose
- Oracle preparation for CDC
- Debezium connector configuration
- database change capture concepts
- event-driven architecture foundations

### Schema Registry
**Schema Registry** is added to manage and standardize event schemas in the streaming layer.

This is important for building reliable event-driven systems because it helps producers and consumers share a consistent contract for message structure.

This stage helps practice:

- schema-aware event design
- event structure consistency across services
- Debezium integration with schema-based messaging
- stronger foundations for future Kafka consumers and producers

---

## Architecture Overview

At the current stage, the system follows this general flow:

1. **Config Server** reads configuration from the external config repository.
2. **Vault** provides secret values to Config Server.
3. **Order Service** and **Product Service** fetch their configuration from Config Server during startup.
4. Both services register themselves with **Eureka Server**.
5. Supporting services such as **PostgreSQL**, **Kafka**, **Vault**, and **Oracle** are provisioned with Docker Compose.
6. **Oracle** is prepared as the CDC source database.
7. **Debezium** captures database changes from Oracle.
8. **Kafka** transports change events.
9. **Schema Registry** manages event schemas for more consistent event processing.

---

## Architecture Flow

```text
                 +----------------------+
                 |   Config Repository  |
                 +----------------------+
                            |
                            v
                 +----------------------+
                 |  Spring Config Server|
                 +----------------------+
                            ^
                            |
                 +----------------------+
                 |    HashiCorp Vault   |
                 +----------------------+

        +------------------+     +------------------+
        |   order-service  |     |  product-service |
        +------------------+     +------------------+
                 |                         |
                 +-----------+-------------+
                             |
                             v
                    +----------------+
                    | Eureka Server  |
                    +----------------+

   +-------------------+     +-------------------+     +----------------+
   |   Oracle Database | --> |     Debezium      | --> |     Kafka      |
   +-------------------+     +-------------------+     +----------------+
                                                           |
                                                           v
                                                +----------------------+
                                                |   Schema Registry    |
                                                +----------------------+

                    +----------------+
                    |   PostgreSQL   |
                    +----------------+
