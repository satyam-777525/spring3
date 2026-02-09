# How to Run the Frontend

## Quick Start

### Method 1: Direct File Opening (Easiest)

1. **Make sure Spring Boot backend is running first!**
   - The backend must be running on `http://localhost:8080`
   - Start it using: `mvn spring-boot:run`

2. **Open the HTML file:**
   - Navigate to the `frontend` folder
   - Double-click `index.html`
   - Or right-click → Open with → Your preferred browser (Chrome, Firefox, Edge, etc.)

3. **That's it!** The frontend should now be accessible in your browser.

### Method 2: Using a Local Web Server (Recommended for Development)

If you encounter CORS issues or want a better development experience:

#### Option A: Using Python (if installed)

**Python 3:**
```bash
cd frontend
python -m http.server 8000
```
Then open: http://localhost:8000

**Python 2:**
```bash
cd frontend
python -m SimpleHTTPServer 8000
```

#### Option B: Using Node.js (if installed)

**Using http-server:**
```bash
# Install http-server globally (one time)
npm install -g http-server

# Run the server
cd frontend
http-server -p 8000
```
Then open: http://localhost:8000

**Using npx (no installation needed):**
```bash
cd frontend
npx http-server -p 8000
```

#### Option C: Using VS Code Live Server Extension

1. Install "Live Server" extension in VS Code
2. Right-click on `index.html`
3. Select "Open with Live Server"
4. Browser will open automatically

#### Option D: Using PHP (if installed)

```bash
cd frontend
php -S localhost:8000
```

## Prerequisites

**IMPORTANT:** Before opening the frontend:

1. ✅ **Spring Boot Backend must be running**
   - Run: `mvn spring-boot:run` from project root
   - Wait for: `Started Day3SmsApplication`
   - Backend runs on: `http://localhost:8080`

2. ✅ **MongoDB must be running**
   - MongoDB should be running on `localhost:27017`

## Step-by-Step Instructions

### Step 1: Start the Backend

Open a terminal/command prompt in the project root:

```bash
cd c:\Users\sv106\OneDrive\Desktop\Day3SMS
mvn spring-boot:run
```

Wait until you see:
```
Started Day3SmsApplication in X.XXX seconds
```

### Step 2: Verify Backend is Running

Open a browser and go to:
```
http://localhost:8080/api/students/test
```

You should see: `"API is working"`

### Step 3: Open the Frontend

**Windows:**
- Navigate to: `c:\Users\sv106\OneDrive\Desktop\Day3SMS\frontend`
- Double-click `index.html`
- It will open in your default browser

**Or use file explorer:**
- Open File Explorer
- Go to the `frontend` folder
- Right-click `index.html` → Open with → Browser

### Step 4: Use the Application

Once the frontend opens, you can:

1. **Add Students:** Fill the "Add New Student" form
2. **View Students:** See all students in the list below
3. **Edit Students:** Click "Edit" button (auto-fills update form)
4. **Delete Students:** Click "Delete" button
5. **Refresh:** Click "Refresh List" button

## Troubleshooting

### Issue: Frontend shows "Error loading students" or CORS errors

**Solution:**
- Make sure Spring Boot backend is running on port 8080
- Check browser console (F12) for errors
- Verify `CorsConfig.java` exists and is properly configured
- Try using a local web server (Method 2) instead of opening file directly

### Issue: "Failed to fetch" or Network errors

**Solutions:**
1. **Check backend is running:**
   ```bash
   curl http://localhost:8080/api/students/test
   ```

2. **Check API URL in frontend:**
   - Open `index.html` in a text editor
   - Look for: `const API_BASE_URL = 'http://localhost:8080/api/students';`
   - Make sure it matches your backend URL

3. **Check firewall/antivirus:** May be blocking localhost connections

### Issue: Frontend opens but shows blank page

**Solution:**
- Open browser Developer Tools (F12)
- Check Console tab for JavaScript errors
- Make sure `index.html` is not corrupted

### Issue: Changes to frontend not showing

**Solution:**
- Hard refresh browser: `Ctrl + F5` (Windows) or `Cmd + Shift + R` (Mac)
- Clear browser cache
- Close and reopen the HTML file

## Frontend Configuration

The frontend connects to the backend API at:
```
http://localhost:8080/api/students
```

If your backend runs on a different port, edit `index.html` and change:
```javascript
const API_BASE_URL = 'http://localhost:8080/api/students';
```
to match your backend port.

## Quick Test

1. Start backend: `mvn spring-boot:run`
2. Open frontend: Double-click `frontend/index.html`
3. Add a test student:
   - Name: "John Doe"
   - Age: 20
   - Email: "john@example.com"
4. Click "Add Student"
5. You should see the student appear in the list below!

## Browser Compatibility

The frontend works with:
- ✅ Google Chrome
- ✅ Mozilla Firefox
- ✅ Microsoft Edge
- ✅ Safari
- ✅ Opera

## File Structure

```
frontend/
├── index.html          ← Main frontend file (open this!)
└── README.md          ← Frontend documentation
```

## Need Help?

- Check browser console (F12) for errors
- Verify backend is running: http://localhost:8080/api/students/test
- Check MongoDB is running
- Review `HOW_TO_RUN.md` for backend setup
