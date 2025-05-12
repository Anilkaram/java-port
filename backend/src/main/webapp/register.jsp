<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Create an Account</h2>
    <form method="post" action="RegisterServlet">
        <input type="email" name="email" placeholder="Email" required><br>
        <input type="password" name="password" placeholder="Password" required><br>
        <button type="submit">Register</button>
    </form>
    <p style="color:red;">${error}</p>
</div>
</body>
</html>

<!-- SAMPLE: dashboard.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Fill Your Portfolio Info</h2>
    <form method="post" action="PortfolioServlet">
        <input type="text" name="name" placeholder="Full Name" required><br>
        <textarea name="about" placeholder="About You" required></textarea><br>
        <input type="text" name="skills" placeholder="Skills (comma separated)" required><br>
        <input type="text" name="contact" placeholder="Contact Info" required><br>
        <button type="submit">Submit Portfolio</button>
    </form>
</div>
</body>
</html>