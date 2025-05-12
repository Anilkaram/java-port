<!-- UPDATED: DBUtil.java with table auto-creation -->
package com.portfolio.model;

import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/portfolio_db?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASS = "yourpassword";

    static {
        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "email VARCHAR(100) NOT NULL UNIQUE," +
                    "password VARCHAR(100) NOT NULL)");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS portfolio (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "email VARCHAR(100)," +
                    "name VARCHAR(100)," +
                    "about TEXT," +
                    "skills TEXT," +
                    "contact TEXT," +
                    "FOREIGN KEY (email) REFERENCES users(email) ON DELETE CASCADE)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static boolean validateUser(String email, String password) {
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}