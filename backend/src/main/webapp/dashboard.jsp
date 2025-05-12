<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.portfolio.model.DBUtil" %>
<%
    String email = (String) session.getAttribute("email");
    Connection conn = DBUtil.getConnection();
    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM portfolio WHERE email=?");
    stmt.setString(1, email);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
%>
<!DOCTYPE html>
<html>
<head>
    <title><%= rs.getString("name") %>'s Portfolio</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="portfolio">
        <h1><%= rs.getString("name") %></h1>
        <p><%= rs.getString("about") %></p>
        <h3>Skills</h3>
        <p><%= rs.getString("skills") %></p>
        <h3>Contact</h3>
        <p><%= rs.getString("contact") %></p>
    </div>
</body>
</html>
<% } else { %>
<p>No portfolio info found.</p>
<% } %>