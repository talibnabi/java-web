package lesson;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        createServer();
    }

    private static void createServer() throws Exception {
        Server server = new Server(8093);
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new ShowTextFileServlet()), "/showTextFile");
        handler.addServlet(new ServletHolder(new ShowEifelPictureServlet()),"/eifel");
        handler.addServlet(new ServletHolder(new ShowEngineeringCollegeServlet()),"/college");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
