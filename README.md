# 💱 Java Currency Converter API

## 🧩 Overview
This project is a **Spring Boot RESTful API** that converts currencies using real-time exchange rates. It supports **user authentication**, **session-based conversion history**, and **H2 in-memory database** storage.

---

## 🧠 Tech Stack
- **Java 21**
- **Spring Boot 3.5.7**
- **Spring Security**
- **Spring Data JPA**
- **H2 Database**
- **REST APIs (JSON)**
- **Postman for Testing**

---

## ⚙️ Features
- 🔐 User registration and login (Spring Security sessions)
- 💱 Real-time currency conversion using external API
- 🧾 History tracking of conversions per user
- 💾 In-memory H2 database with JPA entities
- 🧰 CRUD operations for conversion records

---

## 🧠 Project Structure
```
com.neotox.currencyconverter
│
├── config
│   └── SecurityConfig.java       # Configures Spring Security & access rules
│
├── controller
│   └── AuthController.java       # Handles user registration endpoints
│
├── model
│   ├── User.java                 # JPA Entity for users
│   └── ConversionHistory.java    # JPA Entity for storing conversion records
│
├── repository
│   ├── UserRepository.java       # Handles User persistence
│   └── ConversionHistoryRepository.java  # Handles conversion history
│
├── service
│   ├── UserService.java          # Manages user registration and login
│   └── CurrencyService.java      # Calls external API and stores conversions
│
└── CurrencyConverterApplication.java     # Spring Boot entry point
```

---

## 🧰 API Endpoints

### 🔸 Authentication
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `POST` | `/register` | Register new user (`username`, `password`) |
| `POST` | `/login` | Login existing user (creates session) |
| `POST` | `/logout` | Logout current user |

### 🔸 Currency
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/api/currency/convert?from=USD&to=INR&amount=10` | Convert currency |
| `GET` | `/api/currency/history` | Get user’s conversion history |

---

## 🧪 Testing with Postman

1. Create a **Collection** named `Java Currency Converter API`
2. Create a **Localhost Env** environment with:
   ```
   base_url = http://localhost:8080
   ```
3. Add these requests inside the collection:

| Name | Method | URL | Notes |
|------|---------|------|-------|
| Register User | POST | `{{base_url}}/register` | Body: username, password |
| Login | POST | `{{base_url}}/login` | Creates session |
| Convert Currency | GET | `{{base_url}}/api/currency/convert?from=USD&to=INR&amount=10` | Authenticated |
| View History | GET | `{{base_url}}/api/currency/history` | Authenticated |
| Logout | POST | `{{base_url}}/logout` | Ends session |

---
## 🧱 Database Schema (H2)
- **User**
  - id (Long, PK)
  - username (String, unique)
  - password (String, encoded)

- **ConversionHistory**
  - id (Long, PK)
  - fromCurrency (String)
  - toCurrency (String)
  - amount (Double)
  - convertedAmount (Double)
  - timestamp (LocalDateTime)
  - user_id (FK)

---
## 👨‍💻 Author
**Saikat Samanta (NeoTox)**  
Java Backend Developer | GitHub: [NeoTox419](https://github.com/NeoTox419)
