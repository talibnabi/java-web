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
import java.util.HashMap;

public class ShowDynamicTextFileServlet1 extends HttpServlet {
    // http://localhost:8095/dynamic1
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        Configuration conf = new Configuration(Configuration.VERSION_2_3_28);
        conf.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        conf.setDirectoryForTemplateLoading(new File("src/main/java/javaweb"));

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Jim");
        data.put("age", 33);

        try (PrintWriter w = rs.getWriter()) {
            conf.getTemplate("test2.ftl").process(data, w);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

}
