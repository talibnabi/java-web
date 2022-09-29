package lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ShowTextFileServlet extends HttpServlet {
    // http://localhost:8093/first
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String badExample = "src/main/resources/index.html";
//        String bestExample = getClass().getClassLoader().getResource("index.html").getFile();

        List<String> lines = Files.readAllLines(Path.of(badExample));
        try (PrintWriter writer = resp.getWriter()) {
            for (String line : lines) {
                writer.println(line);
            }
//            writer.println("First number: %d , Last Number: %d , sum: %d");
        }
    }

}
