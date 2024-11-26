# Monitor Server

## Overview

This project is a **Spring Boot** application that provides RESTful APIs and a web-based interface for managing monitor data. The backend interacts with a **file-based H2 database** using **JDBC** and uses **Lombok** to simplify Java development. The web interface is built with **HTML, CSS, and JavaScript** and interacts with the backend REST API.

---

## Features

- **RESTful API**: Full CRUD operations for managing monitors.
- **Web Pages**: Interactive interface with web technologies.
- **H2 Database**: Lightweight file-based storage.
- **JDBC**: Direct SQL-based database operations.
- **Lombok**: Reduces boilerplate Java code.

---

## Project Structure

```
src/main/
├── java/com/example/monitor_service/
│   ├── controller/         // REST controllers
│   │   └── MonitorController.java
│   ├── dao/                // Data Access Object for database operations
│   │   └── MonitorDao.java
│   ├── model/              // Data models
│   │   └── Monitor.java
└── resources/
    ├── static/
    │   ├── css/            // Stylesheets
    │   │   └── monitor.css
    │   ├── js/             // JavaScript files
    │   │   └── monitor.js
    │   ├── html/           // Web pages
    │   │   ├── Monitor.html
    │   │   ├── MonitorIncluir.html
    │   │   ├── MonitorAlterar.html
    │   │   ├── MonitorListar.html
    │   │   ├── MonitorVisualizar.html
    │   │   └── Monitores.html
    │   ├── templates/           
    └── application.properties // Configuration file
```

---

## REST API Endpoints

| Method   | Endpoint           | Description                   |
|----------|--------------------|-------------------------------|
| `GET`    | `/api/monitor`     | Retrieve all monitors         |
| `GET`    | `/api/monitor/{id}`| Retrieve a monitor by ID      |
| `POST`   | `/api/monitor`     | Add a new monitor             |
| `PUT`    | `/api/monitor`     | Update an existing monitor    |
| `DELETE` | `/api/monitor/{id}`| Delete a monitor by ID        |

---

## Web Pages

The web interface provides an intuitive way to interact with monitor data. Each page is built using HTML, styled with CSS, and powered by JavaScript.

### Web Files

| File                          | Description                                                       |
|-------------------------------|-------------------------------------------------------------------|
| `html/Monitor.html`           | Displays a list of all monitors.                                  |
| `html/MonitorIncluir.html`    | Form to add a new monitor.                                        |
| `html/MonitorAlterar.html`    | Form to update an existing monitor.                               |
| `html/MonitorVisualizar.html` | Displays detailed information about a monitor.                    |
| `html/Monitores.html`         | Form to add a new monitor and displays a list of all monitors.    |
| `css/monitor.css`             | Styles for the web interface.                                     |
| `js/monitor.js`               | JavaScript file for handling dynamic content.                     |

---

## Configuration

### 1. **H2 Database Configuration**
The application uses a file-based H2 database configured in `application.properties`:
```properties
spring.application.name=monitor-service

# Server Port
server.port=8080

# H2 Database Configuration
spring.datasource.url=jdbc:h2:file:./monitor-service
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
```

Access the H2 console at: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
- **JDBC URL**: `jdbc:h2:file:./monitor-service`
- **Username**: `sa`
- **Password**: `password`

### 2. **Database Schema**
The database table `MONITOR` is created with the following schema:
```sql
CREATE TABLE MONITOR (
    id      INT AUTO_INCREMENT PRIMARY KEY,
    nome    VARCHAR(100) NOT NULL,
    tipo    VARCHAR(100) NOT NULL,
    tamanho DOUBLE NOT NULL,
    preco   DOUBLE NOT NULL
);
```

---

## Running the Application

1. Clone the repository:
   ```bash
   git clone <repository-link>
   cd monitor-service
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Start the server:
   ```bash
   mvn spring-boot:run
   ```
4. Access the web pages:
   - Base URL: [http://localhost:8080/](http://localhost:8080/)
   - Example pages:
     - [http://localhost:8080/static/html/MonitorListar.html](http://localhost:8080/static/html/MonitorListar.html)

---

## Contributions

Contributions are welcome! Fork the repository, make your changes, and submit a pull request. For any questions, open an issue.
