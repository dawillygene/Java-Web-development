package com.dawilly;

import java.sql.*;

public class DBUtil {
    // 1. Added SSL and timezone parameters
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/dawilly?useSSL=false&serverTimezone=UTC";
    private static final String USER = "dawilly";
    private static final String PASS = "********";
    
    // 2. Added static block to load driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found!", e);
        }
    }
    
    public static Connection getConnection() throws SQLException {
        // 3. Added validation
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.err.println("Connection failed! Check: ");
            System.err.println("- Is MySQL running? (sudo systemctl status mysql)");
            System.err.println("- Does user 'dawilly' have database permissions?");
            System.err.println("- Is the password correct?");
            throw e; // Re-throw after showing helpful message
        }
    }
}