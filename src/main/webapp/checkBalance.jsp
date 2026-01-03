<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Check Balance</title>

<style>
body { font-family: Arial; background:#e8f5e9; }
.card {
    width:350px; margin:120px auto;
    background:#fff; padding:30px;
    border-radius:10px; text-align:center;
}
h1 { color:#2e7d32; }
</style>
</head>

<body>

<div class="card">
<h2>Account Balance</h2>
<h1>₹ <%= session.getAttribute("balance") %></h1>

<p>Account ID: <%= session.getAttribute("accountId") %></p>

<a href="userDash">⬅ Back to Dashboard</a>
</div>

</body>
</html>
