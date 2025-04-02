package com.dawilly;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idStr = request.getParameter("id");
        if (idStr == null || idStr.isEmpty()) {
            response.getWriter().println("Error: Missing user ID");
            return;
        }
        int id = Integer.parseInt(idStr);
        
        try {
            new UserDAO().deleteUser(id);
            response.sendRedirect("list-users");
        } catch (SQLException e) {
            response.getWriter().println("Error deleting user: " + e.getMessage());
        }
    }
}
