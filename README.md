# 🍽️ Restaurant Microservices System

A scalable and distributed restaurant management system built using **Spring Boot Microservices architecture**.  
The system is designed to handle menu items, orders, payments, and service discovery with a centralized API Gateway.

---

## 🚀 Architecture Overview

The system is built using microservices and consists of:

- 🧾 Menu Item Service
- 📦 Order Service
- 💳 Payment Service
- 🌐 API Gateway
- 🛰️ Eureka Server (Service Registry)

---

## 🧩 System Architecture
Client
│
▼
API Gateway
│
├── Menu Service
├── Order Service
├── Payment Service
│
▼
Eureka Server (Service Discovery)

---

## ⚙️ Technologies Used

- ☕ Java 17+
- 🌱 Spring Boot
- 🌐 Spring Cloud Gateway
- 🛰️ Eureka Server
- 🗄️ Spring Data JPA
- 🐬 MySQL
- 🔧 Maven

---

## 📦 Microservices

### 🧾 Menu Service
Manages restaurant menu items (add, update, delete, view).

### 📦 Order Service
Handles customer orders and order management.

### 💳 Payment Service
Processes payments related to orders.

### 🌐 API Gateway
Single entry point for all client requests.

### 🛰️ Eureka Server
Handles service registration and discovery.

---

