package com.company.javaweb;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GetCounterServlet extends HelloServlet {
    private final Counter counter;

    public GetCounterServlet(Counter counter) {
        this.counter = counter;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (PrintWriter writer = resp.getWriter()) {
            writer.printf("Counted %d",counter.getCounter());
        }
    }
}
