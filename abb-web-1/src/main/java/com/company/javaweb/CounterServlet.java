package com.company.javaweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class CounterServlet extends HttpServlet {
    private final Counter counter;

    public CounterServlet(Counter counter) {
        this.counter = counter;
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        counter.increment();
        try (PrintWriter w = rs.getWriter()) {
            w.println("counted...");
        }
    }

}
