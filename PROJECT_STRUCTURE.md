# Student Management System - Complete Project Structure

## Project Overview
This is a complete Spring Boot application with MongoDB for managing student data, including a frontend HTML interface.

## Project Structure

```
Day3SMS/
├── src/main/java/com/example/Day3SMS/
│   ├── config/
│   │   └── CorsConfig.java              ✅ CORS configuration for frontend access
│   ├── controller/
│   │   └── Studentcontroller.java       ✅ REST API endpoints (uses DTOs)
│   ├── dto/
│   │   ├── StudentRequestDto.java        ✅ Request DTO with validation
│   │   └── StudentResponseDto.java      ✅ Response DTO with message field
│   ├── exception/
│   │   ├── ErrorResponse.java           ✅ Error response structure
│   │   ├── GlobalExceptionHandler.java  ✅ Global exception handling
│   │   └── StudentNotFoundException.java ✅ Custom exception
│   ├── model/
│   │   └── StudentModel.java            ✅ MongoDB entity model
│   ├── repository/
│   │   └── StudentRepository.java       ✅ MongoDB repository with custom queries
│   ├── service/
│   │   └── StudentService.java          ✅ Business logic (uses DTOs)
│   └── Day3SmsApplication.java          ✅ Main Spring Boot application
├── src/main/resources/
│   └── application.properties           ✅ MongoDB configuration
├── frontend/
│   ├── index.html                       ✅ Complete HTML frontend
│   └── README.md                        ✅ Frontend documentation
└── pom.xml                              ✅ Maven dependencies

```

## API Endpoints

### Base URL: `/api/students`

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| GET | `/api/students/test` | Test endpoint | - | String |
| POST | `/api/students` | Create student | StudentRequestDto | StudentResponseDto |
| POST | `/api/students/add-student` | Create student (alt) | StudentRequestDto | StudentResponseDto |
| GET | `/api/students` | Get all students | - | List<StudentResponseDto> |
| GET | `/api/students/{id}` | Get student by ID | - | StudentResponseDto |
| PUT | `/api/students/{id}` | Update student | StudentRequestDto | StudentResponseDto |
| PUT | `/api/students/update/{id}` | Update student (alt) | StudentRequestDto | StudentResponseDto |
| DELETE | `/api/students/{id}` | Delete student | - | String |

## DTOs (Data Transfer Objects)

### StudentRequestDto
- `name` (String, required, not blank)
- `age` (int, required, min: 5, max: 90)
- `email` (String, required, valid email)

### StudentResponseDto
- `id` (String)
- `name` (String)
- `age` (int)
- `email` (String)
- `message` (String, optional)

## Exception Handling

### Custom Exceptions
- `StudentNotFoundException` - Thrown when student not found

### Global Exception Handler
Handles:
- `MethodArgumentNotValidException` - Validation errors (400)
- `ConstraintViolationException` - Constraint violations (400)
- `StudentNotFoundException` - Student not found (404)
- `RuntimeException` - Generic runtime errors (500)
- `Exception` - All other exceptions (500)

## Repository Custom Queries

- `findByEmail(String email)` - Find by email
- `findByNameIgnoreCase(String name)` - Find by name (case-insensitive)
- `findByAge(int age)` - Find by age
- `findByAgeBetween(int minAge, int maxAge)` - Find by age range
- `findByNameContainingIgnoreCase(String name)` - Find by name containing
- `existsByEmail(String email)` - Check if email exists
- `findStudentsOlderThan(int age)` - Custom query for older students
- `findStudentsYoungerThan(int age)` - Custom query for younger students
- `findStudentsByNamePattern(String pattern)` - Custom query by name pattern

## Features Completed

✅ **DTOs**: Complete with getters/setters and validation
✅ **Controller**: Uses DTOs, proper HTTP status codes, RESTful design
✅ **Service**: DTO conversion, proper exception handling, all CRUD operations
✅ **Exception Handling**: Global exception handler with proper error responses
✅ **Model**: Clean with Lombok annotations and validation
✅ **Repository**: Custom query methods for advanced searches
✅ **Frontend**: Complete HTML interface with all CRUD operations
✅ **CORS**: Configured for frontend access

## How to Run

1. **Start MongoDB** (default: localhost:27017)
2. **Run Spring Boot Application**:
   ```bash
   mvn spring-boot:run
   ```
3. **Open Frontend**: Open `frontend/index.html` in browser

## Database Configuration

MongoDB URI: `mongodb://localhost:27017/springTest`
Collection: `students`
