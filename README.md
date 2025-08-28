# HackMate - Mobile Login App

A beautiful dark-themed mobile application with Firebase Google Sign-In authentication.

## 🎨 Features

- **Dark Theme UI** with green accents matching your reference design
- **Firebase Google Sign-In** integration
- **Material Design 3** components
- **Professional card-based layout** with illustrations
- **Responsive design** for all screen sizes

## 🚀 Setup Instructions

### 1. Firebase Project Setup

1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Create a new project or select existing one
3. Add an Android app with package name: `com.hackmate`

### 2. Enable Google Sign-In

1. In Firebase Console, go to **Authentication** → **Sign-in method**
2. Enable **Google** provider
3. Add your support email

### 3. Get SHA-1 Fingerprint

Run this command in your project directory:
```bash
./gradlew signingReport
```

Or for debug keystore:
```bash
keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android
```

### 4. Add SHA-1 to Firebase

1. In Firebase Console → **Project Settings**
2. Scroll to **SHA certificate fingerprints**
3. Click **Add fingerprint** and paste your SHA-1

### 5. Download Configuration File

1. Download `google-services.json` from Firebase Console
2. Replace the placeholder file in `app/google-services.json`

### 6. Update Web Client ID

1. Open your downloaded `google-services.json`
2. Find the `client_id` with `client_type: 3` (Web client)
3. Copy this ID to `app/src/main/res/values/strings.xml`:
   ```xml
   <string name="default_web_client_id">YOUR_ACTUAL_WEB_CLIENT_ID</string>
   ```

## 🎨 UI Design

The app features:

- **Dark background** (`#121212`)
- **Bright green primary color** (`#00FF88`) 
- **Card-based layout** with rounded corners
- **3D illustration area** with carousel dots
- **Pill-shaped input fields** 
- **Google Sign-In button** with authentic branding

## 🔧 Building the App

```bash
# Clean build
./gradlew clean

# Build debug APK
./gradlew assembleDebug

# Install on device
./gradlew installDebug
```

## 📱 Testing

1. Build and install the app
2. Tap "Continue With Google" button
3. Select Google account
4. Should navigate to MainActivity with user info

## 🛠️ Project Structure

```
app/
├── src/main/
│   ├── java/com/hackmate/
│   │   ├── LoginActivity.java      # Main login screen
│   │   └── MainActivity.java       # Post-login screen
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_login.xml  # Dark theme login UI
│   │   │   └── activity_main.xml   # Main screen layout
│   │   ├── values/
│   │   │   ├── colors.xml          # Dark theme color palette
│   │   │   ├── strings.xml         # All text resources
│   │   │   └── themes.xml          # Material Design theme
│   │   └── drawable/               # Icons and backgrounds
│   └── AndroidManifest.xml
└── google-services.json            # Firebase configuration
```

## 🔐 Security Notes

- The app uses Firebase Authentication for secure login
- Google Sign-In follows OAuth 2.0 standards
- User data is handled securely through Firebase
- Replace placeholder `google-services.json` with your actual file

## 🎯 Next Steps

After successful login, you can extend the app with:
- User profile management
- Hackathon event listings
- Team formation features
- Project collaboration tools

Your HackMate app is ready to build and test! 🚀
