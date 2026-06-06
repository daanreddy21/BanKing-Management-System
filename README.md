🏦 Online Banking Management System
📌 Project Overview

The Online Banking Management System is a web-based application developed using Java, JSP, Servlets, JDBC, MySQL, and Apache Tomcat. The system simulates real-world banking operations by providing secure account management, transaction processing, and administrative control through role-based access.

The application follows the MVC (Model-View-Controller) architecture and implements the DAO–DTO design pattern to maintain clean code structure and separation of concerns.

🎯 Objectives
Provide secure banking services through a web application.
Enable users to manage their accounts online.
Allow administrators to approve or reject account requests.
Maintain transaction records automatically using database triggers.
Generate downloadable PDF transaction statements.
✨ Key Features
🔐 Authentication & Authorization
Role-based login (Admin and User)
Login using Account ID and Password
Session management for secure access
Role-based dashboard redirection
👤 User Module
Account Request
Users can request a new bank account.
Submit:
Full Name
Aadhaar Number
Phone Number
Address
Initial Deposit
Dashboard
View account details
Check available balance
Access banking operations
Deposit Money
Deposit amount into account
Balance updates instantly
Withdraw Money
Withdraw amount from account
Balance validation before withdrawal
Transaction History
View all credit and debit transactions
Date-wise transaction records
PDF Statement Download
Download transaction history as PDF
Includes:
Account ID
Transaction Date
Transaction Type
Amount
Balance After Transaction
🛠️ Admin Module
Account Request Management
View all account requests
Filter requests:
Pending
Approved
Rejected
Approve Requests
Automatically generate Account ID
Create user account
Activate user login access
Reject Requests
Reject requests with a reason
Store rejection reason in database
Dashboard
Monitor all account requests
View account statuses
PDF Statement Access
Download transaction statements of approved users
💰 Transaction Management

The project uses a MySQL Trigger to automatically record every balance change.

Trigger Used
trg_log_transaction
Functions
Logs CREDIT transactions
Logs DEBIT transactions
Maintains transaction history automatically
Eliminates manual transaction entry
🗄️ Database Tables
Users

Stores user account information.

Column
account_id
username
password
role
balance
Account Request

Stores new account requests.

Column
id
name
aadhaar
phone
address
deposit
status
rejection_reason
Transactions

Stores transaction history.

Column
id
account_id
type
amount
balance_after
txn_date
🏗️ Project Architecture
Presentation Layer
│
├── JSP Pages
│
Business Layer
│
├── Servlets
│
Data Access Layer
│
├── DAO Classes
│
Database Layer
│
└── MySQL
📂 Project Structure
Banking_application
│
├── src/main/java
│   │
│   └── com.bank.servlet
│       │
│       ├── LoginServlet
│       ├── UserDashboardServlet
│       ├── AdminDashboardServlet
│       ├── DepositServlet
│       ├── WithdrawServlet
│       ├── TransactionHistoryServlet
│       ├── TransactionPDFServlet
│       ├── CreateAccountServlet
│       ├── RejectAccountServlet
│       │
│       ├── UserDAO
│       ├── LoginDAO
│       ├── TransactionDAO
│       ├── AccountRequestDAO
│       │
│       ├── UserDTO
│       ├── TransactionDTO
│       └── AccountRequestDTO
│
├── src/main/webapp
│   │
│   ├── Login.jsp
│   ├── Home.jsp
│   ├── UserDash.jsp
│   ├── AdminDash.jsp
│   ├── deposit.jsp
│   ├── withdraw.jsp
│   ├── transactionHistory.jsp
│   └── requestAccount.jsp
│
└── pom.xml
🛠️ Technologies Used
Frontend
HTML5
CSS3
JSP
Backend
Java
Servlets
JDBC
Database
MySQL
Server
Apache Tomcat 10
Design Pattern
MVC Architecture
DAO Pattern
DTO Pattern
Additional Libraries
iText PDF
🔒 Security Features
Session-based authentication
Role-based authorization
Prepared Statements to prevent SQL Injection
Controlled access to dashboards
Secure transaction processing
📈 Future Enhancements
Fund Transfer Between Accounts
Email Notifications
OTP Verification
Password Encryption (BCrypt)
Mini Statement
Monthly Statement Generation
Admin Analytics Dashboard
Mobile Banking Integration
🎓 Learning Outcomes

Through this project, I gained practical experience in:

Java Web Development
JSP & Servlets
JDBC Database Connectivity
Session Management
Role-Based Authentication
MVC Architecture
DAO & DTO Design Patterns
MySQL Triggers
PDF Report Generation
Enterprise Application Development
👨‍💻 Author

Reddy

Java Full Stack Developer

Skills Demonstrated
Core Java
JDBC
JSP & Servlets
MySQL
MVC Architecture
DAO & DTO Pattern
Web Application Development
📜 License

This project is developed for educational and learning purposes.
