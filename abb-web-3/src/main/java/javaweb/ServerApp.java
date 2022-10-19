package javaweb;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.sql.Connection;
import java.sql.DriverManager;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(9091);
        ServletContextHandler handler = new ServletContextHandler();
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/be5",
                "postgres",
                "12345"
        );
        History historyService = new HistoryServiceDatabase(conn);

        CalcServlet calcServlet = new CalcServlet(historyService);
        HistoryServlet historyServlet = new HistoryServlet(historyService);
        LogoutServlet logoutServlet = new LogoutServlet(historyService);
        handler.addServlet(new ServletHolder(calcServlet), "/calc");
        handler.addServlet(new ServletHolder(historyServlet), "/history");
        handler.addServlet(new ServletHolder(logoutServlet), "/logout");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
