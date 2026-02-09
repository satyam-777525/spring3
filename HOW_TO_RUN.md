# How to Run the Student Management System

## Prerequisites

Before running the project, make sure you have the following installed:

1. **Java 21** (JDK 21)
   - Check version: `java -version`
   - Download from: https://www.oracle.com/java/technologies/downloads/#java21

2. **Maven** (for building the project)
   - Check version: `mvn -version`
   - Download from: https://maven.apache.org/download.cgi

3. **MongoDB** (Database)
   - Check if running: MongoDB should be running on `localhost:27017`
   - Download from: https://www.mongodb.com/try/download/community

## Step-by-Step Instructions

### Step 1: Start MongoDB

**Windows:**
```powershell
# If MongoDB is installed as a service, it should start automatically
# Or start manually:
mongod --dbpath "C:\data\db"
```

**Mac/Linux:**
```bash
# Start MongoDB service
sudo systemctl start mongod
# Or
mongod --dbpath /data/db
```

**Verify MongoDB is running:**
- Open MongoDB Compass or connect via terminal
- Default connection: `mongodb://localhost:27017`

### Step 2: Build the Project (Optional)

Navigate to the project directory and build:

```bash
cd c:\Users\sv106\OneDrive\Desktop\Day3SMS
mvn clean install
```

### Step 3: Run the Spring Boot Application

**Option 1: Using Maven (Recommended)**
```bash
mvn spring-boot:run
```

**Option 2: Using Maven Wrapper (Windows)**
```powershell
.\mvnw.cmd spring-boot:run
```

**Option 3: Using Maven Wrapper (Mac/Linux)**
```bash
./mvnw spring-boot:run
```

**Option 4: Run from IDE**
- Open the project in IntelliJ IDEA, Eclipse, or VS Code
- Navigate to `src/main/java/com/example/Day3SMS/Day3SmsApplication.java`
- Right-click → Run 'Day3SmsApplication'

### Step 4: Verify the Application is Running

Once the application starts, you should see:
```
Started Day3SmsApplication in X.XXX seconds
```

The application will run on: **http://localhost:8080**

**Test the API:**
- Open browser and go to: http://localhost:8080/api/students/test
- You should see: `"API is working"`

### Step 5: Open the Frontend

1. Navigate to the `frontend` folder
2. Open `index.html` in your web browser
   - You can double-click the file, or
   - Right-click → Open with → Browser

**Note:** If you get CORS errors, make sure:
- The Spring Boot application is running on port 8080
- You're opening the HTML file directly (file://) or serving it via a local server

### Step 6: Use the Application

**Via Frontend (HTML):**
- Add students using the "Add New Student" form
- View all students in the list
- Edit students using the "Update Student" form
- Delete students using the delete button

**Via API (Postman/curl):**

**Get all students:**
```bash
curl http://localhost:8080/api/students
```

**Add a student:**
```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"John Doe\",\"age\":20,\"email\":\"john@example.com\"}"
```

**Get student by ID:**
```bash
curl http://localhost:8080/api/students/{id}
```

**Update a student:**
```bash
curl -X PUT http://localhost:8080/api/students/{id} \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"Jane Doe\",\"age\":21,\"email\":\"jane@example.com\"}"
```

**Delete a student:**
```bash
curl -X DELETE http://localhost:8080/api/students/{id}
```

## Troubleshooting

### Issue: Port 8080 is already in use
**Solution:**
- Change the port in `application.properties`:
  ```properties
  server.port=8081
  ```
- Update frontend `index.html` API_BASE_URL accordingly

### Issue: MongoDB connection error
**Solution:**
- Make sure MongoDB is running
- Check MongoDB URI in `application.properties`
- Verify MongoDB is accessible at `localhost:27017`

### Issue: Java version error
**Solution:**
- Ensure Java 21 is installed
- Set JAVA_HOME environment variable
- Check: `java -version` should show version 21

### Issue: Maven build fails
**Solution:**
- Clean and rebuild: `mvn clean install`
- Check internet connection (Maven downloads dependencies)
- Verify `pom.xml` is correct

### Issue: Frontend can't connect to API
**Solution:**
- Ensure Spring Boot app is running
- Check browser console for errors
- Verify CORS configuration in `CorsConfig.java`
- Make sure API_BASE_URL in `index.html` matches your server port

## Application Configuration

**Database:** MongoDB
- **URI:** `mongodb://localhost:27017/springTest`
- **Collection:** `students`

**Server Port:** 8080 (default)

**API Base Path:** `/api/students`

## Quick Start Commands

```bash
# 1. Start MongoDB (in separate terminal)
mongod

# 2. Run Spring Boot (in project directory)
mvn spring-boot:run

# 3. Open frontend/index.html in browser
```

## Stopping the Application

- Press `Ctrl + C` in the terminal where Spring Boot is running
- Or stop from your IDE
