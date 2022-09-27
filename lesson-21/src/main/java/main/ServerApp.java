package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        createServer();
    }

    private static void createServer() throws Exception {
        Server server = new Server(8099);
        ServletContextHandler handler = new ServletContextHandler();
        Counter counter = new Counter();
        CounterServlet counterServlet = new CounterServlet(counter);
        GetCounterServlet getCounterServlet = new GetCounterServlet(counter);
        handler.addServlet(new ServletHolder(counterServlet), "/counter");
        handler.addServlet(new ServletHolder(getCounterServlet), "/get");
        handler.addServlet(HtmlFormattedServlet.class, "/html");
        handler.addServlet(MyFirstServlet.class, "/first");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
