package javaweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class ShowTextFileServlet extends HttpServlet {
    // http://localhost:8099/showtextfile
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String badExample = "src/main/java/com.company.javaweb/test1.html";
        String fileName = Objects.requireNonNull(getClass().getClassLoader().getResource("test1.html")).getFile().substring(1);

        List<String> lines = Files.readAllLines(Path.of(fileName));
        try (PrintWriter w = rs.getWriter()){
            for (String line: lines) {
                w.println(line);
            }
        }
    }

}
