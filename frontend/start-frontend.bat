@echo off
echo ========================================
echo Starting Frontend - Student Management System
echo ========================================
echo.

echo IMPORTANT: Make sure Spring Boot backend is running!
echo Backend should be running on http://localhost:8080
echo.
echo Press any key to continue after starting the backend...
pause

echo.
echo Opening frontend in default browser...
echo.

start "" "%~dp0index.html"

echo.
echo Frontend opened! If you see errors, make sure:
echo 1. Backend is running on http://localhost:8080
echo 2. MongoDB is running on localhost:27017
echo.
pause
