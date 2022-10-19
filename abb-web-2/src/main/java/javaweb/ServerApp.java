package javaweb;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8096);
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new FormServlet()), "/form");
        handler.addServlet(new ServletHolder(new FormCheckBoxServlet()), "/form_checkbox");
        handler.addServlet(new ServletHolder(new ShowTextFileServlet()), "/showtextfile");
        handler.addServlet(new ServletHolder(new StaticFileServlet()), "/*");
        handler.addServlet(new ServletHolder(new ShowDynamicTextFileServlet1()), "/dynamic1");
        handler.addServlet(new ServletHolder(new ShowDynamicTextFileServlet2()), "/dynamic2");
        server.setHandler(handler);
        server.start();
        server.join();

    }
}
