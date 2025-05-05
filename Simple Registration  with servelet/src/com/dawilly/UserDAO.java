package com.dawilly;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Create (INSERT)
    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
        }
    }
    
    // Read (SELECT all)
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        }
        return users;
    }
    
    // Read (SELECT one by id)
    public User getUserById(int id) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM users WHERE id = ?";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                }
            }
        }
        return user;
    }
    
    // Update (UPDATE)
    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
        }
    }
    
    // Delete (DELETE)
    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
