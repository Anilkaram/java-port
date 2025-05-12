package com.portfolio.controller;

import com.portfolio.model.DBUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class PortfolioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String name = request.getParameter("name");
        String about = request.getParameter("about");
        String skills = request.getParameter("skills");
        String contact = request.getParameter("contact");

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO portfolio (email, name, about, skills, contact) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, name);
            stmt.setString(3, about);
            stmt.setString(4, skills);
            stmt.setString(5, contact);
            stmt.executeUpdate();
            response.sendRedirect("portfolio.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("dashboard.jsp");
        }
    }
}