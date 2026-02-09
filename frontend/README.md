# Frontend - Student Management System

This folder contains the frontend HTML pages for the Student Management System.

## Files

- `index.html` - Main HTML page with forms to interact with the Student API

## How to Use

1. Make sure your Spring Boot application is running on `http://localhost:8080`
2. Open `index.html` in your web browser
3. You can:
   - Add new students using the "Add New Student" form
   - Update existing students using the "Update Student" form
   - View all students in the "All Students" section
   - Delete students by clicking the "Delete" button on any student card
   - Edit students by clicking the "Edit" button (fills the update form automatically)

## API Endpoints Used

- `GET /students` - Get all students
- `POST /add-student` - Add a new student
- `PUT /update/{id}` - Update a student by ID
- `DELETE /students/{id}` - Delete a student by ID

## Note

Make sure CORS is enabled in your Spring Boot application (already configured in `CorsConfig.java`) to allow the frontend to access the API.
