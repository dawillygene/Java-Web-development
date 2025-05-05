package com.dawilly;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.SQLException;

public class ListUsersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h1>User List</h1>");
        out.println("<a href='add-user.html'>Add New User</a><br><br>");
        
        try {
            List<User> users = new UserDAO().getAllUsers();
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Action</th></tr>");
            
            for (User user : users) {
                out.println("<tr>");
                out.println("<td>" + user.getId() + "</td>");
                out.println("<td>" + user.getName() + "</td>");
                out.println("<td>" + user.getEmail() + "</td>");
                out.println("<td><a href='edit-user?id=" + user.getId() + "'>Edit</a> | ");
                out.println("<a href='delete-user?id=" + user.getId() + "'>Delete</a></td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
        } catch (SQLException e) {
            out.println("Error: " + e.getMessage());
        }
        
        out.println("</body></html>");
    }
}