package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HtmlFormattedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Page Title</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>This is a heading</h1>");
            writer.println("<p>This is a paragraph.</p>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}
