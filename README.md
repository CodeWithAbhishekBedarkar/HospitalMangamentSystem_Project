# 🏥 Hospital Management System (Spring Boot)

A **Hospital Management System** developed using **Spring Boot** and **MySQL** that enables efficient management of patients, doctors, and their consultations. The project exposes RESTful APIs with full CRUD operations, partial updates, and proper layered architecture, making it ideal for learning and real-world backend development.

---

## 🚀 Features

* Patient Management (Create, Update, Partial Update, Delete, View)
* Doctor Management (Create, Update, Partial Update, Delete, View)
* Patient–Doctor Consultation & Medical Advice
* RESTful APIs with JSON request/response
* MySQL database integration
* JPA & Hibernate ORM
* Clean layered architecture
* Easy to test using Postman / Swagger

---

## 🛠️ Tech Stack

* **Language:** Java
* **Framework:** Spring Boot
* **ORM:** Spring Data JPA, Hibernate
* **Database:** MySQL
* **Build Tool:** Maven
* **Testing Tool:** Postman
* **Server:** Embedded Tomcat

---

## 📂 Project Structure

```
HospitalManagementSystem
│
├── controller
│   ├── PatientController.java
│   ├── DoctorController.java
│   └── ConsultationController.java
│
├── service
│   ├── PatientService.java
│   ├── DoctorService.java
│   └── ConsultationService.java
│
├── repository
│   ├── PatientRepository.java
│   ├── DoctorRepository.java
│   └── ConsultationRepository.java
│
├── entity
│   ├── Patient.java
│   ├── Doctor.java
│   └── Consultation.java
│
├── dto
│   ├── PatientDTO.java
│   ├── DoctorDTO.java
│   └── ConsultationDTO.java
│
├── exception
│   └── GlobalExceptionHandler.java
│
└── HospitalManagementSystemApplication.java
```

---

## ⚙️ Configuration

### Database Configuration (application.properties)

```
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

---

## 📌 API Endpoints Documentation

### 👤 Patient APIs

| Method | Endpoint           | Description            |
| ------ | ------------------ | ---------------------- |
| POST   | /api/patients      | Create new patient     |
| GET    | /api/patients/{id} | Get patient by ID      |
| GET    | /api/patients      | Get all patients       |
| PUT    | /api/patients/{id} | Full update patient    |
| PATCH  | /api/patients/{id} | Partial update patient |
| DELETE | /api/patients/{id} | Delete patient by ID   |
| DELETE | /api/patients      | Delete all patients    |

---

### 👨‍⚕️ Doctor APIs

| Method | Endpoint          | Description           |
| ------ | ----------------- | --------------------- |
| POST   | /api/doctors      | Create new doctor     |
| GET    | /api/doctors/{id} | Get doctor by ID      |
| GET    | /api/doctors      | Get all doctors       |
| PUT    | /api/doctors/{id} | Full update doctor    |
| PATCH  | /api/doctors/{id} | Partial update doctor |
| DELETE | /api/doctors/{id} | Delete doctor by ID   |
| DELETE | /api/doctors      | Delete all doctors    |

---

### 🩺 Consultation APIs

| Method | Endpoint                | Description            |
| ------ | ----------------------- | ---------------------- |
| POST   | /api/consultations      | Create consultation    |
| GET    | /api/consultations/{id} | Get consultation by ID |
| GET    | /api/consultations      | Get all consultations  |
| PUT    | /api/consultations/{id} | Update consultation    |
| DELETE | /api/consultations/{id} | Delete consultation    |

---

## 🧪 Sample JSON

### Create Doctor

```json
{
  "doctorName": "Dr. Murlidhar Sharma",
  "specialization": "Cardiology",
  "gender": "Male",
  "contactNumber": "9876543210",
  "role": "DOCTOR"
}
```

### Create Consultation

```json
{
  "patientId": 1,
  "doctorId": 101,
  "consultantId": 5001,
  "healthIssue": "Chest pain",
  "doctorAdvice": "ECG test and medication"
}
```

---

## ▶️ How to Run the Project

1. Clone the repository
2. Import project into IDE (STS / IntelliJ)
3. Configure MySQL database
4. Run `HospitalManagementSystemApplication`
5. Test APIs using Postman

---

## 🎯 Use Case

This project is ideal for:

* Java & Spring Boot learners
* Backend developer practice
* College mini / major projects
* REST API development understanding

---

## 👨‍💻 Author

**Abhishek Bedarkar**
Java | Spring Boot | Backend Developer

---

⭐ If you find this project useful, give it a star on GitHub!
