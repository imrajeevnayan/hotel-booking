# 🏨 LuxStay - Full Stack Hotel Booking System

Welcome to **LuxStay**, a premium, full-stack hotel booking platform designed to deliver a seamless booking experience. It combines a high-performance **Java Spring Boot** backend with a visually stunning **React** frontend, all containerized with **Docker** for easy deployment.

![LuxStay Banner](https://images.unsplash.com/photo-1566073771259-6a8506099945?q=80&w=1200&auto=format&fit=crop&ixlib=rb-4.0.3)

---

## 🌟 Quick Links

- **[Frontend Documentation](./frontend/README.md)** - React, Vite, Tailwind Setup & Details.
- **[Backend Documentation](./backend/README.md)** - Spring Boot, API, Database & Security Details.

---

## 🚀 Key Features

- **Full-Stack Architecture:** Decoupled Frontend and Backend communicating via REST APIs.
- **Authentication:** Secure login via Email/Password (JWT) and **GitHub OAuth**.
- **Containerization:** Complete Docker Compose setup for one-command startup.
- **Database:** PostgreSQL for robust data management.
- **Modern UI:** Responsive, animated, and accessible interface.
- **Payments:** Integrated Razorpay payment gateway.

---

## 🛠 Tech Stack Overview

| Area | Technology |
|------|------------|
| **Frontend** | React 18, Vite, Tailwind CSS, Axios, Lucide Icons |
| **Backend** | Java 25, Spring Boot 3.4, Hibernate, Spring Security |
| **Database** | PostgreSQL 15 |
| **DevOps** | Docker, Docker Compose |

---

## 🏁 Getting Started (The Fast Way)

The easiest way to run the entire application is using **Docker Compose**.

### 1. Prerequisites
- [Docker & Docker Compose](https://www.docker.com/products/docker-desktop/) installed.
- Git installed.

### 2. Clone the Repository
```bash
git clone https://github.com/imrajeevnayan/hotel-booking.git
cd hotel-booking
```

### 3. Environment Setup
Create a `.env` file in the root directory. You can copy the example:

```bash
cp .env.example .env
```

**Important:** You **MUST** update the `.env` file with your real credentials (GitHub OAuth Client ID/Secret, Razorpay Keys) for those features to work.

### 4. Run the Application
```bash
docker-compose up --build
```
*This command will build both the frontend and backend images, start the PostgreSQL database, and wire everything together.*

### 5. Access the App
- **Frontend (User Interface):** [http://localhost:3000](http://localhost:3000)
- **Backend (API):** [http://localhost:8080](http://localhost:8080)

---

## 🔧 Manual Setup (Without Docker)

If you prefer to run services individually, please refer to the specific READMEs:

1.  **[Backend Setup Guide](./backend/README.md)**
2.  **[Frontend Setup Guide](./frontend/README.md)**

---

## 🤝 Contributing

Contributions are welcome! Please fork the repository and create a pull request.

1.  Fork the Project
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin feature/AmazingFeature`)
5.  Open a Pull Request

---

## 📜 License

Distributed under the MIT License. See `LICENSE` for more information.

---

**Happy Coding!** 🚀
