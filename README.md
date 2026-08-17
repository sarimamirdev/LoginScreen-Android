# LoginScreen-Android

A modern Android login screen built with **Java and XML**, featuring a clean dark-themed interface, multiple login modes, input validation, password visibility control, and a Remember Me option.

## 📱 Overview

**LoginScreen-Android** is a frontend-focused Android authentication UI project designed to demonstrate the implementation of a modern and user-friendly login experience.

The application includes phone and email/username login modes, client-side validation, password visibility control, remembered username functionality, and navigation to a home screen after a successful validation.

> **Note:** This project currently demonstrates the login UI and local validation flow. It does not include a real backend authentication system or database.

## ✨ Features

* 🌙 Modern dark-themed login interface
* 📱 Phone number login mode
* 📧 Email / username login mode
* 🔐 Password visibility toggle
* ✅ Input validation
* 🔑 Minimum password length validation
* 💾 Remember Me functionality
* 📦 Local data storage using `SharedPreferences`
* 🏠 Navigation to a Home screen after successful validation
* 🎨 Custom XML drawable backgrounds and UI components
* 📱 Android 8.0 (API 26) and above support

## 🛠️ Technologies Used

* **Java**
* **XML**
* **Android SDK**
* **AndroidX AppCompat**
* **Material Components**
* **ConstraintLayout**
* **SharedPreferences**

## ⚙️ Project Configuration

| Configuration      | Version |
| ------------------ | ------- |
| Compile SDK        | 34      |
| Target SDK         | 33      |
| Minimum SDK        | 26      |
| Java Compatibility | Java 8  |
| App Version        | 1.0     |

## 🔐 Login Validation

The application performs client-side validation before allowing the user to continue.

### Email / Username Mode

* Checks whether the field is empty
* Validates email format when an email address is entered
* Displays an error message for invalid input

### Phone Mode

* Checks whether the phone field is empty
* Validates the minimum phone number length

### Password

* Checks whether the password is empty
* Requires a minimum of 6 characters
* Allows users to show or hide the password

## 💾 Remember Me

The **Remember Me** option uses Android `SharedPreferences` to locally store the username entered by the user.

When the application is opened again, the previously remembered username can be automatically restored.

> Passwords are not stored by the Remember Me functionality.

## 🏗️ Project Structure

```text
LoginScreen-Android/
│
├── LoginApp/
│   ├── app/
│   │   ├── src/
│   │   │   └── main/
│   │   │       ├── java/
│   │   │       │   └── com/example/loginapp/
│   │   │       │       ├── MainActivity.java
│   │   │       │       └── HomeActivity.java
│   │   │       │
│   │   │       ├── res/
│   │   │       │   ├── drawable/
│   │   │       │   ├── layout/
│   │   │       │   │   ├── activity_main.xml
│   │   │       │   │   └── activity_home.xml
│   │   │       │   └── values/
│   │   │       │
│   │   │       └── AndroidManifest.xml
│   │   │
│   │   ├── build.gradle
│   │   └── proguard-rules.pro
│   │
│   ├── build.gradle
│   └── gradle.properties
│
├── .gitignore
├── LICENSE
└── README.md
```

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/sarimamirdev/LoginScreen-Android.git
```

### 2. Open the project

Open the `LoginApp` folder in **Android Studio**.

### 3. Sync Gradle

Allow Android Studio to download the required dependencies and complete the Gradle sync.

### 4. Run the application

Connect an Android device with USB debugging enabled or start an Android Emulator.

Then click **Run ▶** in Android Studio.

## 🧪 Testing the Login Screen

You can test the validation flow using:

**Email / Username Mode**

* Enter a valid email address or username
* Enter a password with at least 6 characters
* Tap **Login**

**Phone Mode**

* Switch to phone login
* Enter a phone number
* Enter a password with at least 6 characters
* Tap **Login**

After successful validation, the application navigates to the Home screen.

## 🔮 Future Improvements

The project can be extended with:

* 🔗 Firebase Authentication
* 🌐 REST API / backend authentication
* 🗄️ Database integration
* 🔒 Secure token-based authentication
* 📧 Real password reset functionality
* 👤 Complete user registration system
* 🔐 Secure session management
* 🎨 Additional UI animations and accessibility improvements

## 📌 Project Status

**Status:** Completed UI & local validation demo

This project was created as an Android development practice project to demonstrate login interface design, form validation, local preference storage, and activity navigation.

## 📄 License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Muhammad Sarim Amir**

GitHub: [@sarimamirdev](https://github.com/sarimamirdev)

---

⭐ If you find this project useful, consider giving it a star.
