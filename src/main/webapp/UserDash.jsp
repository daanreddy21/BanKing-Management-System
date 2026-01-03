<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>User Dashboard</title>

<style>
body { font-family: Arial; background:#e3f2fd; margin:0; }
header {
    background:#1a73e8; color:#fff;
    padding:15px 30px;
    display:flex; justify-content:space-between;
}
.container { padding:30px; }
.card {
    background:#fff; padding:25px;
    border-radius:10px;
    box-shadow:0 4px 10px rgba(0,0,0,.2);
    max-width:500px;
    margin:auto;
    text-align:center;
}
.menu {
    display:flex;
    justify-content:space-around;
    margin-top:30px;
}
.menu a {
    text-decoration:none;
    background:#1a73e8;
    color:white;
    padding:12px 20px;
    border-radius:8px;
}
.menu a:hover { background:#0d47a1; }
</style>
</head>

<body>

<header>
  <h2>Welcome, <%= session.getAttribute("username") %></h2>
  <a href="logout" style="color:white;">Logout</a>
</header>

<div class="container">

  <div class="card">
    <h3>Account Balance</h3>
    <h1><%= session.getAttribute("balance") %></h1>
    <p>Account ID: <%= session.getAttribute("accountId") %></p>
  </div>

  <div class="menu">
    <a href="deposit.jsp">Deposit</a>
    <a href="withdraw.jsp">Withdraw</a>
    <a href="transactions">Transactions</a>
  </div>

</div>

</body>
</html>
