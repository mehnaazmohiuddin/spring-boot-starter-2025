# 🔐 Spring Boot Starter 2025

A template Spring Boot project demonstrating role-based authentication with JWT and Spring Security, using AOP and `UserDetailsService`.

---

## ⚙️ Features

- Custom login endpoint (`/user/login`)
- JWT generation with roles
- `UserDetailsService` integration
- AOP-based role-checking using custom `@RequiresRole` annotation
- Clean configuration via constructor injection

---

## 🚀 Getting Started

### Prerequisites

- Java 21+
- Maven or Gradle
- IDE (e.g. IntelliJ IDEA)

### Clone the Project

```bash
git clone https://github.com/mehnaazmohiuddin/spring-boot-starter-2025.git
cd spring-boot-starter-2025
```

---

## ⚙️ Setup

### Configure Secret via Environment Variable

```bash
export SIGNING_PASSWORD=yourSuperSecretKey
```

Verify Spring picks it up by checking logs.

### Build & Run

```bash
# Maven
mvn clean install
mvn spring-boot:run

# OR Gradle
./gradlew clean build
./gradlew bootRun
```

---

## 🧩 Structure Overview

```
src/
 ├── controller/
 │    └── AuthController.java  // handles /user/login
 ├── service/
 │    └── CustomUserDetailsService.java
 ├── security/
 │    ├── JwtUtil.java         // constructor-based injection from env
 │    ├── SecurityConfig.java  // defines SecurityFilterChain
 │    └── annotation/
 │         └── RequiresRole.java
 │    └── aspect/
 │         └── RoleAspect.java
 └── Application.java
```

---

## 🔐 Authentication Flow

1. **User submits POST `/user/login`** with username/password.
2. `AuthController` validates and loads using `CustomUserDetailsService`.
3. If valid, generates JWT with roles claim using `JwtUtil`.
4. Authentication is set manually via `SecurityContextHolder`.
5. Subsequent requests with valid JWT are authorized.

---

## 🧠 Role-Based Access Control (AOP)

```java
@RequiresRole("ROLE_ADMIN")
public void deleteUser() {  }
```

The `RoleAspect` captures this annotation and throws `AccessDeniedException` if roles mismatch.

---

## 📦 Key Patterns Used

| Pattern             | Description                                              |
|---------------------|----------------------------------------------------------|
| Constructor Injection + `@Value` | Clean and reliable config value injection |
| `UserDetailsService` + `DaoAuthenticationProvider`  | Standard Spring Security auth flow       |
| Manual `SecurityContextHolder` setup     | For custom authentication endpoints     |
| Custom `@RequiresRole` + AOP advice      | Declarative method-level role checks    |

---

## 🎓 Build Tools & Spring Versions

This project is based on **Spring Boot 3.x+** and works with **Java 21+**, following Spring Boot guidelines.

---

## ✔️ Next Steps

- Implement `/user/register` endpoint
- Add refresh token logic
- Use `@ConfigurationProperties` for cleaner config
- Extend roles logic (`@RequiresAnyRole`, multiple roles)
- Add global exception handler for JWT errors



Adding Dockerization . 
added DockerFile 
added docker-compose.yaml 

adding it to dockerhub so that k8s can see it. his
```bash
docker build -t myapp:latest 
docker tag myapp:latest mehnaaz/myapp:latest
docker push myapp:latest mehnaaz/myapp:latest
docker push  mehnaaz/myapp:latest
```