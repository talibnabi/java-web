package com.company.web01;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class CountServlet extends HttpServlet {
    private final Counter counter;

    public CountServlet(Counter counter) {
        this.counter = counter;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter.increment();
        try (PrintWriter writer = resp.getWriter()) {
            writer.println("Counted....");
        }
    }
}
