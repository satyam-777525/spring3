@echo off
echo ========================================
echo Student Management System - Quick Start
echo ========================================
echo.

echo Checking Java version...
java -version
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java 21 and try again
    pause
    exit /b 1
)

echo.
echo Checking Maven version...
mvn -version
if %errorlevel% neq 0 (
    echo ERROR: Maven is not installed or not in PATH
    echo Please install Maven and try again
    pause
    exit /b 1
)

echo.
echo ========================================
echo IMPORTANT: Make sure MongoDB is running!
echo MongoDB should be running on localhost:27017
echo ========================================
echo.
pause

echo.
echo Building and starting Spring Boot application...
echo This may take a few minutes on first run...
echo.

mvn spring-boot:run

pause
