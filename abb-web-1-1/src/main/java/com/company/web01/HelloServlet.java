package com.company.web01;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class HelloServlet extends HttpServlet {
    //http://localhost:8099/hello?x=6&y=9
    //http://localhost:8099/hello?x=6&y=9&y=34
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String z = req.getParameter("z");
        System.out.println(z);
        int xx = Integer.parseInt(x);
        int yy = Integer.parseInt(y);
        int sumXY = xx + yy;
        System.out.println("Hello");


        String pathInfo = req.getPathInfo();

        String queryString = req.getQueryString();

        Map<String, String[]> all = req.getParameterMap();


        try (PrintWriter printWriter = resp.getWriter()) {
            String formatted = String.format("Hello from Java.Dinara is %d,Aylin is %d.Sum = %d", xx, yy, sumXY);
            printWriter.println(formatted);
            printWriter.println(pathInfo);
            printWriter.println(queryString);
            printWriter.println(all);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.println("POST Method.");
            printWriter.println("user: " + req.getParameter("user"));
            printWriter.println("password: " + req.getParameter("password"));
        }
    }
}
