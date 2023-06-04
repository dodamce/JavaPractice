import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/states")
public class StatutsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.setStatus(200);
        // resp.getWriter().write("Hello");
        // resp.setHeader("Refresh", "1");
        // resp.getWriter().write("time: " + System.currentTimeMillis());
        // 重定向
        // resp.setStatus(302);
        // resp.setHeader("Location", "https://www.baidu.com");
        resp.sendRedirect("https://www.baidu.com");
    }
}
