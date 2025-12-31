# 🏨 LuxStay - Hotel Booking System

**Welcome to LuxStay!** 🌟

This is a complete implementation of a modern Hotel Booking Application. Whether you are a developer looking for code reference or a user wanting to see a beautiful booking site, you are in the right place.

We built this key question in mind: **"How can we make booking a hotel room as smooth and beautiful as possible?"**

![Project Banner](https://images.unsplash.com/photo-1542314831-068cd1dbfeeb?q=80&w=1200&auto=format&fit=crop&ixlib=rb-4.0.3)
*(Detailed screenshots available below)*

---

## 📚 Table of Contents
1. [🌟 What Can You Do Here?](#-what-can-you-do-here)
2. [🚀 The Easiest Way to Run This (For Beginners)](#-the-easiest-way-to-run-this-for-beginners)
3. [💻 For Developers (Manual Setup)](#-for-developers-manual-setup)
4. [📖 Step-by-Step User Guide](#-step-by-step-user-guide)
5. [❓ Troubleshooting Profile](#-troubleshooting)

---

## 🌟 What Can You Do Here?

**For Users:**
*   **Browse Hotels:** Explore a curated list of luxury hotels with beautiful images and prices.
*   **Search & Filter:** Find exactly what you want by filtering by city or price.
*   **Sign Up/Login:** Create your secure account or just click **"Login with GitHub"** for instant access.
*   **Book a Room:** distinct dates, check availability, and "pay" (simulation) for your stay.
*   **Manage Bookings:** View all your past and upcoming trips in your dashboard.

**For Developers:**
*   See how **Java Spring Boot** (Backend) talks to **React** (Frontend).
*   Learn how **Docker** containers work together.
*   Understand **OAuth2** (Social Login) and **JWT** (Security).

---

## 🚀 The Easiest Way to Run This (For Beginners)

If you don't want to install Java, Maven, Node.js, and everything else manually, use **Docker**. It bundles everything into a "box" that just runs.

### Prerequisite
*   **Docker Desktop**: Download and install it from [docker.com](https://www.docker.com/products/docker-desktop/).
    *   *Tip: After installing, open the "Docker Desktop" app and make sure it is running.*

### Steps
1.  **Download the Code**
    *   Click the green **"Code"** button above and select "Download ZIP", then unzip it.
    *   OR run in terminal: `git clone https://github.com/imrajeevnayan/hotel-booking.git`

2.  **Open Terminal**
    *   Go to the folder where you downloaded the project.

3.  **Setup Configuration (Important!)**
    *   Creates a file named `.env`.
    *   Open `.env.example`, copy everything, and paste it into your new `.env` file.
    *   **Crucial:** You need to fill in `GITHUB_CLIENT_ID` and `RAZORPAY_KEY` for those specific features to work. (You can leave them blank if you just want to browse hotels, but login might fail).

4.  **Run One Command**
    ```bash
    docker-compose up --build
    ```
    *   *This will take a few minutes the first time as it downloads all the necessary tools.*

5.  **Visit the App!**
    *   **Frontend (The Website):** Open [http://localhost:3000](http://localhost:3000)
    *   **Backend (The Server):** Open [http://localhost:8080](http://localhost:8080)

---

## 💻 For Developers (Manual Setup)

If you want to modify the code, you should run the services individually.

### 1. Backend (The Brain)
*   **Location:** `./backend` folder.
*   **Tech:** Java 25, Spring Boot.
*   **Run:**
    ```bash
    cd backend
    mvn spring-boot:run
    ```
*   [Read detailed Backend Guide](./backend/README.md)

### 2. Frontend (The Face)
*   **Location:** `./frontend` folder.
*   **Tech:** React, Vite.
*   **Run:**
    ```bash
    cd frontend
    npm install
    npm run dev
    ```
*   [Read detailed Frontend Guide](./frontend/README.md)

---

## 📖 Step-by-Step User Guide

So the app is running. Now what?

### 1. Register or Login
*   Click the **"Login"** button in the top right.
*   **Option A:** Enter an email and password to create a new account.
*   **Option B (Easier):** Click "Continue with GitHub".

### 2. Find a Hotel
*   On the Home page, scroll down to see "Featured Hotels".
*   Click on any hotel card to specific details (Amenities, Map, Rooms).

### 3. Make a Booking
*   On the Hotel Details page, you will see a **"Book Now"** section.
*   Select your **Check-in** and **Check-out** dates.
*   Select the number of guests.
*   Click **"Reserve"**. 
*   *Note: If you are not logged in, it will ask you to login first.*

### 4. Payment (Test Mode)
*   You will see a Razorpay payment popup.
*   Since this is a test mode, you can use any dummy card details provided by Razorpay documentation, or just close the popup (depending on config) to simulate a transaction.

### 5. Check Your Dashboard
*   Click your profile icon in the top right -> **"My Bookings"**.
*   You will see your reservation there!

---

## ❓ Troubleshooting

**"Port 8080 is already in use"**
*   This means another program is using the port our backend needs.
*   *Fix:* Close the other program or restart your computer.

**"Connection Refused"**
*   The frontend cannot talk to the backend.
*   *Fix:* Make sure the backend terminal says "Started HotelBookingApplication".

**"Login Failed"**
*   Did you set up the `.env` file?
*   Check if your Database password in `.env` matches your local PostgreSQL password.

---

**Built with ❤️ by Rajeev Nayan**
