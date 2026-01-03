<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Request Submitted</title>

<style>
body {
    font-family: Arial;
    background: #e3f2fd;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.box {
    background: #fff;
    padding: 30px;
    border-radius: 10px;
    text-align: center;
    width: 400px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.2);
}

.box h2 {
    color: #1a73e8;
}

.box p {
    margin-top: 15px;
    font-size: 15px;
}
</style>

<script>
    // Show popup immediately
    window.onload = function () {
        alert("✅ Your account request has been submitted successfully.\n⏳ Please wait for 24 hours for admin approval.");
        
        // Redirect after 3 seconds
        setTimeout(function () {
            window.location.href = "Homepage.jsp"; // or dashboard.jsp
        }, 3000);
    };
</script>

</head>
<body>

<div class="box">
    <h2>Request Submitted</h2>
    <p>Your account request is under review.</p>
    <p>Please wait <b>24 hours</b> for admin approval.</p>
    <p>You will be redirected shortly...</p>
</div>

</body>
</html>
