# 🌸 Sakhi Store — Empowering Women Entrepreneurs

**Sakhi Store** is a modern e-commerce platform built to empower **ladies’ businesses** by providing an online marketplace..  
This project serves as a **backend system** for the Sakhi Store ecosystem — designed with **Spring Boot**, **PostgreSQL**, and a clean, modular architecture.

---

## 🛍️ Project Overview

Sakhi Store is a **business platform** for women to easily manage and grow their online stores.  
The system includes product management, order tracking, payment handling, and secure authentication — built for scalability and reliability.

---

## ⚙️ Tech Stack

| Layer | Technology Used |
|-------|------------------|
| **Backend Framework** | Spring Boot (v3.x) |
| **Language** | Java 17+ |
| **Database** | PostgreSQL |
| **ORM** | Hibernate / JPA |
| **Build Tool** | Maven |
| **Security** | Spring Security with JWT |
| **API Docs** | Swagger / OpenAPI |
| **Hosting** | AWS EC2 / DigitalOcean Droplet |
| **Version Control** | Git + GitHub |

---

## 📁 Folder Structure

```bash
Sakhi-Store/
│
├── backend/
│   ├── pom.xml                     # Maven project file
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/sakhi/store/
│   │   │   │   ├── controller/     # REST API controllers
│   │   │   │   ├── model/          # Entity models
│   │   │   │   ├── repository/     # JPA repositories
│   │   │   │   ├── service/
│   │   │   │   │   ├── impl/       # Service implementations
│   │   │   │   │   └── interfaces/ # Service interfaces
│   │   │   │   └── config/         # Security, CORS, Swagger configs
│   │   │   └── resources/
│   │   │       ├── application.properties  # Database and app configs
│   │   │       └── static/ & templates/    # (Optional) For web assets
│   │   └── test/                           # Unit and integration tests
│   └── README.md
│
├── frontend/ (optional)
│   └── (React / Next.js / Angular UI code)
│
└── docs/
    └── Sakhi_Store_API_Reference.md
