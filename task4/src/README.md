# Student Management CRUD System - Java + MySQL

## 🔧 Technologies Used
- Java (JDK 17+)
- MySQL 8+
- JDBC
- JUnit 4
- Logging (java.util.logging)
- Maven (optional)

## 📦 Project Architecture
- **Model Layer**: Student.java
- **DAO Layer**: Handles DB interactions
- **Service Layer**: Business logic and validations
- **Test Layer**: JUnit test cases
- **Utility Layer**: DB connection & Logger

## 🗄️ MySQL Database Setup

1. Start MySQL server.
2. Run the SQL file `studentdb.sql` to create database and tables:

```sql
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE student (
  id INT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100),
  course VARCHAR(50)
);


INSERT INTO student VALUES (202, 'Bob Smith', 'bob@example.com', 'Math');
INSERT INTO student VALUES (203, 'Charlie Brown', 'charlie@example.com', 'Science');
