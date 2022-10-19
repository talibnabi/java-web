package javaweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class CalcServlet extends HttpServlet {
    private final History history;

    public CalcServlet(History history) {
        this.history = history;
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        Optional<String> found = SessionRelated.find(rq).map(Cookie::getValue);

        if (found.isEmpty()){
            rs.addCookie(SessionRelated.newRandom());
        }

        try (PrintWriter w = rs.getWriter()) {
            w.printf("user id = %s\n", found.orElse("not found. can't count this data"));
            String xs = rq.getParameter("x");
            String ys = rq.getParameter("y");
            int x = Integer.parseInt(xs);
            int y = Integer.parseInt(ys);
            int z = x + y;
            found.ifPresent(user -> history.save(user, new HistoryItem(x, y, z)));

            w.printf("adding... %d + %d = %d", x, y, z);
        }

    }

}
