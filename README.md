# Flower Shop Microservices System

A Spring Boot microservices learning project for building a **Flower Shop System** step by step.

This repository is currently in the **foundation and infrastructure setup stage**.  
The current focus is on preparing the core building blocks of a microservices architecture before implementing full business features.

---

## Overview

This project is designed to help practice how a real microservices system is structured from the beginning, including:

- centralized configuration with **Spring Cloud Config Server**
- external configuration management with a separate **config repository**
- secret management using **HashiCorp Vault**
- service discovery using **Eureka Server**
- supporting infrastructure with **Docker Compose**
- configuration sharing across multiple microservices

At this stage, the project includes infrastructure setup and service registration, while business logic will be implemented progressively in later phases.

---

## Current Progress

The following tasks have been completed so far:

- Initialize project structure
- Create and configure **Spring Cloud Config Server**
- Create separate **config repository**
- Connect Config Server to the external config repository
- Move repository URI, username, and password into environment variables
- Add Docker Compose for **PostgreSQL** and **Kafka**
- Add Docker Compose YAML file for **HashiCorp Vault**
- Configure **Config Server** with **HashiCorp Vault**
- Configure config clients to fetch secrets from **Vault through Config Server**
- Add two microservices:
  - `order-service`
  - `product-service`
- Configure **Eureka Server**
- Configure microservices to register with **Eureka**

---

## Project Goal

The goal of this project is to understand how to build a microservices system in a proper sequence, starting from infrastructure and configuration first.

This project is being developed progressively to practice:

- externalized configuration management
- secure secret handling
- service discovery
- infrastructure setup with Docker Compose
- consistent configuration across services
- preparation for future inter-service communication

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
- **Apache Kafka**

### Configuration
- **External Config Repository**
- **Environment Variables**

---

## Modules

The project currently contains the following modules:

### `config-server`
Centralized configuration server responsible for loading configuration from the external config repository and integrating with HashiCorp Vault.

### `eureka-server`
Service registry used for service discovery between microservices.

### `order-service`
Microservice client that fetches configuration from Config Server and registers itself with Eureka.

### `product-service`
Microservice client that fetches configuration from Config Server and registers itself with Eureka.

### `config-repo`
External repository used to store configuration files for all microservices.

---

## Project Setup Diagram

<p align="center">
  <img src="docs/images/project-setup-diagram.png" alt="Flower Shop Microservices System Setup Diagram" width="1000"/>
</p>

---

## Updated Architecture Diagram

This diagram shows the evolution of the project from the earlier configuration setup into the current stage with Docker Compose infrastructure, Vault integration, and Eureka service discovery.

<p align="center">
  <img src="docs/images/project-setup-before-now-diagram.png" alt="Flower Shop Microservices System Before and Now Diagram" width="1000"/>
</p>

---

## Eureka Service Discovery Diagram

This diagram highlights the **Eureka Server** setup in the current stage and shows how microservices register with and discover services through Eureka.

<p align="center">
  <img src="docs/images/eureka-service-discovery-diagram.png" alt="Eureka Service Discovery Diagram" width="1000"/>
</p>

---

## Architecture Overview

At the current stage, the system is organized around the following flow:

1. **Config Server** reads configuration from the external config repository.
2. **Vault** provides secret values to Config Server.
3. **Order Service** and **Product Service** fetch their configuration from Config Server during startup.
4. Both services register themselves with **Eureka Server**.
5. Supporting services such as **PostgreSQL** and **Kafka** are prepared with Docker Compose.

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

                    +----------------+
                    | PostgreSQL     |
                    | Kafka          |
                    +----------------+
