package lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StaticFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        System.out.println(pathInfo);
//        String bestExample = getClass().getClassLoader().getResource("college.jpg").getFile();
        try (ServletOutputStream os = resp.getOutputStream()) {
            Files.copy(Path.of(pathInfo), os);
        }
    }
}
