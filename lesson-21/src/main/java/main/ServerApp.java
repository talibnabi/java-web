package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8099);
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(MyFirstServletApp.class, "/first");
        handler.addServlet(MySecondServletApp.class,"/second");
        handler.addServlet(HelloServlet.class, "/hello");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
