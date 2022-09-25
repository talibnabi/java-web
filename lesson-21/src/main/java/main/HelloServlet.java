package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class HelloServlet extends HttpServlet {
    /*http://localhost:8099/hello?x=5&y=10&z=1*/
    /*http://localhost:8099/hello?x=5&y=10&z=1&z=4&z=34*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String param1 = req.getParameter("x");
        String param2 = req.getParameter("y");
        String param3 = req.getParameter("z");
        String pathInfo = req.getPathInfo();
        String queryString = req.getQueryString();
        Map<String, String[]> paramMap = req.getParameterMap();
        int x = Integer.parseInt(param1);
        int y = Integer.parseInt(param2);
        int z = Integer.parseInt(param3);
//        String contextPath = req.getContextPath();
//        String authType = req.getAuthType();
//        System.out.println(contextPath);
//        System.out.println(authType);
//        Iterator<String> iterator = req.getHeaderNames().asIterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        Cookie cookie = Arrays.stream(cookies).sorted().findAny().get();
//        System.out.println(cookie);
        try (PrintWriter printWriter = resp.getWriter()) {
            Collection<String[]> values = paramMap.values();
            Set<String> keys = paramMap.keySet();
            printWriter.println("KEYS: ");
            printWriter.println(new ArrayList<>(keys));
            printWriter.println("VALUES: ");
            for(int i=0;i<values.size();i++){
                printWriter.println(Arrays.toString(values.stream().toList().get(i)));
            }
            printWriter.println("PATH INFO: ");
            printWriter.println(pathInfo);
            printWriter.println("QUERY STRING: ");
            printWriter.println(queryString);
            printWriter.printf("First num %s.  Second num %s.  Third num %s ", x, y, z);
//            printWriter.println("First num %s.  Second num %s.  Third num %s ");

        }

    }
}
