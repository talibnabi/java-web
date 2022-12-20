package com.company.web01;

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
            writer.println("<html lang=\"en\">\n");
            writer.println("<head>\n");
            writer.println("    <meta charset=\"UTF-8\">\n");
            writer.println("    <title>Title</title>\n");
            writer.println("</head>\n");
            writer.println("<body>\n");
            writer.println("<table border=\"1\">\n");
            writer.println("        <tr>\n");
            writer.println("            <td>\n");
            writer.println("                Hello\n");
            writer.println("            </td>\n");
            writer.println("            <td>\n");
            writer.println("                Hi\n");
            writer.println("            </td>\n");
            writer.println("        </tr>\n");
            writer.println("</table>\n");
            writer.println("</body>\n");
            writer.println("</html>");
        }
    }
}
