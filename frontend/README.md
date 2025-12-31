# LuxStay - Frontend

## 🌐 Overview
The frontend of the **LuxStay Hotel Booking System** is a modern, high-performance web application built with **React** and **Vite**. It provides a seamless, premium user experience for users to browse hotels, manage bookings, and securely authenticate.

Designed with **Mobile-First** principles and enhanced with beautiful animations, this frontend communicates with the Spring Boot backend to deliver real-time data and secure transactions.

---

## 🛠 Tech Stack

- **Framework:** [React v18](https://react.dev/)
- **Build Tool:** [Vite](https://vitejs.dev/)
- **Styling:** [Tailwind CSS](https://tailwindcss.com/) (or Custom CSS Modules) & [Lucide React](https://lucide.dev/) (Icons)
- **State Management:** [React Context API](https://react.dev/learn/passing-data-deeply-with-context) / Local State
- **Routing:** [React Router v6](https://reactrouter.com/en/main)
- **HTTP Client:** [Axios](https://axios-http.com/)
- **Animations:** [Framer Motion](https://www.framer.com/motion/) (if applicable) or CSS Transitions
- **Notifications:** [React Hot Toast](https://react-hot-toast.com/)

---

## 🚀 Features

- **🏠 Home Page:** Visually stunning landing page with featured hotels and search functionality.
- **🏨 Hotel Listings:** Browse varying hotels with price, location, and amenity details.
- **🔐 Authentication:** User Login & Registration pages (JWT-based).
- **🛒 Booking Flow:** Calendar selection, guest details, and booking confirmation.
- **📄 User Dashboard:** View past and upcoming bookings.
- **📱 Responsive:** Fully optimized for Mobile, Tablet, and Desktop.

---

## 📦 Prerequisites

Ensure you have the following installed on your machine:

- **Node.js** (v18 or higher) -> [Download Here](https://nodejs.org/)
- **npm** (v9 or higher) or **yarn**

---

## 🔧 Installation & Setup

1.  **Navigate to the frontend directory:**
    ```bash
    cd frontend
    ```

2.  **Install Dependencies:**
    ```bash
    npm install
    ```

3.  **Configure Environment Variables:**
    Create a `.env` file in the `frontend` root if needed.
    ```env
    VITE_API_BASE_URL=http://localhost:8080/api
    ```

---

## 🏃‍♂️ Running Locally

Start the development server:

```bash
npm run dev
```

The app will be available at **`http://localhost:5173`** (or the port shown in your terminal).

---

## 🏗 Building for Production

To create a production-ready build:

```bash
npm run build
```

The output will be in the `dist/` folder, ready for deployment to Vercel, Netlify, or Nginx.

---

## 🐳 Docker Support

To run the frontend container isolated:

```bash
docker build -t luxstay-frontend .
docker run -p 3000:80 luxstay-frontend
```

*Note: It is recommended to run the full stack using `docker-compose` from the project root.*

---

## 📂 Project Structure

```
frontend/
├── public/              # Static assets (images, icons)
├── src/
│   ├── assets/          # Images and global styles
│   ├── components/      # Reusable UI components (Navbar, Footer, Card)
│   ├── contexts/        # React Contexts (Auth, Theme)
│   ├── hooks/           # Custom React Hooks
│   ├── pages/           # Application Pages (Home, Login, Dashboard)
│   ├── services/        # API service calls
│   ├── App.jsx          # Main App Component
│   └── main.jsx         # Entry Point
├── package.json         # Dependencies and Scripts
└── vite.config.js       # Vite Configuration
```
