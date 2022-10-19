package com.company.javaweb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class FormCheckBoxServlet extends HttpServlet {

    /**
     * showing form
     * http://localhost:8099/form_checkbox
     */
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String fileName = Objects.requireNonNull(getClass().getClassLoader().getResource("form_checkbox.html")).getFile().substring(1);

        List<String> lines = Files.readAllLines(Path.of(fileName));
        try (PrintWriter w = rs.getWriter()) {
            for (String line : lines) {
                w.println(line);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try (PrintWriter w = rs.getWriter()){
            String username = rq.getParameter("button1");
            String password = rq.getParameter("button2");
            w.printf("user entered: %s, %s", username, password);
        }
    }

}
