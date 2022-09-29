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
        if (pathInfo.startsWith("/")) pathInfo = pathInfo.substring(1);
        String fileName = getClass().getClassLoader().getResource(pathInfo).getFile();
        System.out.println(pathInfo);
        System.out.println(fileName);
//        String bestExample = getClass().getClassLoader().getResource("college.jpg").getFile();
        try (ServletOutputStream os = resp.getOutputStream()) {
            Files.copy(Path.of(fileName), os);
        }
    }
}
