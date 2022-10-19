package com.company.javaweb;

import com.company.javaweb.dao.DAO;
import com.company.javaweb.entity.Pizza;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class HelloServlet extends HttpServlet {
    private final DAO<Pizza> dao;

    public HelloServlet(DAO<Pizza> dao) {
        this.dao = dao;
    }

    /* http://localhost:8080/hello?x=5&y=7&z=3&z=13&z=15 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String wholeQueryString = req.getQueryString();
//        req.getPart("a");
//        req.getCookies();
//        req.getHeader("a");
//        System.out.println(wholeQueryString);
        Map<String, String[]> all = req.getParameterMap();
        // x -> ['5']
        // y -> ['7']
        // z -> ['3', '13', '15']

        String xs = req.getParameter("x");
        String ys = req.getParameter("y");
        String zs = req.getParameter("z"); // null !!!

        int x = Integer.parseInt(xs);
        int y = Integer.parseInt(ys);
        int z = x + y;

        try (PrintWriter w = resp.getWriter()) {
            w.println(wholeQueryString);
            w.printf("all params: %s\n", all);
            w.printf("Hello, %d, %d given, the sum is %d", x, y, z);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (PrintWriter writer = resp.getWriter()) {
            writer.println("handling POST");
            writer.printf("Custom-Header: %s\n", req.getHeader("Custom-Header"));
            writer.printf("user: %s\n", req.getParameter("user"));
            writer.printf("password: %s\n", req.getParameter("password"));
        }

    }
}
