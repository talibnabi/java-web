package javaweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class StaticFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String requestedName = rq.getPathInfo();
        System.out.println(requestedName);
        if (requestedName.startsWith("/")) {
            requestedName = requestedName.substring(1);
        }
        String fileName = Objects.requireNonNull(getClass().getClassLoader().getResource(requestedName)).getFile().substring(1);
        try (ServletOutputStream os = rs.getOutputStream()) {
            Files.copy(Path.of(fileName), os);
        }
    }

}
