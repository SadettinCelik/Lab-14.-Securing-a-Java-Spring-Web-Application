# Secure Blog API Implementation

**Developer:** Sadettin Celik  
**Student ID:** 40312

A Spring Boot application demonstrating secure blog functionality with user authentication and post management.

## Implemented Features

### 1. User Management
- User registration with email validation
- Secure password storage using BCrypt
- POST-based authentication for login
- Role-based authorization (USER, ADMIN)
- Strong password policy enforcement
  - Minimum 14 characters
  - Must contain uppercase and lowercase letters
  - Must contain numbers
  - Must contain special characters

### 2. Post Management
- Create new blog posts
- View all posts or single post
- Update existing posts (author only)
- Delete posts (author or admin)
- Automatic author assignment

### 3. Security Features
- POST-based authentication with Spring Security
- Role-based access control
- Input validation with custom validators
- Cross-Site Scripting (XSS) protection
- SQL injection protection via JPA
- CSRF protection
- Secure password validation
- Sensitive data masking in responses
- Security event logging with AOP
- Session management (stateless)

### 4. Data Storage
- H2 Database with file persistence
- Automatic schema generation
- Data integrity with foreign key constraints
- Flyway database migrations

### 5. Testing
- Unit tests for services
- Integration tests for controllers
- Security test coverage
- Authentication test scenarios
- Password validation tests

## API Documentation

### Authentication Endpoints
```
POST /auth/register    # Register new user
POST /auth/login      # Authenticate user
```

### Post Management Endpoints
```
GET    /api/posts      # List all posts
POST   /api/posts      # Create new post
GET    /api/posts/{id} # Get single post
PUT    /api/posts/{id} # Update post
DELETE /api/posts/{id} # Delete post
```

## Security Implementation Details

### Password Policy
The application enforces a strong password policy:
- Minimum length: 14 characters
- Must contain: uppercase, lowercase, numbers, special characters
- Custom validation messages for each requirement

### Authentication Flow
1. User registers with email and strong password
2. Password is hashed using BCrypt before storage
3. Login requires POST request with credentials
4. Successful login returns JWT token
5. Protected endpoints require valid authentication

### Security Logging
- Login attempts are logged with masked usernames
- Authentication failures are tracked
- Secure endpoint access is monitored
- Sensitive data is masked in logs

### Data Protection
- Passwords are never returned in API responses
- Email addresses are validated
- Input is sanitized to prevent XSS
- CSRF tokens required for state-changing operations

## Recent Updates
1. Enhanced password validation with custom validator
2. Implemented comprehensive security logging
3. Added test coverage for security features
4. Updated authentication to use POST endpoints
5. Implemented proper session management

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
