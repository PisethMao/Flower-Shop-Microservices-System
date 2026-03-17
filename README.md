# Flower Shop Microservices System

A Spring Boot microservices learning project for building a flower shop system step by step.

This repository is currently in the **early setup stage**.  
At this moment, the project mainly focuses on preparing the **Config Server**, **Config Repository integration**, and initial configuration setup.

---

## Current Progress

The following tasks have been completed so far:

- Initialize project
- Create `config-server` branch
- Create `config-repo` branch and configure Config Server
- Update configuration in YAML files
- Connect Config Server with Config Repository
- Update YAML file with Config Repository GitHub source
- Move username, password, and URI into environment variables
- Create README for Flower Shop Microservices project

---

## What Has Been Done

### 1. Initialize Project
The base project structure for the Flower Shop Microservices System was created.

Current folders include:

- `configserver`
- `flower-shop-config-repo`

---

### 2. Create `config-server` Branch
A dedicated branch was created for developing the Config Server part of the system.

This helps separate configuration server work from other future microservice development.

---

### 3. Create `config-repo` Branch and Configure Config Server
A separate branch was created for working with the configuration repository.

The Config Server was then prepared to read external configuration from the config repository.

---

### 4. Update Configuration in YAML Files
The YAML configuration files were updated to support the current Config Server setup.

This includes changes needed for externalized configuration and profile-based configuration loading.

---

### 5. Connect Config Server with Config Repository
The Config Server was connected with the external config repository so it can load configuration files from there.

This is an important foundation for centralized configuration management in a microservices architecture.

---

### 6. Update YAML File with Config Repository GitHub Source
The YAML configuration was updated so the Config Server can point to the GitHub repository used as the configuration source.

This allows centralized config files to be managed separately from the application source code.

---

### 7. Move Username, Password, and URI into Environment Variables
Sensitive and changeable values such as:

- username
- password
- repository URI

were moved into environment variables.

This is better than hardcoding them directly in YAML files because it improves security and flexibility.

---

### 8. Create README for the Project
A README file was added to explain the current state of the project and document what has already been completed.

This README will continue to be updated as the project grows.

---

## Project Structure

```bash
Flower-Shop-Microservices-System/
│
├── .idea/
├── configserver/
├── flower-shop-config-repo/
└── README.md
