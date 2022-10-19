package com.company.javaweb;

import com.company.javaweb.controller.FormCheckBoxServlet;
import com.company.javaweb.controller.FormServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8099);
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new FormServlet()), "/form");
        handler.addServlet(new ServletHolder(new FormCheckBoxServlet()),"/form_checkbox");
        server.setHandler(handler);
        server.start();
        server.join();

    }
}
