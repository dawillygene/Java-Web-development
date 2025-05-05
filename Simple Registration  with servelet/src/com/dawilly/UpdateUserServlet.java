package com.dawilly;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Retrieve user details from the request.
        String idStr = request.getParameter("id");
        if (idStr == null || idStr.isEmpty()) {
            response.getWriter().println("Error: Missing user ID");
            return;
        }
        int id = Integer.parseInt(idStr);
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Create a User object and set its fields.
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        
        try {
            // Call the DAO method to update the user.
            new UserDAO().updateUser(user);
            response.sendRedirect("list-users");
        } catch (SQLException e) {
            response.getWriter().println("Error updating user: " + e.getMessage());
        }
    }
}
