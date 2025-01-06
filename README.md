# Code_Alpha_StudentGradeTracker
# Student Grade Tracker

## Overview
The **Student Grade Tracker** is a console-based Java application designed to manage and analyze student grades efficiently. It integrates seamlessly with a MySQL database to store and retrieve data, ensuring scalability and robustness. This project demonstrates the use of Java programming, JDBC, and database management to solve real-world problems.

---

## Features
- **Dynamic Input Handling**:
  - Accepts student names and grades with proper validation.
  - Ensures data integrity by validating user inputs.

- **Database Integration**:
  - Stores student details and grades in a MySQL database using JDBC.
  - Retrieves data efficiently for analysis.

- **Performance Analytics**:
  - Calculates and displays:
    - Average score of all students.
    - Highest score among students.
    - Lowest score among students.

- **Interactive Console Interface**:
  - User-friendly, menu-driven interface.
  - Options for entering, viewing, and analyzing student data.

---

## How It Works
1. **Input Handling**:
   - The user is prompted to input the total number of students, their names, and grades.
   - Data validation ensures that grades are between 0 and 100.

2. **Database Operations**:
   - The application connects to a MySQL database.
   - Student data is stored in the database for persistent storage.
   - Queries are used to retrieve, update, and analyze data.

3. **Analysis and Results**:
   - The program calculates the average score and identifies the highest and lowest scores among students.
   - Results are displayed to the user in real-time.

---

## Prerequisites
1. **Java**: Ensure JDK 8 or higher is installed.
2. **MySQL**: A running MySQL server.
3. **JDBC Driver**: MySQL Connector/J must be added to the project.

---

## Database Setup
1. **Create Database**:
   ```sql
   CREATE DATABASE student_grades_db;
   ```

2. **Create Table**:
   ```sql
   USE student_grades_db;

   CREATE TABLE student_grades (
       id INT AUTO_INCREMENT PRIMARY KEY,
       student_name VARCHAR(100) NOT NULL,
       marks INT NOT NULL
   );
   ```

---

## How to Run
1. Clone the repository from GitHub.
2. Set up the MySQL database using the instructions above.
3. Update database credentials in the code:
   ```java
   static final String JDBC_URL = "jdbc:mysql://localhost:3306/student_grades_db?useSSL=false&serverTimezone=UTC";
   static final String JDBC_USER = "YOUR_USERNAME";
   static final String JDBC_PASS = "YOUR_PASSWORD";
   ```
4. Compile and run the Java program:
   ```bash
   javac StudentGradeTracker.java
   java StudentGradeTracker
   ```

---

## Skills Demonstrated
- **Java Programming**: Console applications, data validation, control structures.
- **JDBC Integration**: Establishing and managing database connections.
- **Database Management**: Creating, querying, and updating MySQL tables.
- **Problem Solving**: Implementing real-world solutions using programming.

---

## Acknowledgments
Special thanks to **CodeAlpha Technology** for providing this opportunity to enhance my programming and database management skills.

