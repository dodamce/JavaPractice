import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //返回主页
        //从session中获取用户名
        HttpSession httpSession = req.getSession(false);//此处一定存在session会话
        String username = (String) httpSession.getAttribute("username");
        Integer count = (Integer) httpSession.getAttribute("count");
        count += 1;
        //将访问次数写回session中
        httpSession.setAttribute("count", count);

        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("<h3>" + username + " 访问次数: " + count + "</h3>");
    }
}
