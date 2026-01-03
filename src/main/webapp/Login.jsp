<!DOCTYPE html>
<html>
<head>
<title>Bank Login</title>

<style>
body {
    font-family: Arial;
    background:#e3f2fd;
}
form {
    width:350px;
    margin:100px auto;
    background:#fff;
    padding:30px;
    border-radius:10px;
}
input, button {
    width:100%;
    padding:10px;
    margin-top:10px;
}
button {
    background:#1a73e8;
    color:white;
    border:none;
    cursor:pointer;
}
.role-box {
    margin-top:15px;
}
.error {
    color:red;
    text-align:center;
    margin-top:10px;
}
</style>
</head>

<body>

<form action="login" method="post">
    <h2 style="text-align:center">Bank Login</h2>

    <!-- Account ID for BOTH Admin and User -->
    <input type="text"
           name="accountId"
           placeholder="Account ID"
           required>

    <input type="password"
           name="password"
           placeholder="Password"
           required>

    <div class="role-box">
        <label>
            <input type="radio" name="role" value="ADMIN" required>
            Admin
        </label>
        &nbsp;&nbsp;
        <label>
            <input type="radio" name="role" value="USER" required>
            User
        </label>
    </div>

    <button type="submit">Login</button>

    <div class="error">
        <%= request.getAttribute("error") == null
            ? ""
            : request.getAttribute("error") %>
    </div>
</form>

</body>
</html>
