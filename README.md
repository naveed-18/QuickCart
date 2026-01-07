# QuickCart — E-Commerce Backend (Spring Boot)

QuickCart is a backend application for a simple shopping/order system built using **Spring Boot**, **Spring Data JPA**, and **MySQL**. It demonstrates clean architecture, real-world order placement logic with validation, exception handling, and REST API design

---

## 🧠 Project Overview

QuickCart supports:

- Product lookup
- Quantity validation
- Optional coupon validation
- Order placement with calculated amount
- Transaction logging
- Clean REST API contracts

The backend is designed to be incremental, maintainable, and extensible.

---

## 📌 Tech Stack

| Component |    Technology     |
|-----------|-------------------|
| Language  | Java              |
| Framework | Spring Boot       |
|   ORM     | Spring Data JPA   |
|    DB     | MySQL             |
|  Build    | Maven             |
|  Tools    | Lombok, Hibernate |

---

## 📂 Project Structure

src/
├── controller
├── service
│   └── impl
├── repository
├── entity
├── exception
├── helper (DTOs)
└── config


Each layer has a clear responsibility:
- **Controllers** handle HTTP requests
- **Services** contain business logic
- **Repositories** access the database
- **Exceptions** centralize error handling
- **DTOs** manage request/response contract

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/naveed-18/QuickCart.git
```

### 2. Configure Database

Update your application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/quickcart
spring.datasource.username=YOUR_DB_USER
spring.datasource.password=YOUR_DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update

Create the database manually if necessary.

### 📌 APIs Overview

🛒 Place an Order

POST /customers/{custId}/orders

RequestBody : 
{
  "productId": 3,
  "quantity": 2,
  "couponCode": "OFF20"
}

ResponseBody :
{
  "transactionId": "UUID...",
  "orderId": 12345,
  "productId": 3,
  "quantity": 2,
  "amount": 2400,
  "couponCode": "OFF20",
  "status": "SUCCESS",
  "message": "Order placed successfully"
}

### ❗ Notes

- couponCode is optional — skip it for no discount

- Invalid productId, quantity, or coupon throws a proper error

### 🛠️ Business Logic Overview

The placeOrder service performs:

- Product lookup

- Quantity validation

- Coupon lookup (optional)

- Amount calculation

- Transaction record creation

- Response DTO return

This design follows real e-commerce workflows.

## 🚨 Exception Handling

Custom exceptions are captured by a global exception handler, returning meaningful HTTP statuses:

| Exception                  | HTTP Status |      Messag      |
| -------------------------- | ----------- | ---------------- |
| `ProductNotFoundException` | 404         | Invalid product  |
| `InvalidQuantityException` | 400         | Invalid quantity |
| `InvalidCouponException`   | 400         | Invalid coupon   |


## 📅 Future Enhancements (v2+)

- Persist failed transactions

- Inventory reduction after purchase

- Pagination for GET APIs

- Authentication (JWT)

- Admin panel for product/coupon management

- Swagger/OpenAPI documentation

## 🧠 Learning Objectives

This project demonstrates:

- REST API design with Spring Boot

- Layered architecture (Controller — Service — Repository)

- DTO usage vs. Entities

- Validation and clean exception handling

- Realistic transaction workflows