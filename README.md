============================================
 Appointment Booking System – Backend (Spring Boot + MySQL)
============================================

Description:
-------------
This is the backend of an Appointment Booking System developed using Spring Boot and MySQL. It provides RESTful APIs for managing appointments, users, and administrators, enabling appointment scheduling, updating, and deletion functionalities.

Technologies Used:
-------------------
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL Database
- Maven
- Postman (for testing)
- Git & GitHub (for version control)

Key Features:
--------------
- User registration and login
- Create, update, delete appointments
- Assign appointments to time slots
- Role-based access (Admin/User)
- View appointment list per user or all (admin)
- Secure endpoints using JWT 

Folder Structure (Simplified):
------------------------------
appointment-system/
├── controller/
├── service/
├── repository/
├── model/
├── dto/
├── config/
└── application.properties

Setup Instructions:
--------------------
1. Clone the Repository:
   git clone https://github.com/Marshal-A-Tech/Appointment-system.git

2. Navigate to Backend Directory:
   cd Appointment-system

3. Configure MySQL in application.properties:
   spring.datasource.url=jdbc:mysql://localhost:3306/appointment_db
   spring.datasource.username=your_mysql_user
   spring.datasource.password=your_mysql_password
   spring.jpa.hibernate.ddl-auto=update

4. Run the Application:
   mvn spring-boot:run

5. Server will start at:
   http://localhost:9091

Sample Endpoints:
------------------
- POST   /users/register       → Register a new user
- POST   /users/login          → User login
- GET    /appointments         → Get all appointments (Admin)
- GET    /appointments/user    → Get user’s appointments
- POST   /appointments         → Book a new appointment
- PUT    /appointments/{id}    → Update appointment
- DELETE /appointments/{id}   → Delete appointment

Testing:
---------
Use Postman or similar tools to test all endpoints with or without authentication.

Author:
--------
Marshal Amirthalingam
GitHub: https://github.com/Marshal-A-Tech
Email: marshall.amirthalingam@gmail.com

License:
---------
This project is open-source under the MIT License.

