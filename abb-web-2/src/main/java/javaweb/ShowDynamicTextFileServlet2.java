package javaweb;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class ShowDynamicTextFileServlet2 extends HttpServlet {
    // http://localhost:8080/dynamic2
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        Configuration conf = new Configuration(Configuration.VERSION_2_3_28);
        conf.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        conf.setDirectoryForTemplateLoading(new File("src/main/java/javaweb"));

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jim", 33, "BE3"));
        students.add(new Student("Alex", 44, "BE4"));
        students.add(new Student("Sergio", 55, "BE5"));

        HashMap<String, Object> data = new HashMap<>();
        data.put("data", students);

        try (PrintWriter w = rs.getWriter()){
            conf.getTemplate("test3.ftl").process(data, w);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

}
