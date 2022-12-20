package com.company.web01;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8099);

        Counter counter = new Counter();
        ServletContextHandler handler = new ServletContextHandler();
        CountServlet countServlet = new CountServlet(counter);
        GetCounterServlet getCounterServlet=new GetCounterServlet(counter);
        handler.addServlet(new ServletHolder(countServlet), "/count");
        handler.addServlet(new ServletHolder(getCounterServlet),"/getCount");
        handler.addServlet(HelloServlet.class, "/hello");
        handler.addServlet(HtmlFormattedServlet.class, "/format");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
