package com.company.web01;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GetCounterServlet extends HttpServlet {
    private final Counter counter;

    public GetCounterServlet(Counter counter) {
        this.counter = counter;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num=counter.get();
        try (PrintWriter writer = resp.getWriter()) {
            writer.printf("Count %d",num);
        }
    }
}
