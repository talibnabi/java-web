package lesson.explicit;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ShowEifelPictureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String badExample = "src/main/resources/eifel.jpg";
        String bestExample = getClass().getClassLoader().getResource("eifel.jpg").getFile();
        try(ServletOutputStream os=resp.getOutputStream()){
            Files.copy(Path.of(badExample),os);
        }
    }
}
