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
sakhi-store-backend/
│
├── 📄 pom.xml                               # Maven configuration (dependencies, plugins)
├── 📄 README.md                             # Overview, setup guide, API usage
│
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 java/
│   │   │   └── 📁 com/
│   │   │       └── 📁 sakhi/
│   │   │           └── 📁 store/
│   │   │               ├── 📄 SakhiStoreApplication.java     # Spring Boot main entry point
│   │   │               │
│   │   │               ├── 📁 config/                        # Configuration classes
│   │   │               │   ├── AppConfig.java                # App-level beans (e.g., ModelMapper)
│   │   │               │   ├── SecurityConfig.java           # Spring Security + JWT setup
│   │   │               │   ├── SwaggerConfig.java            # Swagger API documentation setup
│   │   │               │   ├── CorsConfig.java               # Global CORS configuration
│   │   │               │   └── AppConstants.java             # Constant variables used project-wide
│   │   │               │
│   │   │               ├── 📁 controller/                    # REST endpoints (HTTP layer)
│   │   │               │   ├── UserController.java           # Authentication + profile endpoints
│   │   │               │   ├── ProductController.java        # Product management
│   │   │               │   ├── OrderController.java          # Order management
│   │   │               │   ├── InventoryController.java      # Inventory reporting
│   │   │               │   └── DashboardController.java      # Analytics + dashboard endpoints
│   │   │               │
│   │   │               ├── 📁 dto/                           # DTOs (data transfer objects)
│   │   │               │   ├── request/
│   │   │               │   │   ├── RegisterRequest.java
│   │   │               │   │   ├── LoginRequest.java
│   │   │               │   │   ├── ProductRequest.java
│   │   │               │   │   ├── OrderRequest.java
│   │   │               │   │   └── InventoryRequest.java
│   │   │               │   └── response/
│   │   │               │       ├── AuthResponse.java
│   │   │               │       ├── ProductResponse.java
│   │   │               │       ├── OrderResponse.java
│   │   │               │       ├── InventoryResponse.java
│   │   │               │       └── UserResponse.java
│   │   │               │
│   │   │               ├── 📁 model/                         # Entity classes (database tables)
│   │   │               │   ├── User.java
│   │   │               │   ├── Product.java
│   │   │               │   ├── Order.java
│   │   │               │   ├── Inventory.java
│   │   │               │   └── Role.java (optional, if role-based auth used)
│   │   │               │
│   │   │               ├── 📁 repository/                    # Data access layer (JPA Repositories)
│   │   │               │   ├── UserRepository.java
│   │   │               │   ├── ProductRepository.java
│   │   │               │   ├── OrderRepository.java
│   │   │               │   └── InventoryRepository.java
│   │   │               │
│   │   │               ├── 📁 service/                       # Business logic layer
│   │   │               │   ├── interfaces/
│   │   │               │   │   ├── UserService.java
│   │   │               │   │   ├── ProductService.java
│   │   │               │   │   ├── OrderService.java
│   │   │               │   │   └── InventoryService.java
│   │   │               │   └── impl/
│   │   │               │       ├── UserServiceImpl.java
│   │   │               │       ├── ProductServiceImpl.java
│   │   │               │       ├── OrderServiceImpl.java
│   │   │               │       └── InventoryServiceImpl.java
│   │   │               │
│   │   │               ├── 📁 security/                      # JWT authentication & authorization
│   │   │               │   ├── JwtUtil.java                  # Generate, validate tokens
│   │   │               │   ├── JwtFilter.java                # Intercepts and validates tokens
│   │   │               │   ├── CustomUserDetails.java        # Custom UserDetails for auth
│   │   │               │   ├── CustomUserDetailsService.java # Load users for Spring Security
│   │   │               │   └── AuthEntryPoint.java           # Handles unauthorized requests
│   │   │               │
│   │   │               ├── 📁 exception/                     # Centralized error handling
│   │   │               │   ├── GlobalExceptionHandler.java   # Handles exceptions globally
│   │   │               │   ├── ResourceNotFoundException.java
│   │   │               │   ├── BadRequestException.java
│   │   │               │   ├── UnauthorizedException.java
│   │   │               │   └── DuplicateEntryException.java
│   │   │               │
│   │   │               ├── 📁 payload/                       # Common API response models
│   │   │               │   ├── ApiResponse.java
│   │   │               │   ├── ApiError.java
│   │   │               │   └── PageResponse.java             # For paginated responses
│   │   │               │
│   │   │               ├── 📁 util/                          # Utility/helper classes
│   │   │               │   ├── DateUtils.java
│   │   │               │   ├── ResponseBuilder.java
│   │   │               │   ├── FileUploadUtil.java           # If you add image uploads
│   │   │               │   └── EmailService.java             # (optional)
│   │   │               │
│   │   │               └── 📁 mapper/                        # Mapper classes (DTO ↔ Entity)
│   │   │                   ├── UserMapper.java
│   │   │                   ├── ProductMapper.java
│   │   │                   └── OrderMapper.java
│   │   │
│   │   └── 📁 resources/
│   │       ├── 📄 application.properties                     # Global Spring configuration
│   │       ├── 📄 application-dev.properties                 # Dev environment settings
│   │       ├── 📄 application-prod.properties                # Production settings
│   │       ├── 📄 schema.sql                                 # Database schema initialization
│   │       ├── 📄 data.sql                                   # Sample seed data
│   │       ├── 📁 static/                                    # Static resources (if any)
│   │       └── 📁 templates/                                 # Email templates (if needed)
│   │
│   └── 📁 test/
│       └── 📁 java/
│           └── 📁 com/
│               └── 📁 sakhi/
│                   └── 📁 store/
│                       ├── UserServiceTest.java
│                       ├── ProductServiceTest.java
│                       ├── OrderControllerTest.java
│                       └── IntegrationTest.java
│
└── 📁 logs/                                                  # Log files (gitignored)
    └── app.log
