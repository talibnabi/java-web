package javaweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class HistoryServlet extends HttpServlet {
    private final History history;

    public HistoryServlet(History history) {
        this.history = history;
    }
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        Optional<Cookie> found = SessionRelated.find(rq);

        try (PrintWriter w = rs.getWriter()){
            w.println("history:");
            found
                    .map(Cookie::getValue)
                    .map(user -> history.getAll(user))
                    .ifPresentOrElse(
                            items -> items.forEach(w::println),
                            () -> w.println("no logged user")
                    );
        }
    }

}
