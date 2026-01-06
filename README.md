# QuickCart - E-Commerce Backend System

QuickCart is an evolving **e-commerce application** built using **Spring Boot**. The project is being developed incrementally, following clean architecture principles and real-world backend design practices.

The goal of this repository is to demonstrate how a simple shopping system can grow step by step — starting from a solid domain model and gradually expanding into services, APIs, and a user interface.

---

## 🚀 Current Status (Version 1 – In Progress)

At the current stage, the project focuses on the **core domain layer**:

* JPA entity modeling
* Proper primary key strategies
* Clean relationship mapping
* Database-first validation using MySQL

No controllers, services, or UI layers have been added yet. These will be introduced gradually in future versions.

---

## 🧩 Domain Entities

The following core entities are implemented:

* **Customer** – represents users/customers of the system
* **Product** – represents items available for purchase
* **Coupon** – represents discount rules applied to customers
* **OrderTransaction** – represents transaction/order history

Each entity is designed with clear responsibility, correct identifier strategy, and JPA best practices.

---

## 🛠️ Tech Stack (Current)

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **MySQL**
* **Hibernate**
* **Maven**

---

## 🗺️ Planned Roadmap

The project will be developed incrementally with clear versioning:

### 🔹 Version 1 (Current)

* Core domain entities
* Database schema validation

### 🔹 Version 2 (Planned)

* Repository layer
* Service layer (business logic)
* Exception handling

### 🔹 Version 3 (Planned)

* REST APIs
* Order placement flow
* Validation and error responses

---

## 🎯 Project Objective

This project is intended as a **learning-focused but production-minded** Spring Boot application. Emphasis is placed on:

* Understanding *why* design decisions are made
* Writing maintainable, readable code
* Following best practices used in real-world backend systems

---

## 📌 Notes

* Development is done incrementally, with modular commits
* Each layer is added only after the previous one is fully understood
* This repository will evolve over time

