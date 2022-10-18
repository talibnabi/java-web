package com.company.javaweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HtmlFormattedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<html>");
            writer.println("<body>");
            writer.println("<table border=\"1\">");
            writer.println("    <tr>");
            writer.println("        <td>iphone 14</td>");
            writer.println("        <td>2000</td>");
            writer.println("    </tr>");
            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}
