<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Deposit</title>

<style>
body { font-family: Arial; background:#e3f2fd; }
.box {
    width:400px; margin:100px auto;
    background:#fff; padding:30px;
    border-radius:10px; text-align:center;
}
input, button {
    width:100%; padding:10px; margin-top:15px;
}
button {
    background:#1a73e8; color:white; border:none;
}
</style>
</head>

<body>

<div class="box">
<h2>Deposit Money</h2>

<form action="deposit" method="post">
    <input type="number" name="amount" placeholder="Enter amount" required min="1">
    <input type="password" name="password" placeholder="Confirm password" required>
    <button type="submit">Confirm Deposit</button>
</form>

<br>
<a href="UserDash.jsp">Back to Homepage</a>
</div>

</body>
</html>
