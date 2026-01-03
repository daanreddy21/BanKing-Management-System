<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Withdraw</title>

<style>
body { font-family: Arial; background:#fdecea; }
.box {
    width:400px; margin:100px auto;
    background:#fff; padding:30px;
    border-radius:10px; text-align:center;
}
input, button {
    width:100%; padding:10px; margin-top:15px;
}
button {
    background:#d32f2f; color:white; border:none;
}
</style>
</head>

<body>

<div class="box">
<h2>Withdraw Money</h2>
<p>Available Balance:  <%= session.getAttribute("balance") %></p>

<form action="withdraw" method="post">
    <input type="number" name="amount" placeholder="Enter amount" required min="1">
    <input type="password" name="password" placeholder="Confirm password" required>
    <button type="submit">Confirm Withdraw</button>
</form>

<br>
<a href="UserDash.jsp"> Back to HomePage</a>
</div>

</body>
</html>
