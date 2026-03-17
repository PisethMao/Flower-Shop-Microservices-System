# Flower Shop Microservices System

![Project Status](https://img.shields.io/badge/status-in%20progress-orange)
![Architecture](https://img.shields.io/badge/architecture-microservices-blue)
![Java](https://img.shields.io/badge/Java-17%2B-red)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-config%20server-success)

A backend learning project built with **Spring Boot** and **Spring Cloud** to practice how a real **microservices system** can be designed for a flower shop business.

This repository is being developed step by step, starting from the **Config Server** and **centralized configuration**, then expanding into multiple business services such as **API Gateway**, **Product Service**, **Order Service**, **Inventory Service**, **Notification Service**, and later **Authentication Service**.

---

## Table of Contents

- [Project Overview](#project-overview)
- [Project Goal](#project-goal)
- [Current Status](#current-status)
- [Planned Microservices](#planned-microservices)
- [Architecture Overview](#architecture-overview)
- [Project Structure](#project-structure)
- [Tech Stack](#tech-stack)
- [Why This Project Matters](#why-this-project-matters)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [How to Run the Config Server](#how-to-run-the-config-server)
- [How the Config Repo Is Used](#how-the-config-repo-is-used)
- [Recommended Development Order](#recommended-development-order)
- [Testing Plan](#testing-plan)
- [Roadmap](#roadmap)
- [Author](#author)

---

## Project Overview

The **Flower Shop Microservices System** is a practice project that applies microservice architecture to a flower shop domain.

Instead of building the system as one large monolithic application, the business is separated into smaller services with different responsibilities.

The long-term goal is to make the system more:

- modular
- scalable
- maintainable
- easy to deploy independently
- closer to real industry architecture

---

## Project Goal

This project is created to learn and practice:

- **Spring Boot microservices**
- **Spring Cloud Config Server**
- **Centralized configuration management**
- **API Gateway routing**
- **Inter-service communication**
- **Independent service responsibility**
- **Real-world backend architecture design**

This project is not just about making the flower shop work.  
It is also about learning how modern backend systems are designed professionally.

---

## Current Status

This project is currently **in progress**.

### Completed
- Basic project repository created
- `configserver` service created
- `flower-shop-config-repo` added for centralized configuration
- Initial microservices planning completed

### Planned
- API Gateway
- Product Service
- Order Service
- Inventory Service
- Notification Service
- Auth Service

### Important Note
At the moment, this repository is still in the **foundation stage**.  
That means the README explains both:

- what already exists
- what will be built next

This is intentional and reflects the real development process honestly.

---

## Planned Microservices

### 1. API Gateway
The single entry point for client requests.

**Responsibilities**
- Receive incoming requests from client applications
- Route requests to the correct microservice
- Centralize access to backend services
- Simplify external communication

---

### 2. Product Service
Handles flower product management.

**Responsibilities**
- Create product
- Update product
- Delete product
- Get all products
- Get product by id

**Examples**
- Rose bouquet
- Wedding flower package
- Gift flower box

---

### 3. Order Service
Handles customer orders.

**Responsibilities**
- Create order
- Get order by id
- Validate requested products
- Communicate with other services when needed

**Possible flow**
- Customer places an order
- Order Service checks product existence
- Order Service checks stock through Inventory Service
- Order is saved
- Notification event is triggered

---

### 4. Inventory Service
Handles stock availability.

**Responsibilities**
- Check quantity of flower products
- Reduce stock after successful order
- Prevent ordering when stock is unavailable
- Keep inventory information up to date

---

### 5. Notification Service
Handles system notifications.

**Responsibilities**
- Send order confirmation
- Send business event notifications
- Support email or future notification integration

---

### 6. Auth Service
This service will be implemented later, not first.

**Responsibilities**
- Authentication
- Authorization
- Service protection
- Secure access to endpoints

---

## Architecture Overview

Planned request flow:

```text
Client
   |
   v
API Gateway
   |
   +--------------------> Product Service
   |
   +--------------------> Order Service
   |                          |
   |                          +---------> Inventory Service
   |                          |
   |                          +---------> Notification Service
   |
   +--------------------> Auth Service (later)
```

Configuration flow:

```text
flower-shop-config-repo
          |
          v
     Config Server
          |
          v
All Microservices load configuration from one centralized place
```

This design helps reduce duplicated configuration and supports cleaner service management.

---

## Project Structure

```bash
Flower-Shop-Microservices-System/
│
├── .idea/
│   └── IDE project files
│
├── configserver/
│   └── Spring Cloud Config Server
│
├── flower-shop-config-repo/
│   └── Centralized configuration files for microservices
│
└── README.md
```

### Folder Explanation

#### `configserver/`
Contains the Spring Cloud Config Server application.  
This service provides configuration values to other microservices.

#### `flower-shop-config-repo/`
Contains configuration files that the Config Server will expose to other services.

Typical future files may include:

```bash
product-service.yml
order-service.yml
inventory-service.yml
api-gateway.yml
notification-service.yml
auth-service.yml
```

---

## Tech Stack

This project is planned around the following technologies:

- **Java**
- **Spring Boot**
- **Spring Cloud Config Server**
- **Spring Cloud Gateway**
- **Maven**
- **Git**
- **GitHub**

Future technologies may include:

- Spring Data JPA
- PostgreSQL or MySQL
- Eureka Service Discovery
- OpenFeign
- Docker
- Kubernetes
- CI/CD pipeline tools

---

## Why This Project Matters

This project is useful for learning because it introduces real backend design concepts, including:

- service separation
- central configuration
- single entry point with gateway
- business responsibility per service
- future scalability
- cleaner maintenance than a monolith

For a student or junior backend engineer, this type of project is much stronger than a CRUD-only project because it shows architecture thinking, not only coding.

---

## Prerequisites

Before running this project, make sure you have:

- **Java 17 or newer**
- **Maven**
- **Git**
- **IntelliJ IDEA** or another Java IDE
- Internet connection to download dependencies

You can verify tools with:

```bash
java -version
mvn -version
git --version
```

---

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/PisethMao/Flower-Shop-Microservices-System.git
cd Flower-Shop-Microservices-System
```

### 2. Open the project in your IDE

Recommended:
- IntelliJ IDEA
- VS Code with Java extensions
- Spring Tool Suite

### 3. Review the current folders

At this stage, you should see:

- `configserver`
- `flower-shop-config-repo`

That means the project foundation is prepared correctly.

---

## How to Run the Config Server

Go into the `configserver` project first.

```bash
cd configserver
```

### Run with Maven

If your project uses Maven wrapper:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

If wrapper is not available, use normal Maven:

```bash
mvn spring-boot:run
```

### Run from IntelliJ IDEA

- Open the `configserver` module
- Locate the main Spring Boot application class
- Click **Run**

---

## How to Verify the Config Server

Once the server starts successfully, open:

```text
http://localhost:8888
```

If your configuration is correct, the Config Server should respond.

You can also test a specific configuration later using a pattern like:

```text
http://localhost:8888/{application-name}/{profile}
```

Example:

```text
http://localhost:8888/product-service/default
```

That endpoint will work after the correct config files are added and the Config Server is pointed to the config repository properly.

---

## How the Config Repo Is Used

The folder `flower-shop-config-repo` is meant to store the external configuration for all services.

Instead of writing all configuration directly inside every microservice, the Config Server loads settings from this central location.

### Example future config files

```bash
flower-shop-config-repo/
├── api-gateway.yml
├── product-service.yml
├── order-service.yml
├── inventory-service.yml
├── notification-service.yml
└── auth-service.yml
```

### Why this is useful
It makes the project more professional because:

- all services can load config from one place
- config changes become easier to manage
- microservices stay cleaner
- environment-based config becomes easier later

---

## Recommended Development Order

This is the best order for this project:

### Step 1 — Config Server
Build the centralized configuration first.

**Reason:**  
Every other service can use it later.

### Step 2 — API Gateway
Build the single entry point for requests.

**Reason:**  
This becomes the main access path for client applications.

### Step 3 — Product Service
Build the product CRUD service.

**Reason:**  
Products are core business data and are simpler than orders.

### Step 4 — Inventory Service
Build stock management.

**Reason:**  
Orders depend on stock validation.

### Step 5 — Order Service
Build order creation and retrieval.

**Reason:**  
Orders usually depend on products and stock.

### Step 6 — Notification Service
Build notification handling.

**Reason:**  
Notifications normally happen after order-related events.

### Step 7 — Auth Service
Add security later.

**Reason:**  
Authentication is important, but it should not block learning the architecture foundation first.

---

## Suggested Feature Plan Per Service

### Product Service
- Create product
- Get all products
- Get product by id
- Update product
- Delete product

### Inventory Service
- Add stock
- Check stock
- Reduce stock after order
- Prevent negative quantity

### Order Service
- Create order
- Get order by id
- Validate product
- Check inventory before save

### Notification Service
- Send order confirmation
- Send success or failure events

### API Gateway
- Route `/api/products/**` to Product Service
- Route `/api/orders/**` to Order Service
- Route `/api/inventory/**` to Inventory Service

---

## Testing Plan

### Current Testing
At the current stage, the main test is:

- Config Server starts successfully
- Config Server can expose centralized configuration

### Future Testing
After more services are implemented, testing will include:

- Product CRUD testing
- Inventory stock checking
- Order creation flow
- Gateway routing
- Inter-service communication
- Notification trigger flow

---

## Roadmap

- [x] Create repository
- [x] Create Config Server
- [x] Create Config Repository folder
- [ ] Connect Config Server fully with externalized config files
- [ ] Create API Gateway
- [ ] Create Product Service
- [ ] Create Inventory Service
- [ ] Create Order Service
- [ ] Create Notification Service
- [ ] Create Auth Service
- [ ] Add database integration
- [ ] Add service-to-service communication
- [ ] Add Docker support
- [ ] Add monitoring and logging
- [ ] Add CI/CD pipeline
- [ ] Add deployment configuration

---

## Honest Project Note

This repository is currently a **learning microservices project**, not a completed production system.

That is a strength, not a weakness.

A good repository should clearly show:

- what already exists
- what is under development
- what will be built next

This README is written with that approach so that anyone visiting the repository can quickly understand the current state and future direction of the project.

---

## Author

**Piseth Mao**

- GitHub: [PisethMao](https://github.com/PisethMao)

---

## Support This Project

If you find this repository useful for learning microservices, consider starring the project and following its progress as new services are added.
