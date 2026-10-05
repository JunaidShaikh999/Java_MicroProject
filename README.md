# Online Auction System - Java Micro Project

A dynamic, thread-safe web-based Online Auction System developed using Java Enterprise technologies (Servlets, JSP) and MySQL. The platform enables users to browse live auction listings, view real-time highest bids, and place competitive bids securely.

---

## 📌 Project Overview

* **Student Name:** Shaikh Mohammed Junaid
* **Roll Number:** 552
* **Class / Branch:** T. Y. EXTC (A Division)
* **Academic Year:** 2026–27
* **Institution:** Pillai College of Engineering

---

## 🛠️ Technology Stack

* **Backend Core:** Java JDK 11+, Java Servlets (MVC Architecture)
* **Data Access Layer:** JDBC, Data Access Objects (DAO)
* **Frontend:** JavaServer Pages (JSP), HTML5, CSS3
* **Database:** MySQL Server (managed via XAMPP / phpMyAdmin)
* **Web Container:** Apache Tomcat v9.0 / v10.0

---

## ✨ Key Features & Technical Highlights

1. **Thread-Safe Bidding Engine:** Uses synchronized DAO methods (`AuctionDAO.java`) to handle concurrent bids without race conditions or bid-overriding anomalies.
2. **SQL Injection Security:** Built with `PreparedStatement` query bindings for secure database operations.
3. **Session Verification:** Restricts bidding access exclusively to authenticated users.
4. **Live Dashboard View:** Displays current highest bids, item details, and remaining time dynamically.

---

## 📂 Project Directory Structure

```text
Java_MicroProject/
├── schema.sql                               # MySQL Database tables setup script
├── src/
│   └── com/
│       └── auction/
│           ├── util/
│           │   └── DBConnection.java        # JDBC Driver Connection Handler
│           ├── dao/
│           │   └── AuctionDAO.java          # Concurrency-safe SQL Bidding Logic
│           └── servlet/
│               └── PlaceBidServlet.java     # HTTP Request Controller & Session Validation
├── web/
│   └── dashboard.jsp                        # Live Auction Frontend View Interface
└── README.md                                # Project Documentation
