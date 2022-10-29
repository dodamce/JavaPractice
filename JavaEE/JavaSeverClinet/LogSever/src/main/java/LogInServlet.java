import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " " + password);
        //跳过数据库读取用户数据阶段
        if ("root".equals(username) && "000000".equals(password)) {
            //通过登录验证,保存用户信息
            HttpSession httpSession = req.getSession(true);
            //向会话中存储信息
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("count", 0);
            //302跳转
            resp.sendRedirect("index");
        } else {
            resp.getWriter().write("log password or username fail");
        }
    }
}
