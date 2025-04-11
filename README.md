# CODECRAFT_BW_03
# User Management System with JWT Authentication

## Overview
This project is a **Spring Boot-based User Management System** that implements authentication and authorization using **JSON Web Tokens (JWT)**. It provides secure access control for users with different roles (`USER`, `ADMIN`, `OWNER`).

## Features
- **Spring Security with JWT** for authentication
- **Role-based access control (RBAC)**
- **Secure APIs** for user operations
- **Spring Data JPA** for database management

## Tech Stack
- **Spring Boot 3.x**
- **Spring Security 6.x**
- **Spring Data JPA**
- **MySQL 8.x**
- **JWT Authentication**
- **Postman for API testing**

## Endpoints

### **Auth Endpoints**
| Method | Endpoint               | Description               | Public |
|--------|------------------------|---------------------------|--------|
| POST   | `/api/auth/signup`      | Register a new user       | ✅ Yes |
| POST   | `/api/auth/login`       | Authenticate user & get JWT | ✅ Yes |

### **User Endpoints**
| Method | Endpoint          | Description           | Requires JWT |
|--------|------------------|----------------------|--------------|
| GET    | `/api/users`      | Get all users        | ✅ Yes       |
| GET    | `/api/users/{id}` | Get user by ID       | ✅ Yes       |
| PUT    | `/api/users/{id}` | Update user by ID    | ✅ Yes       |
| DELETE | `/api/users/{id}` | Delete user by ID    | ✅ Yes       |

### **Admin Endpoints**
| Method | Endpoint          | Description           | Requires JWT + Role (`ADMIN`) |
|--------|------------------|----------------------|------------------------------|
| GET    | `/api/admin/dashboard` | Admin panel access | ✅ Yes                         |

## Installation & Setup

### **1️⃣ Clone the Repository**
```bash
git clone https://github.com/your-repo-url.git
cd your-project
