# Flower Shop Config Repository for Microservices

![GitHub repo size](https://img.shields.io/github/repo-size/PisethMao/flower-shop-config-repository-microservices?style=for-the-badge)
![GitHub last commit](https://img.shields.io/github/last-commit/PisethMao/flower-shop-config-repository-microservices?style=for-the-badge)
![Spring Cloud Config](https://img.shields.io/badge/Spring_Cloud-Config_Server-6DB33F?style=for-the-badge&logo=spring)
![Microservices](https://img.shields.io/badge/Architecture-Microservices-0A66C2?style=for-the-badge)
![Config Repository](https://img.shields.io/badge/Repository-Externalized_Config-orange?style=for-the-badge)

This repository contains the **centralized external configuration** for the **Flower Shop Microservices System**.

It is used by **Spring Cloud Config Server** to provide configuration to all microservices from a single Git-based source. This keeps service projects cleaner, improves consistency, and supports environment-based configuration management.

---

## Table of Contents

- [Overview](#overview)
- [Architecture Role](#architecture-role)
- [Repository Structure](#repository-structure)
- [Configuration Loading Flow](#configuration-loading-flow)
- [Configuration Strategy](#configuration-strategy)
- [Supported Services](#supported-services)
- [Environment Profiles](#environment-profiles)
- [Config Server Connection Example](#config-server-connection-example)
- [Architecture Diagram](#architecture-diagram)
- [Why This Repository Matters](#why-this-repository-matters)
- [Future Improvements](#future-improvements)
- [Related Components](#related-components)
- [Author](#author)

---

## Overview

In a microservices architecture, storing configuration inside each service project quickly becomes messy and difficult to maintain.

This repository solves that by centralizing configuration in one place.

It provides:

- externalized configuration for all services
- service-specific configuration management
- shared configuration across multiple services
- environment-specific configuration support
- easier maintenance and deployment preparation

This repository is not for application business logic.  
Its only responsibility is to store configuration files consumed by the **Config Server**.

---

## Architecture Role

This repository acts as the **configuration source of truth** for the Flower Shop platform.

Instead of every microservice hardcoding its own configuration, services request configuration through **Spring Cloud Config Server**, which reads from this Git repository.

### High-level role in the system

- **Git Config Repository** stores configuration files
- **Spring Cloud Config Server** reads configuration from this repository
- **Microservices** request configuration at startup
- **Profiles** determine which environment-specific settings are loaded

This design aligns with a standard Spring Cloud microservices setup.

---

## Repository Structure

```bash
flower-shop-config-repository-microservices/
├── inventory-service/
├── order-service/
├── payment-service/
├── product-service/
├── application.yml
└── application-qa.yml
