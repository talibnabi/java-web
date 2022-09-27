package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GetCounterServlet extends HttpServlet {
    private final Counter c;

    public GetCounterServlet(Counter c) {
        this.c = c;
    }


    //or GET
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            writer.printf("Count: %d", c.getNumber());
        }
    }
}
