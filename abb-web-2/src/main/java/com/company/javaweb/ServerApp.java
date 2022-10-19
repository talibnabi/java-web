package com.company.javaweb;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8099);
        ServletContextHandler handler = new ServletContextHandler();

        server.setHandler(handler);
        server.start();
        server.join();

    }
}
