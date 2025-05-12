package com.portfolio.controller;

import com.portfolio.model.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO users (email, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.executeUpdate();
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "User already exists or DB error.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}