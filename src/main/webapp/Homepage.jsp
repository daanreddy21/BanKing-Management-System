<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOCAL Cash Bank | Home</title>

<style>
    html {
        scroll-behavior: smooth;
    }

    body {
        margin: 0;
        padding: 0;
        font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #1a73e8, #0d47a1);
        min-height: 100vh;
        color: #fff;
    }

    header {
        background: rgba(0,0,0,0.15);
        padding: 20px 40px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        position: sticky;
        top: 0;
        z-index: 1000;
    }

    header h1 {
        margin: 0;
        font-size: 26px;
    }

    nav a {
        color: #fff;
        text-decoration: none;
        margin-left: 20px;
        font-weight: 500;
    }

    nav a:hover {
        opacity: 0.8;
    }

    .hero {
        text-align: center;
        margin-top: 80px;
        padding: 20px;
    }

    .hero h2 {
        font-size: 38px;
        margin-bottom: 15px;
    }

    .hero p {
        font-size: 18px;
        max-width: 700px;
        margin: auto;
        line-height: 1.6;
    }

    .actions {
        margin-top: 40px;
    }

    .actions a {
        display: inline-block;
        padding: 14px 30px;
        margin: 10px;
        background: #fff;
        color: #1a73e8;
        border-radius: 30px;
        text-decoration: none;
        font-size: 16px;
        font-weight: bold;
    }

    .actions a:hover {
        background: #e3f2fd;
    }

    .features {
        display: flex;
        justify-content: center;
        flex-wrap: wrap;
        margin: 80px 40px;
    }

    .feature-box {
        background: #ffffff;
        color: #333;
        width: 260px;
        padding: 25px;
        margin: 15px;
        border-radius: 14px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        text-align: center;
    }

    .feature-box h3 {
        color: #0d47a1;
    }

    /* Bottom sections */
    .section {
        background: #ffffff;
        color: #333;
        padding: 60px 20px;
        text-align: center;
    }

    .section h2 {
        color: #0d47a1;
        margin-bottom: 20px;
    }

    .section p {
        max-width: 800px;
        margin: auto;
        line-height: 1.6;
        font-size: 16px;
    }

    footer {
        text-align: center;
        padding: 15px;
        background: rgba(0,0,0,0.3);
        font-size: 14px;
    }
</style>
</head>

<body>

<header>
    <h1>LOCAL Cash Bank</h1>
    <nav>
        <a href="#home">Home</a>
        <a href="Login.jsp">Login</a>
        <a href="#about">About</a>
        <a href="#contact">Contact</a>
    </nav>
</header>

<!-- HOME -->
<div id="home" class="hero">
    <h2>Welcome to LOCAL Cash Bank</h2>
    <p>
        Secure, fast, and reliable digital banking solution.
        Manage accounts, view transactions, and perform banking operations
        with complete transparency and safety.
    </p>

    <div class="actions">
        <a href="Login.jsp">Login</a>
        <a href="accountRequest.jsp">Account Request</a>
    </div>
</div>
<!-- FEATURES -->
<div class="features">
    <div class="feature-box">
        <h3>Secure Banking</h3>
        <p>Advanced security to protect your money and data.</p>
    </div>

    <div class="feature-box">
        <h3>Easy Transfers</h3>
        <p>Transfer money quickly between accounts.</p>
    </div>

    <div class="feature-box">
        <h3>24/7 Access</h3>
        <p>Bank anytime, anywhere with online access.</p>
    </div>

    <div class="feature-box">
        <h3>Admin Control</h3>
        <p>Admins can manage users and transactions efficiently.</p>
    </div>
</div>

<!-- ABOUT -->
<div id="about" class="section">
    <h2>About Us</h2>
    <p>
        LOCAL Cash Bank is a digital banking platform designed for secure
        and transparent financial operations. This system allows users
        to manage accounts, perform transactions, and track activities
        efficiently while providing administrators full control over
        user and transaction management.
    </p>
</div>
<!-- CONTACT -->
<div id="contact" class="section">
    <h2>Contact Us</h2>
    <p>
        📍 Location: India <br><br>
        📧 Email: support@localcashbank.com<br><br>
        📞 Phone: +91 98765 43210 <br><br>
        ⏰ Support Hours: 9:00 AM – 6:00 PM
    </p>
</div>
<footer>
    © 2025 LOCAL Cash Bank. All rights reserved.
</footer>

</body>
</html>
