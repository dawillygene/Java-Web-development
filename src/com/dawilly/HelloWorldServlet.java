package com.dawilly;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;


public class HelloWorldServlet extends HttpServlet{

protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>my name is dawilly gene! and heavenlight Elia mariki</h1>");
        out.println("</body></html>");
    }
}