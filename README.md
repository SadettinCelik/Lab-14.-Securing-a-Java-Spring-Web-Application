# Secure Blog API Implementation

**Developer:** Sadettin Celik  
**Student ID:** 40312

A Spring Boot application demonstrating secure blog functionality with user authentication and post management.

## Implemented Features

### 1. User Management
- User registration with email validation
- Secure password storage using BCrypt
- Basic Authentication for login
- Role-based authorization (USER, ADMIN)

### 2. Post Management
- Create new blog posts
- View all posts or single post
- Update existing posts (author only)
- Delete posts (author or admin)
- Automatic author assignment

### 3. Security Features
- Basic Authentication integration
- Role-based access control
- Input validation
- Cross-Site Scripting (XSS) protection
- SQL injection protection via JPA

### 4. Data Storage
- H2 Database with file persistence
- Automatic schema generation
- Data integrity with foreign key constraints

### 5. Testing
- Unit tests for services
- Integration tests for controllers
- Security test coverage

## API Documentation

### Authentication Endpoints
```
POST /auth/register
GET  /auth/login
```

### Post Management Endpoints
```
GET    /api/posts      # List all posts
POST   /api/posts      # Create new post
GET    /api/posts/{id} # Get single post
PUT    /api/posts/{id} # Update post
DELETE /api/posts/{id} # Delete post
```

## Running the Application

```bash
# Build the project
mvn clean install

# Start the application
mvn spring-boot:run

# Access the application
http://localhost:8080
```

## Technology Stack
- Spring Boot 3.2.2
- Spring Security
- Spring Data JPA
- H2 Database
- JUnit 5
