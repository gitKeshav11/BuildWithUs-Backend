# Build With Us Backend

<p align="center">
  <b>Developer Social + Collaboration + Jobs + AI Ecosystem Platform API</b>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2.1-brightgreen?style=for-the-badge&logo=springboot" />
  <img src="https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql" />
  <img src="https://img.shields.io/badge/Redis-7-red?style=for-the-badge&logo=redis" />
  <img src="https://img.shields.io/badge/Docker-Ready-blue?style=for-the-badge&logo=docker" />
</p>

---

## Table of Contents

- [About the Project](#about-the-project)
- [Core Features](#core-features)
- [Tech Stack](#tech-stack)
- [Project Architecture](#project-architecture)
- [Folder Structure](#folder-structure)
- [Database Schema / Migrations](#database-schema--migrations)
- [Environment Variables](#environment-variables)
- [Local Setup Without Docker](#local-setup-without-docker)
- [Setup With Docker Compose](#setup-with-docker-compose)
- [API Documentation / Swagger](#api-documentation--swagger)
- [Authentication Flow](#authentication-flow)
- [Main API Endpoints](#main-api-endpoints)
- [OAuth2 Setup](#oauth2-setup)
- [Cloudinary Upload Setup](#cloudinary-upload-setup)
- [Groq AI Setup](#groq-ai-setup)
- [Mail Setup](#mail-setup)
- [Useful Commands](#useful-commands)
- [Troubleshooting](#troubleshooting)
- [Contribution Guide](#contribution-guide)

---

## About the Project

**Build With Us Backend** is a Spring Boot REST API for a developer-focused ecosystem platform. The backend supports user authentication, developer profiles, following, jobs, projects, collaboration requests, hackathons, team finder posts, verification, leaderboard, notifications, file uploads, and AI-powered chat/code review functionality.

The application is built with a layered architecture:

```text
Controller → Service → Repository → Entity → Database
```

It uses **JWT authentication** for protected APIs, **OAuth2 login** for Google/GitHub/LinkedIn, **Flyway** for database migrations, **MySQL** for persistence, **Redis** for session/cache support, **Cloudinary** for media upload, and **Groq API** for AI features.

---

## Core Features

### Authentication & Authorization

- User registration and login
- JWT access token and refresh token flow
- Logout support
- Forgot password and reset password
- Email verification
- Change password
- OAuth2 login with:
  - Google
  - GitHub
  - LinkedIn
- Role based access control
- Admin protected endpoints

### Developer Profiles

- Create/update logged-in user profile
- Public profile by username
- Profile search and filters
- Verified profile listing
- Profile photo upload
- Cover image upload
- Skills and tech stack mapping

### Social Features

- Follow/unfollow users
- Followers listing
- Following listing
- Follow stats
- Follow check API

### Projects & Collaboration

- Create, update, delete projects
- Project search and filters
- Open collaboration projects
- User-owned projects
- Projects where user is collaborating
- Collaboration request flow
- Accept/reject collaboration requests
- Project collaborators listing
- Project image upload/delete

### Jobs

- Create, update, delete job posts
- Job listing
- Job search and filters
- Featured jobs
- User posted jobs
- Save/unsave jobs
- Saved jobs listing
- Job click tracking

### Hackathons & Team Finder

- Create, update, delete hackathons
- Hackathon listing and search
- Team finder posts
- Team finder by type
- Team finder by hackathon
- Join request flow
- Accept/reject team join requests

### AI Features

- AI code review requests
- AI chat conversations
- Send messages inside conversations
- Conversation history
- Delete conversations/reviews
- Rate limit support for AI requests

### Verification, Leaderboard & Notifications

- Verification request submission
- Verification status tracking
- Admin review of verification requests
- Leaderboard entries
- User badges
- Notifications listing
- Unread count
- Mark read / mark all read
- Delete notification

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.2.1 |
| API | Spring Web MVC |
| Security | Spring Security, JWT, OAuth2 Client |
| Database | MySQL 8.0 |
| ORM | Spring Data JPA / Hibernate |
| Migration | Flyway |
| Cache / Session | Redis, Spring Session Data Redis |
| Validation | Spring Boot Validation |
| Mail | Spring Boot Mail |
| API Docs | Springdoc OpenAPI / Swagger UI |
| Uploads | Cloudinary |
| AI | Groq API via WebClient |
| Build Tool | Maven |
| Containerization | Docker, Docker Compose |
| Utility | Lombok, MapStruct |

---

## Project Architecture

```text
com.buildwithus
├── admin          # Admin dashboard APIs
├── ai             # AI chat and code review module
├── auth           # Login, register, refresh token, password reset, email verification
├── common         # Common DTOs, base entity, enums
├── config         # Spring configuration classes
├── exception      # Custom exceptions and global exception handler
├── follow         # Follow/unfollow system
├── hackathon      # Hackathon and team finder system
├── job            # Job posting and saved jobs system
├── leaderboard    # Points, badges, leaderboard APIs
├── notification   # Notification and email services
├── profile        # Developer profile, skills, tech stack
├── project        # Projects, collaboration, project images
├── security       # JWT, user principal, OAuth2 handlers
├── upload         # Cloudinary upload APIs
├── user           # User APIs, roles, social accounts
└── verification   # Profile verification request flow
```

---

## Folder Structure

```text
BuildWithUs-Backend-main/
├── .env.example
├── .gitignore
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── buildwithus/
        │           ├── BuildWithUsApplication.java
        │           ├── admin/
        │           │   ├── controller/
        │           │   └── dto/
        │           ├── ai/
        │           │   ├── controller/
        │           │   ├── dto/
        │           │   ├── entity/
        │           │   ├── repository/
        │           │   └── service/
        │           ├── auth/
        │           │   ├── controller/
        │           │   ├── dto/
        │           │   ├── entity/
        │           │   ├── repository/
        │           │   └── service/
        │           ├── common/
        │           │   ├── dto/
        │           │   ├── entity/
        │           │   └── enums/
        │           ├── config/
        │           ├── exception/
        │           ├── follow/
        │           ├── hackathon/
        │           ├── job/
        │           ├── leaderboard/
        │           ├── notification/
        │           ├── profile/
        │           ├── project/
        │           ├── security/
        │           │   └── oauth2/
        │           ├── upload/
        │           ├── user/
        │           └── verification/
        └── resources/
            ├── application.yml
            ├── application-docker.yml
            └── db/
                └── migration/
                    ├── V1__initial_schema.sql
                    ├── V2__jobs_schema.sql
                    ├── V3__projects_schema.sql
                    ├── V4__ai_schema.sql
                    ├── V5__verification_hackathon_schema.sql
                    └── V6__leaderboard_notification_schema.sql
```

---

## Database Schema / Migrations

Flyway migrations are inside:

```text
src/main/resources/db/migration/
```

| Migration | Purpose |
|---|---|
| `V1__initial_schema.sql` | Roles, users, user roles, social accounts, refresh tokens, email verification, password reset, skills, tech stacks, developer profiles, follows |
| `V2__jobs_schema.sql` | Jobs, job tags, saved jobs |
| `V3__projects_schema.sql` | Projects, project tech stacks, roles needed, images, collaborators, collaboration requests |
| `V4__ai_schema.sql` | Code review requests, chat conversations, chat messages |
| `V5__verification_hackathon_schema.sql` | Verification requests, hackathons, team finder posts, team join requests |
| `V6__leaderboard_notification_schema.sql` | User badges, leaderboard points, notifications |

The application uses:

```yaml
spring.jpa.hibernate.ddl-auto: none
spring.flyway.enabled: true
```

So tables are created by Flyway migrations, not by Hibernate auto-generation.

---

## Environment Variables

Create a `.env` file in the project root by copying `.env.example`:

```bash
cp .env.example .env
```

For Windows PowerShell:

```powershell
copy .env.example .env
```

### Required Variables

```env
# Database
DB_HOST=localhost
DB_PORT=3306
DB_NAME=buildwithus
DB_USERNAME=root
DB_PASSWORD=your_mysql_password

# JWT
JWT_SECRET=replace_with_a_long_random_secret_at_least_32_chars

# Frontend
FRONTEND_URL=http://localhost:5173
CORS_ALLOWED_ORIGINS=http://localhost:3000,http://localhost:5173
```

### Optional Variables

```env
# OAuth2
GOOGLE_CLIENT_ID=your_google_client_id
GOOGLE_CLIENT_SECRET=your_google_client_secret
GITHUB_CLIENT_ID=your_github_client_id
GITHUB_CLIENT_SECRET=your_github_client_secret
LINKEDIN_CLIENT_ID=your_linkedin_client_id
LINKEDIN_CLIENT_SECRET=your_linkedin_client_secret

# Mail
MAIL_HOST=smtp.gmail.com
MAIL_PORT=587
MAIL_USERNAME=your_email@gmail.com
MAIL_PASSWORD=your_app_password

# Cloudinary
CLOUDINARY_CLOUD_NAME=your_cloud_name
CLOUDINARY_API_KEY=your_cloudinary_api_key
CLOUDINARY_API_SECRET=your_cloudinary_api_secret

# Groq AI
GROQ_API_KEY=your_groq_api_key_here
AI_REQUESTS_PER_HOUR=20

# Redis
SPRING_DATA_REDIS_ENABLED=false
SPRING_DATA_REDIS_HOST=localhost
SPRING_DATA_REDIS_PORT=6379

# Server
SERVER_PORT=8080
```

---

## Local Setup Without Docker

### Prerequisites

Install these tools first:

- Java 17
- Maven 3.9+
- MySQL 8.0
- Redis, optional for local dev
- Git
- Postman, optional

### Step 1: Clone the Project

```bash
git clone <your-repository-url>
cd BuildWithUs-Backend-main
```

### Step 2: Create MySQL Database

Login to MySQL:

```bash
mysql -u root -p
```

Create database:

```sql
CREATE DATABASE buildwithus;
```

Exit MySQL:

```sql
EXIT;
```

### Step 3: Configure `.env`

```bash
cp .env.example .env
```

Update DB credentials:

```env
DB_HOST=localhost
DB_PORT=3306
DB_NAME=buildwithus
DB_USERNAME=root
DB_PASSWORD=your_mysql_password
JWT_SECRET=replace_with_a_long_random_secret_at_least_32_chars
```

### Step 4: Build the Project

```bash
mvn clean install
```

To skip tests:

```bash
mvn clean install -DskipTests
```

### Step 5: Run the Application

```bash
mvn spring-boot:run
```

Or run the generated jar:

```bash
mvn clean package -DskipTests
java -jar target/*.jar
```

### Step 6: Verify Server

Open:

```text
http://localhost:8080/actuator/health
```

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## Setup With Docker Compose

This project already contains:

- `Dockerfile`
- `docker-compose.yml`

Docker Compose starts:

| Service | Container | Port |
|---|---|---|
| Spring Boot App | `buildwithus-backend` | `8080:8080` |
| MySQL | `buildwithus-mysql` | `3307:3306` |
| Redis | `buildwithus-redis` | `6379:6379` |

### Step 1: Create `.env`

```bash
cp .env.example .env
```

At minimum, set:

```env
JWT_SECRET=replace_with_a_long_random_secret_at_least_32_chars
FRONTEND_URL=http://localhost:5173
CORS_ALLOWED_ORIGINS=http://localhost:3000,http://localhost:5173
```

### Step 2: Build and Start Containers

```bash
docker compose up --build
```

Run in detached mode:

```bash
docker compose up --build -d
```

### Step 3: Check Running Containers

```bash
docker ps
```

### Step 4: Check Logs

```bash
docker compose logs -f app
```

### Step 5: Stop Containers

```bash
docker compose down
```

### Step 6: Stop and Remove Volumes

Use this only when you want to delete MySQL and Redis data:

```bash
docker compose down -v
```

---

## API Documentation / Swagger

After running the app, open:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI JSON:

```text
http://localhost:8080/api-docs
```

Swagger is configured with Bearer JWT security. For protected APIs:

1. Login using `/api/v1/auth/login`.
2. Copy `accessToken` from response.
3. Click **Authorize** in Swagger.
4. Paste token as:

```text
Bearer your_access_token_here
```

---

## Authentication Flow

### Register

```http
POST /api/v1/auth/register
```

### Login

```http
POST /api/v1/auth/login
```

After login, use the returned access token in protected APIs:

```http
Authorization: Bearer <access_token>
```

### Refresh Token

```http
POST /api/v1/auth/refresh
```

### Logout

```http
POST /api/v1/auth/logout
```

### Forgot Password

```http
POST /api/v1/auth/forgot-password
```

### Reset Password

```http
POST /api/v1/auth/reset-password
```

### Verify Email

```http
GET /api/v1/auth/verify-email?token=<token>
```

### OAuth2 Login URLs

```text
http://localhost:8080/oauth2/authorization/google
http://localhost:8080/oauth2/authorization/github
http://localhost:8080/oauth2/authorization/linkedin
```

---

## Main API Endpoints

Base URL:

```text
http://localhost:8080
```

### Auth APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/auth/register` | Register user |
| POST | `/api/v1/auth/login` | Login user |
| POST | `/api/v1/auth/refresh` | Refresh JWT token |
| POST | `/api/v1/auth/logout` | Logout user |
| POST | `/api/v1/auth/forgot-password` | Send password reset mail |
| POST | `/api/v1/auth/reset-password` | Reset password |
| GET | `/api/v1/auth/verify-email` | Verify email token |
| POST | `/api/v1/auth/resend-verification` | Resend verification email |
| POST | `/api/v1/auth/change-password` | Change password |

### User APIs

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/v1/users/me` | Logged-in user details |
| GET | `/api/v1/users` | List users |
| GET | `/api/v1/users/search` | Search users |
| POST | `/api/v1/users/{userId}/block` | Block user |
| POST | `/api/v1/users/{userId}/unblock` | Unblock user |
| DELETE | `/api/v1/users/{userId}` | Delete user |

### Profile APIs

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/v1/profiles/me` | Logged-in user profile |
| PUT | `/api/v1/profiles/me` | Update profile |
| GET | `/api/v1/profiles/{username}` | Public profile by username |
| GET | `/api/v1/profiles` | List profiles |
| GET | `/api/v1/profiles/search` | Search profiles |
| GET | `/api/v1/profiles/filter` | Filter profiles |
| GET | `/api/v1/profiles/verified` | Verified profiles |
| POST | `/api/v1/profiles/me/photo` | Upload profile photo |
| POST | `/api/v1/profiles/me/cover` | Upload cover image |
| DELETE | `/api/v1/profiles/me/photo` | Delete profile photo |
| DELETE | `/api/v1/profiles/me/cover` | Delete cover image |

### Follow APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/follows/{userId}` | Follow user |
| DELETE | `/api/v1/follows/{userId}` | Unfollow user |
| GET | `/api/v1/follows/{userId}/followers` | Get followers |
| GET | `/api/v1/follows/{userId}/following` | Get following |
| GET | `/api/v1/follows/{userId}/stats` | Get follow stats |
| GET | `/api/v1/follows/{userId}/check` | Check follow status |

### Project APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/projects` | Create project |
| PUT | `/api/v1/projects/{projectId}` | Update project |
| DELETE | `/api/v1/projects/{projectId}` | Delete project |
| GET | `/api/v1/projects/{projectId}` | Get project by ID |
| GET | `/api/v1/projects/slug/{slug}` | Get project by slug |
| GET | `/api/v1/projects` | List projects |
| GET | `/api/v1/projects/search` | Search projects |
| GET | `/api/v1/projects/filter` | Filter projects |
| GET | `/api/v1/projects/my-projects` | Logged-in user's projects |
| GET | `/api/v1/projects/open-collaboration` | Open collaboration projects |
| GET | `/api/v1/projects/collaborating` | Projects where user collaborates |
| POST | `/api/v1/projects/{projectId}/collaborate` | Send collaboration request |
| POST | `/api/v1/projects/collaboration-requests/{requestId}/respond` | Accept/reject request |
| GET | `/api/v1/projects/my-collaboration-requests` | My sent requests |
| GET | `/api/v1/projects/requests-for-my-projects` | Requests for my projects |
| GET | `/api/v1/projects/{projectId}/requests` | Project requests |
| GET | `/api/v1/projects/{projectId}/collaborators` | Project collaborators |
| DELETE | `/api/v1/projects/{projectId}/collaborators/{collaboratorId}` | Remove collaborator |
| POST | `/api/v1/projects/{projectId}/images` | Upload project image |
| DELETE | `/api/v1/projects/{projectId}/images/{imageId}` | Delete project image |

### Job APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/jobs` | Create job |
| PUT | `/api/v1/jobs/{jobId}` | Update job |
| DELETE | `/api/v1/jobs/{jobId}` | Delete job |
| GET | `/api/v1/jobs/{jobId}` | Get job by ID |
| GET | `/api/v1/jobs` | List jobs |
| GET | `/api/v1/jobs/search` | Search jobs |
| GET | `/api/v1/jobs/filter` | Filter jobs |
| GET | `/api/v1/jobs/featured` | Featured jobs |
| GET | `/api/v1/jobs/my-posts` | My posted jobs |
| POST | `/api/v1/jobs/{jobId}/save` | Save job |
| DELETE | `/api/v1/jobs/{jobId}/save` | Unsave job |
| GET | `/api/v1/jobs/saved` | Saved jobs |
| POST | `/api/v1/jobs/{jobId}/click` | Track job click |

### Hackathon APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/hackathons` | Create hackathon |
| PUT | `/api/v1/hackathons/{hackathonId}` | Update hackathon |
| DELETE | `/api/v1/hackathons/{hackathonId}` | Delete hackathon |
| GET | `/api/v1/hackathons/{hackathonId}` | Get hackathon by ID |
| GET | `/api/v1/hackathons` | List hackathons |
| GET | `/api/v1/hackathons/search` | Search hackathons |
| POST | `/api/v1/hackathons/team-finder` | Create team finder post |
| GET | `/api/v1/hackathons/team-finder` | List team finder posts |
| GET | `/api/v1/hackathons/team-finder/type/{type}` | Team finder by type |
| GET | `/api/v1/hackathons/team-finder/my-posts` | My team finder posts |
| GET | `/api/v1/hackathons/{hackathonId}/team-finder` | Team finder for hackathon |
| POST | `/api/v1/hackathons/team-finder/{postId}/join` | Send join request |
| POST | `/api/v1/hackathons/team-finder/join-requests/{requestId}/respond` | Respond to join request |
| GET | `/api/v1/hackathons/team-finder/my-join-requests` | My join requests |
| GET | `/api/v1/hackathons/team-finder/requests-for-my-posts` | Requests for my posts |

### AI Chat APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/ai/chat/conversations` | Create conversation |
| POST | `/api/v1/ai/chat/conversations/{conversationId}/messages` | Send message |
| GET | `/api/v1/ai/chat/conversations/{conversationId}` | Get conversation |
| GET | `/api/v1/ai/chat/conversations` | List conversations |
| DELETE | `/api/v1/ai/chat/conversations/{conversationId}` | Delete conversation |

### AI Code Review APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/ai/code-review` | Create code review request |
| GET | `/api/v1/ai/code-review/{reviewId}` | Get review by ID |
| GET | `/api/v1/ai/code-review` | List code reviews |
| DELETE | `/api/v1/ai/code-review/{reviewId}` | Delete review |

### Verification APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/verification/request` | Submit verification request |
| GET | `/api/v1/verification/status` | Check verification status |
| GET | `/api/v1/verification/pending` | Pending requests, admin |
| POST | `/api/v1/verification/{requestId}/review` | Review request, admin |

### Leaderboard APIs

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/v1/leaderboard` | Get leaderboard |
| GET | `/api/v1/leaderboard/me` | My leaderboard entry |
| GET | `/api/v1/leaderboard/user/{userId}` | User leaderboard entry |
| GET | `/api/v1/leaderboard/user/{userId}/badges` | User badges |
| GET | `/api/v1/leaderboard/me/badges` | My badges |

### Notification APIs

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/v1/notifications` | List notifications |
| GET | `/api/v1/notifications/unread-count` | Unread notification count |
| POST | `/api/v1/notifications/{notificationId}/read` | Mark notification read |
| POST | `/api/v1/notifications/read-all` | Mark all notifications read |
| DELETE | `/api/v1/notifications/{notificationId}` | Delete notification |

### Upload APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/uploads/image` | Upload image to Cloudinary |

### Admin APIs

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/v1/admin/stats` | Admin dashboard stats |

---

## OAuth2 Setup

The project supports Google, GitHub and LinkedIn OAuth2 login.

### Redirect URIs

Use these callback URLs in provider dashboards:

```text
Google:   http://localhost:8080/login/oauth2/code/google
GitHub:   http://localhost:8080/login/oauth2/code/github
LinkedIn: http://localhost:8080/login/oauth2/code/linkedin
```

### Frontend Redirect

OAuth success/failure handlers use:

```env
FRONTEND_URL=http://localhost:5173
```

Make sure your frontend has routes to handle OAuth redirects and token parameters returned from backend.

---

## Cloudinary Upload Setup

For image upload APIs, add Cloudinary credentials in `.env`:

```env
CLOUDINARY_CLOUD_NAME=your_cloud_name
CLOUDINARY_API_KEY=your_cloudinary_api_key
CLOUDINARY_API_SECRET=your_cloudinary_api_secret
```

Image upload endpoints use `multipart/form-data`.

Example key name is commonly `file`, but confirm exact request parameter in controller/service if you customize upload logic.

---

## Groq AI Setup

AI chat and code review features require:

```env
GROQ_API_KEY=your_groq_api_key_here
AI_REQUESTS_PER_HOUR=20
```

If the key is missing, AI endpoints may fail or return an error depending on service logic.

---

## Mail Setup

For email verification and password reset, configure SMTP:

```env
MAIL_HOST=smtp.gmail.com
MAIL_PORT=587
MAIL_USERNAME=your_email@gmail.com
MAIL_PASSWORD=your_app_password
```

For Gmail, use an **App Password**, not your normal Gmail password.

---

## Useful Commands

### Maven

```bash
mvn clean
mvn clean install
mvn clean package -DskipTests
mvn spring-boot:run
```

### Docker

```bash
docker compose up --build
docker compose up --build -d
docker compose logs -f app
docker compose down
docker compose down -v
```

### MySQL in Docker

```bash
docker exec -it buildwithus-mysql mysql -u root -p
```

Password from `docker-compose.yml`:

```text
root
```

Use database:

```sql
USE buildwithus;
SHOW TABLES;
```

### Redis in Docker

```bash
docker exec -it buildwithus-redis redis-cli
```

Test Redis:

```bash
PING
```

Expected:

```text
PONG
```

---

## Security Rules

Public routes:

- `/api/v1/auth/**`
- `/oauth2/**`
- `GET /api/v1/profiles/**`
- `GET /api/v1/projects/**`
- `GET /api/v1/jobs/**`
- `GET /api/v1/hackathons/**`
- `GET /api/v1/leaderboard/**`
- `/api-docs/**`
- `/swagger-ui/**`
- `/swagger-ui.html`
- `/actuator/health`
- `/actuator/info`

Admin-only routes:

- `/api/v1/admin/**`

All other routes require JWT authentication.

---

## Troubleshooting

### 1. MySQL Connection Error

Check `.env`:

```env
DB_HOST=localhost
DB_PORT=3306
DB_NAME=buildwithus
DB_USERNAME=root
DB_PASSWORD=your_mysql_password
```

If using Docker, app uses MySQL container host:

```env
DB_HOST=mysql
DB_PORT=3306
```

### 2. Flyway Migration Error

If database is corrupted during development, reset local DB:

```sql
DROP DATABASE buildwithus;
CREATE DATABASE buildwithus;
```

Then restart app.

For Docker:

```bash
docker compose down -v
docker compose up --build
```

### 3. JWT Secret Error

JWT secret must be long enough. Use at least 32 characters:

```env
JWT_SECRET=this_is_a_very_long_secret_key_for_local_dev_12345
```

### 4. CORS Error From Frontend

Add frontend URL:

```env
CORS_ALLOWED_ORIGINS=http://localhost:3000,http://localhost:5173
FRONTEND_URL=http://localhost:5173
```

Restart backend after changing `.env`.

### 5. OAuth Redirect Error

Check provider dashboard redirect URI exactly:

```text
http://localhost:8080/login/oauth2/code/google
http://localhost:8080/login/oauth2/code/github
http://localhost:8080/login/oauth2/code/linkedin
```

Also confirm client ID and secret are present in `.env`.

### 6. Port Already in Use

If port `8080` is busy:

```env
SERVER_PORT=8081
```

Or stop existing process using port 8080.

### 7. Docker MySQL Port Confusion

In Docker Compose:

```text
Host machine: localhost:3307
Inside Docker network: mysql:3306
```

So from MySQL Workbench use:

```text
Host: localhost
Port: 3307
User: root
Password: root
```

But the backend container should use:

```text
DB_HOST=mysql
DB_PORT=3306
```

---

## Recommended Postman Flow

1. Register user
2. Login user
3. Copy access token
4. Add header:

```http
Authorization: Bearer <access_token>
```

5. Test protected APIs like:

```http
GET /api/v1/users/me
GET /api/v1/profiles/me
POST /api/v1/projects
POST /api/v1/jobs
```

---

## Contribution Guide

### Step 1: Fork Repository

Click **Fork** on GitHub.

### Step 2: Clone Fork

```bash
git clone https://github.com/<your-username>/<repo-name>.git
cd <repo-name>
```

### Step 3: Create Branch

```bash
git checkout -b feature/your-feature-name
```

### Step 4: Make Changes

Follow existing package pattern:

```text
controller → dto → entity → repository → service → service/impl
```

### Step 5: Test Locally

```bash
mvn clean install
```

### Step 6: Commit and Push

```bash
git add .
git commit -m "feat: add your feature"
git push origin feature/your-feature-name
```

### Step 7: Open Pull Request

Create a PR with:

- Clear title
- What changed
- Why it changed
- Testing proof
- Screenshots/API responses if required

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

## License

This project is configured in OpenAPI metadata as MIT License. Add a `LICENSE` file in the repository root if not already present.
