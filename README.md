# BuildWithUs Backend API
A Spring Boot–based backend service for BuildWithUs — an AI-powered developer collaboration and project-building platform.
This backend provides:

- JWT Authentication (Register / Login)
- User & Developer Profile Management
- Project Creation & Collaboration APIs
- AI Chat & Session Support
- Groq AI Integration
- Notifications
- Developer AI (Code / Debug / Ideas)
- Frontend-ready REST APIs

---

## Overview

BuildWithUs Backend is designed to support a modern collaboration ecosystem where developers can:

- Create and manage projects
- Register and authenticate securely
- Build developer profiles
- Use AI-powered developer assistance
- Interact with frontend applications through REST APIs
- Scale the platform with modular backend architecture

This project focuses on delivering a clean, extensible, and production-ready backend base.

---

## Features

### 1. Authentication & Security
- User registration API
- User login API
- JWT-based authentication
- Token generation for secured access
- Protected route support for future secured endpoints
- Spring Security integration
- Password encryption using BCrypt

### 2. User Management
- User entity and persistence layer
- User repository for database operations
- User service layer for business logic
- User-related API structure prepared for extension

### 3. Project Management
- Create new project API
- Fetch all projects API
- Project entity with:
  - ID
  - Name
  - Description
  - Owner ID
  - Created timestamp

### 4. AI Integration (Groq Powered)
- AI chat endpoint implemented
- Groq API integrated using OpenAI-compatible endpoint structure
- Dynamic prompt request handling
- Model configuration through application.properties

### 5. Clean Layered Architecture
- Controller Layer
- Service Layer
- Repository Layer
- Entity Layer
- Security Layer
- Configuration Layer

### 6. Database Integration
- MySQL database integration
- JPA / Hibernate support
- Automatic schema updates with `spring.jpa.hibernate.ddl-auto=update`

### 7. Frontend-Ready REST APIs
- JSON request/response handling
- Clean REST endpoint design
- Token-based frontend integration
- Project creation and retrieval support
- AI chat integration support

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT Authentication
- MySQL
- Maven
- Groq API

---

## Project Structure

```text
buildwithus-backend/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── buildwithus/
│   │   │           ├── BuildwithusApplication.java
│   │   │           │
│   │   │           ├── config/
│   │   │           │   ├── SecurityConfig.java
│   │   │           │   └── CorsConfig.java
│   │   │           │
│   │   │           ├── controller/
│   │   │           │   ├── AuthController.java
│   │   │           │   ├── ProjectController.java
│   │   │           │   ├── AIChatController.java
│   │   │           │   └── UserController.java
│   │   │           │
│   │   │           ├── entity/
│   │   │           │   ├── User.java
│   │   │           │   ├── Project.java
│   │   │           │   └── AIChatRequest.java
│   │   │           │
│   │   │           ├── repository/
│   │   │           │   ├── UserRepository.java
│   │   │           │   └── ProjectRepository.java
│   │   │           │
│   │   │           ├── service/
│   │   │           │   ├── AuthService.java
│   │   │           │   ├── ProjectService.java
│   │   │           │   ├── AIChatService.java
│   │   │           │   └── UserService.java
│   │   │           │
│   │   │           ├── security/
│   │   │           │   ├── JwtUtil.java
│   │   │           │   ├── JwtFilter.java
│   │   │           │   └── CustomUserDetailsService.java
│   │   │           │
│   │   │           └── dto/
│   │   │               ├── LoginRequest.java
│   │   │               ├── RegisterRequest.java
│   │   │               └── AuthResponse.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-example.properties
│   │
│   └── test/
│
├── .mvn/
├── mvnw
├── mvnw.cmd
├── pom.xml
├── .gitignore
└── README.md
```

---

## API Endpoints

### Authentication
- `POST /api/auth/register`
- `POST /api/auth/login`

### Projects
- `POST /api/projects`
- `GET /api/projects`

### AI
- `POST /api/ai/chat`

---

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/buildwithus-backend.git
cd buildwithus-backend
```

### 2. Create MySQL Database

Create a MySQL database manually:

```sql
CREATE DATABASE buildwithus_db;
```

### 3. Generate Groq API Key

Go to the Groq Console and generate an API key:
https://console.groq.com/keys

You will need to paste this key into `application.properties`.

### 4. Update application.properties

Open the file:

```text
src/main/resources/application.properties
```

Then configure it like this:

```properties
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/buildwithus_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

jwt.secret=YOUR_JWT_SECRET

groq.api.key=YOUR_GROQ_API_KEY
groq.model=llama-3.3-70b-versatile
```

### 5. Run the Project

Using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Or from your IDE:
- Open the project in IntelliJ IDEA / VS Code / Spring Tool Suite
- Run `BuildwithusApplication.java`

---

## Important Configuration Notes

Before running the backend, make sure you:

- Create the MySQL database
- Update MySQL username and password
- Generate and paste your Groq API key
- Set your JWT secret
- Save the updated application.properties file

---

## Sample .gitignore

```gitignore
target/
.idea/
*.iml
.DS_Store
*.log
logs/
application-local.properties
.env
```

---

## Why This Project

BuildWithUs Backend is the backend foundation of a larger vision: an AI-powered platform where developers can connect, create, collaborate, and build projects together.

It can already:

- Authenticate users
- Manage projects
- Connect with MySQL
- Integrate AI responses using Groq
- Support frontend applications through REST APIs

This makes it suitable for:

- Full-stack development projects
- Portfolio showcase
- Hackathon demos
- Startup MVP development
- Internship or freelance project presentation

---

## 👨‍💻 Author & Contributors
<a href="https://github.com/gitKeshav11/BuildWithUs-Backend/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=gitKeshav11/BuildWithUs-Backend" />


  https://github.com/gitKeshav11/BuildWithUs-Backend.git
</a>

## 📞 Contact
### **Keshav Upadhyay**  
**Role:** Backend Developer (Java & Spring Boot)  
📧 Email: [keshavupadhyayje@gmail.com](mailto:keshavupadhyayje@gmail.com)  
🔗 LinkedIn: [Keshav Upadhyay](https://www.linkedin.com/in/keshavupadhyayje/)  
🐙 GitHub: [gitKeshav11](https://github.com/gitKeshav11)  

----

## Repository Info

- Repository Name: `BuildWithUs-Backend`
- Release Version: `v1.0.0`
- Type: Initial Stable Backend Release

---

## License

This project can be released under the MIT License if you choose to add one.
