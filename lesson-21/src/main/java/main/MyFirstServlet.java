package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFirstServlet extends HttpServlet {
    /* http://localhost:8099/first?x=5&y=10 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        int firstNum = Integer.parseInt(x);
        int lastNum = Integer.parseInt(y);
        int sum = firstNum + lastNum;
        try (PrintWriter writer = resp.getWriter()) {
            writer.printf("First number: %d , Last Number: %d , sum: %d", firstNum, lastNum, sum);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            String user = req.getParameter("user");
            String password = req.getParameter("password");
            writer.printf("user: %s\n", user);
            writer.printf("password: %s\n", password);
        }
    }
}
