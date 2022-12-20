package com.company.web01;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8099);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(HelloServlet.class, "/hello");
        handler.addServlet(HtmlFormattedServlet.class,"/format");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
