package BlogServlet;

import SeverSQL.Blog;
import SeverSQL.SQL_Blog_DAO;
import SeverSQL.SQL_User_DAO;
import SeverSQL.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorInfo")
public class BlogAuthor extends HttpServlet {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到指定博客ID->作者的用户id->的作者信息
        resp.setContentType("application/json; charset=utf8");
        String id = req.getParameter("blogId");
        if (id == null || "".equals(id)) {
            //参数缺少
            resp.getWriter().write("{\"ok:\"false,\"reason:\"\"参数缺失\"}");
        } else {
            //根据当前id查询数据库
            SQL_Blog_DAO blogDao = new SQL_Blog_DAO();
            Blog blog = blogDao.select(Integer.parseInt(id));
            if (blog.getUserId() == -1) {
                resp.getWriter().write("{\"ok:\"false,\"reason:\"\"查询博客不存在\"}");
                return;
            }
            //根据Blog对象的用户ID找到作者信息
            SQL_User_DAO userDao = new SQL_User_DAO();
            User user = userDao.selectUserById(blog.getUserId());
            if ("".equals(user.getUserName())) {
                resp.getWriter().write("{\"ok:\"false,\"reason:\"\"查询用户不存在,非法操作\"}");
                return;
            }
            user.setPassword("");//密码不返回前端
            //将信息返回浏览器
            resp.getWriter().write(objectMapper.writeValueAsString(user));
        }
    }
}
