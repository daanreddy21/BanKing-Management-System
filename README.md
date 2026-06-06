# ONLINE BANKING MANAGEMENT SYSTEM

## 1. Introduction

The Online Banking Management System is a web-based application developed using Java, JSP, Servlets, JDBC, MySQL, and Apache Tomcat. The system is designed to simulate real-world banking operations by providing secure account management, transaction processing, and administrative control through role-based access.

The application follows the MVC (Model-View-Controller) architecture and implements the DAO–DTO design pattern to ensure maintainability, scalability, and clean code organization.

The system enables customers to request bank accounts, perform deposits and withdrawals, track transaction history, and download account statements. Administrators can approve or reject account requests, manage users, and monitor banking activities.

---

# 2. Objectives

The main objectives of the project are:

* To provide secure online banking services.
* To automate account creation and approval processes.
* To facilitate online deposits and withdrawals.
* To maintain accurate transaction records.
* To generate downloadable PDF transaction statements.
* To implement role-based authentication and authorization.
* To provide a user-friendly banking interface.

---

# 3. System Modules

## 3.1 Authentication Module

This module handles user authentication and authorization.

### Features

* Login using Account ID and Password.
* Role-based access control.
* Session management.
* Secure dashboard access.

### Roles

* Administrator
* User

---

## 3.2 Account Request Module

This module allows users to submit requests for opening a bank account.

### User Inputs

* Full Name
* Aadhaar Number
* Phone Number
* Address
* Initial Deposit Amount

### Process

1. User submits account request.
2. Request is stored in the database.
3. Status is marked as "PENDING".
4. Administrator reviews the request.

---

## 3.3 Admin Management Module

The administrator is responsible for managing account requests and users.

### Functions

* View all account requests.
* View pending requests.
* Approve account requests.
* Reject account requests with reason.
* Monitor request status.

### Approval Process

When a request is approved:

* Account ID is generated automatically.
* User account is created.
* Initial deposit is credited.
* User gains access to the system.

---

## 3.4 User Dashboard Module

The user dashboard provides banking functionalities after login.

### Features

* View account balance.
* Deposit money.
* Withdraw money.
* View transaction history.
* Download transaction statement PDF.

---

## 3.5 Deposit Module

This module allows users to add funds to their account.

### Process

1. User enters deposit amount.
2. Balance is updated.
3. Transaction is automatically logged.
4. Updated balance is displayed.

---

## 3.6 Withdraw Module

This module allows users to withdraw funds.

### Process

1. User enters withdrawal amount.
2. System validates available balance.
3. Amount is deducted.
4. Transaction is logged automatically.

---

## 3.7 Transaction History Module

This module displays all user transactions.

### Information Displayed

* Transaction Date
* Transaction Type (Credit/Debit)
* Transaction Amount
* Balance After Transaction

### Benefits

* Transparency
* Account monitoring
* Audit trail

---

## 3.8 PDF Statement Module

This feature enables users and administrators to download transaction statements.

### User Features

* Download personal transaction statement.

### Admin Features

* Download statements of approved users.

### PDF Contains

* Account ID
* Transaction Date
* Transaction Type
* Amount
* Balance After Transaction

---

# 4. Technology Stack

## Frontend Technologies

* HTML5
* CSS3
* JSP

## Backend Technologies

* Java
* Servlets
* JDBC

## Database

* MySQL

## Server

* Apache Tomcat 10

## Libraries

* iText PDF

## Design Patterns

* MVC Architecture
* DAO Pattern
* DTO Pattern

---

# 5. Database Design

## Users Table

Stores account information.

Fields:

* account_id
* username
* password
* role
* balance

---

## Account Request Table

Stores account opening requests.

Fields:

* id
* name
* aadhaar
* phone
* address
* deposit
* status
* rejection_reason

---

## Transactions Table

Stores transaction history.

Fields:

* id
* account_id
* type
* amount
* balance_after
* txn_date

---

# 6. Database Trigger

## Trigger Name

trg_log_transaction

### Purpose

The trigger automatically records transaction details whenever a user's balance changes.

### Functions

* Logs credit transactions.
* Logs debit transactions.
* Maintains transaction history.
* Eliminates manual transaction recording.

### Benefits

* Automatic audit logging.
* Improved accuracy.
* Data consistency.
* Reduced coding complexity.

---

# 7. Security Features

The system incorporates multiple security measures:

* Session-based authentication.
* Role-based authorization.
* Prepared Statements to prevent SQL Injection.
* Restricted dashboard access.
* Secure transaction processing.

---

# 8. Project Architecture

The project follows the MVC architecture.

Presentation Layer

* JSP Pages
* HTML
* CSS

Business Layer

* Servlets

Data Access Layer

* DAO Classes

Database Layer

* MySQL Database

This architecture ensures separation of concerns and improves maintainability.

---

# 9. Project Workflow

1. User submits account request.
2. Request is stored in database.
3. Administrator reviews request.
4. Request is approved or rejected.
5. Approved users receive account credentials.
6. User logs into system.
7. User performs banking operations.
8. Transactions are automatically logged.
9. User can download transaction statement PDF.

---

# 10. Learning Outcomes

This project provided practical experience in:

* Java Web Development
* JSP and Servlets
* JDBC Connectivity
* Session Management
* Role-Based Authentication
* MVC Architecture
* DAO and DTO Design Patterns
* MySQL Triggers
* PDF Generation using iText
* Enterprise Application Development

---

# 11. Future Enhancements

The following features can be implemented in future versions:

* Fund Transfer Between Accounts
* OTP Verification
* Email Notifications
* Password Encryption using BCrypt
* Monthly Statement Generation
* Date Range Transaction Reports
* Admin Analytics Dashboard
* Mobile Banking Support

---

# 12. Conclusion

The Online Banking Management System successfully demonstrates the implementation of core banking operations using Java web technologies. The project provides secure authentication, account management, transaction processing, automated transaction logging through database triggers, and PDF statement generation.

The system follows industry-standard development practices such as MVC architecture, DAO–DTO patterns, session management, and secure database operations, making it a strong academic and portfolio project for learning enterprise application development.
