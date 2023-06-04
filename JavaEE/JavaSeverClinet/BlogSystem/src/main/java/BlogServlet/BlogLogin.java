package BlogServlet;

import SeverSQL.SQL_User_DAO;
import SeverSQL.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@WebServlet("/log")
public class BlogLogin extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应解析编码
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");
        // 获取请求参数，和数据库的内容进行比较，比较成功创建会话
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // System.out.println("DEBUG:" + username + " " + password);
        if (null == username || "".equals(username) || null == password || "".equals(password)) {
            // 数据不全
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或密码为空");
            return;
        }
        SQL_User_DAO user_dao = new SQL_User_DAO();
        User user = user_dao.selectUserByName(username);
        if (user == null || !password.equals(user.getPassword())) {
            // 没有这个人或密码不匹配
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或密码错误");
            return;
        }

        // 创建会话
        HttpSession httpSession = req.getSession(true);
        // 将用户信息存到会话中
        httpSession.setAttribute("user", user);

        // 返回重定型报文
        resp.sendRedirect("/blogSystem/Blogger/BloggerList.html");
    }

    // 前端检查当前的登录状态
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf8");
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null) {
            // 没有登录
            User user = new User();
            resp.getWriter().write(objectMapper.writeValueAsString(user));
            return;
        }
        User userReq = (User) httpSession.getAttribute("user");
        if (userReq == null) {
            // 没有登录
            User user = new User();
            resp.getWriter().write(objectMapper.writeValueAsString(user));
            return;
        }

        // 已经登录,不要把密码返回前端
        userReq.setPassword("");
        resp.getWriter().write(objectMapper.writeValueAsString(userReq));
    }
}
