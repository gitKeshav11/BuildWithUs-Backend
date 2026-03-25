# CodeMate AI Backend API


A Spring Boot–based backend service for CodeMate AI — an AI-powered developer collaboration and project-building platform.
This backend provides:
* JWT Authentication (Register / Login)
* User & Developer Profile Management
* Project Creation & Collaboration APIs
* AI Chat & Session Support
* Groq AI Integration
* Notifications
* Developer AI (Code / Debug / Ideas)
* Frontend-ready REST APIs

---

## Overview

CodeMate AI Backend is designed to support a modern collaboration ecosystem where developers can:

* Create and manage projects
* Register and authenticate securely
* Build developer profiles
* Use AI-powered developer assistance
* Interact with frontend applications through REST APIs
* Scale the platform with modular backend architecture

This project focuses on delivering a clean, extensible, and production-ready backend base.

---

## Features

### 1. Authentication & Security

* User registration API
* User login API
* JWT-based authentication
* Token generation for secured access
* Protected route support for future secured endpoints
* Spring Security integration
* Password encryption using BCrypt

### 2. User Management

* User entity and persistence layer
* User repository for database operations
* User service layer for business logic
* User-related API structure prepared for extension

### 3. Project Management

* Create new project API
* Fetch all projects API
* Project entity with:

  * ID
  * Name
  * Description
  * Owner ID
  * Created timestamp

### 4. AI Integration (Groq Powered)

* AI chat endpoint implemented
* Groq API integrated using OpenAI-compatible endpoint structure
* Dynamic prompt request handling
* Model configuration through application.properties

### 5. Clean Layered Architecture

* Controller Layer
* Service Layer
* Repository Layer
* Entity Layer
* Security Layer
* Configuration Layer

### 6. Database Integration

* MySQL database integration
* JPA / Hibernate support
* Automatic schema updates with `spring.jpa.hibernate.ddl-auto=update`

### 7. Frontend-Ready REST APIs

* JSON request/response handling
* Clean REST endpoint design
* Token-based frontend integration
* Project creation and retrieval support
* AI chat integration support

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* JWT Authentication
* MySQL
* Maven
* Groq API

---

## Project Structure

```text
codemate-ai-backend/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── codemateai/
│   │   │           ├── CodemateAiApplication.java
│   │   │
│   │   │           ├── config/
│   │   │           ├── controller/
│   │   │           ├── entity/
│   │   │           ├── repository/
│   │   │           ├── service/
│   │   │           ├── security/
│   │   │           └── dto/
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-example.properties
│   │
│   └── test/
│
├── pom.xml
└── README.md
```

---

## API Endpoints

### Authentication

* `POST /api/auth/register`
* `POST /api/auth/login`

### Projects

* `POST /api/projects`
* `GET /api/projects`

### AI

* `POST /api/ai/chat`

---

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/codemate-ai-backend.git
cd codemate-ai-backend
```

### 2. Create MySQL Database

```sql
CREATE DATABASE codemate_ai_db;
```

### 3. Generate Groq API Key

https://console.groq.com/keys

Paste it into `application.properties`.

### 4. Update application.properties

```properties
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/codemate_ai_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=YOUR_JWT_SECRET

groq.api.key=YOUR_GROQ_API_KEY
groq.model=llama-3.3-70b-versatile
```

---

## Why This Project

CodeMate AI Backend is the foundation of an AI-powered platform where developers can connect, create, collaborate, and build projects together.

It can:

* Authenticate users
* Manage projects
* Connect with MySQL
* Integrate AI using Groq
* Support frontend apps via REST APIs

Perfect for:

* Full-stack projects
* Portfolio showcase
* Hackathons
* Startup MVPs
* Internship demos

---

## 👨‍💻 Author & Contributors
<a href="https://github.com/gitKeshav11/BuildWithUs-Backend/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=gitKeshav11/BuildWithUs-Backend" />

</a>

## 📞 Contact
### **Keshav Upadhyay**  
**Role:** Backend Developer (Java & Spring Boot)  
📧 Email: [keshavupadhyayje@gmail.com](mailto:keshavupadhyayje@gmail.com)  
🔗 LinkedIn: [Keshav Upadhyay](https://www.linkedin.com/in/keshavupadhyayje/)  
🐙 GitHub: [gitKeshav11](https://github.com/gitKeshav11)  


---

## Repository Info

* Name: `codemate-ai-backend`
* Version: `v1.0.0`
* Type: Initial Stable Backend Release

---

## License

You can release this project under the MIT License.
