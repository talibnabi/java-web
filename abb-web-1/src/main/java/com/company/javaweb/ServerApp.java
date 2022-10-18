package com.company.javaweb;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8089);
        ServletContextHandler handler = new ServletContextHandler();

        Counter counter = new Counter();
        CounterServlet counterServlet = new CounterServlet(counter);
        GetCounterServlet getCounterServlet = new GetCounterServlet(counter);

        handler.addServlet(new ServletHolder(new HelloServlet()), "/hello");
        handler.addServlet(new ServletHolder(new HtmlFormattedServlet()), "/html");
        handler.addServlet(new ServletHolder(counterServlet), "/count");
        handler.addServlet(new ServletHolder(getCounterServlet), "/get");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
