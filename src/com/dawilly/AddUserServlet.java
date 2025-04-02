package com.dawilly;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.SQLException;

public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        
        try {
            new UserDAO().addUser(user);
            response.sendRedirect("list-users");
        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}