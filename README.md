# Secure School Management System API

**Author:** Sadettin Celik  
**Student ID:** 40312

A secure RESTful API built with Spring Boot for managing a school system with user authentication and course management.

## Features

- User registration and authentication with JWT tokens
- Course management (CRUD operations)
- Role-based access control
- H2 Database for data storage

## Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Security with JWT
- Spring Data JPA
- H2 Database

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running the Application
1. Clone the repository
```bash
git clone https://github.com/SadettinCelik/Lab-14.-Securing-a-Java-Spring-Web-Application.git
```

2. Build the project
```bash
mvn clean install
```

3. Run the application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Authentication
- `POST /api/auth/register` - Register a new user
  ```json
  {
    "username": "testuser",
    "email": "test@example.com",
    "password": "password123"
  }
  ```
- `POST /api/auth/login` - Login and get JWT token
  - Use your username and password in the Authorization header

### Courses
- `GET /api/courses` - List all courses
- `POST /api/courses` - Create a new course
  ```json
  {
    "name": "Mathematics",
    "description": "This is a mathematics course"
  }
  ```
- `GET /api/courses/{id}` - Get course details
- `PUT /api/courses/{id}` - Update course
- `DELETE /api/courses/{id}` - Delete course

Note: All endpoints except `/api/auth/register` require JWT token in the Authorization header.
