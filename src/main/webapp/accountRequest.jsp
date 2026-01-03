<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Account Request</title>
<style>
body { font-family: Arial; background:#e3f2fd; }
form {
    width: 400px; margin: 80px auto;
    background:#fff; padding:30px;
    border-radius:10px;
}
input, textarea, button {
    width:100%; padding:10px; margin-top:10px;
}
button { background:#1a73e8; color:#fff; border:none; }
</style>
</head>
<body>

<form action="requestAccount" method="post">
    <h2>Open Bank Account</h2>

    <input type="text" name="name" placeholder="Full Name" required>
    <input type="text" name="aadhaar" placeholder="Aadhaar / ID" required>
    <input type="text" name="phone" placeholder="Phone Number" required>
    <textarea name="address" placeholder="Address" required></textarea>

    <input type="number" name="deposit" placeholder="Initial Deposit Amount" required>

    <button type="submit">Submit Request</button>
</form>


</body>
</html>
