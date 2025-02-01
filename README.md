# Secure School Management System API

**Author:** Sadettin Celik  
**Student ID:** 40312

A secure RESTful API built with Spring Boot for managing a school system, featuring user authentication, role-based access control, and course management.

## Features

- Multi-role user system (Student, Teacher, Admin)
- Secure authentication with JWT tokens
- Course management system
- Role-based access control for different operations
- Comprehensive API documentation with OpenAPI/Swagger
- Database migrations with Flyway
- Secure password policies and validation
- Detailed security logging and monitoring

## Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Security with JWT
- Spring Data JPA
- H2 Database
- Flyway Migration
- OpenAPI/Swagger Documentation
- Project Lombok
- JUnit & Spring Test

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Your favorite IDE (IntelliJ IDEA recommended)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/school-management.git
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## API Endpoints

### Authentication
- `POST /api/auth/register` - Register a new user
  ```json
  {
    "username": "user",
    "email": "user@example.com",
    "password": "StrongPassword123!"
  }
  ```
- `POST /api/auth/login` - Login and get JWT token
  ```json
  {
    "username": "user",
    "password": "StrongPassword123!"
  }
  ```

### Courses
- `GET /api/courses` - List all courses (requires authentication)
- `POST /api/courses` - Create a new course (TEACHER/ADMIN only)
- `GET /api/courses/{id}` - Get course details
- `PUT /api/courses/{id}` - Update course (TEACHER/ADMIN only)
- `DELETE /api/courses/{id}` - Delete course (ADMIN only)

### Users
- `GET /api/users/profile` - Get current user profile
- `PUT /api/users/profile` - Update user profile
- `GET /api/users` - List all users (ADMIN only)

## Security Features

1. **Authentication & Authorization**
   - JWT-based authentication
   - Role-based access control
   - Secure password storage with BCrypt
   - Token expiration and refresh mechanisms

2. **Rate Limiting**
   - Authentication endpoints: 30 requests per minute
   - API endpoints: 100 requests per minute
   - Headers: `X-Rate-Limit-Remaining`, `X-Rate-Limit-Retry-After-Seconds`

3. **Password Policy**
   - Minimum 14 characters
   - Must contain at least:
     - One uppercase letter
     - One lowercase letter
     - One number
     - One special character
   - Cannot contain username
   - Cannot be a common password

4. **Security Headers**
   - CSRF protection
   - XSS protection
   - Content Security Policy
   - Secure Cookie configuration

5. **Logging & Monitoring**
   - Security event logging
   - Failed login attempts tracking
   - Suspicious activity monitoring
   - Audit logging for critical operations

## API Documentation

After starting the application, you can access the Swagger UI at:
`http://localhost:8080/swagger-ui.html`

## Testing

The project includes both unit and integration tests:
- Unit tests for service layer logic
- Integration tests for REST endpoints
- Security test cases for authentication and authorization
- Repository layer tests

Run tests with:
```bash
mvn test
```

## Database Schema

The application uses H2 database with the following main tables:
- `users` - Store user information and credentials
- `courses` - Store course information
- `user_roles` - Store user role assignments

Database migrations are handled by Flyway to ensure consistent schema updates.
