package BlogServlet;

import SeverSQL.Blog;
import SeverSQL.SQL_Blog_DAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/blog")
public class BlogList extends HttpServlet {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //尝试获取请求中的blogId,如果这个参数存在，说明是要请求博客id
        String msg = req.getParameter("blogId");
        SQL_Blog_DAO blogDao = new SQL_Blog_DAO();
        resp.setContentType("application/json; charset=utf8");
        if (msg == null) {
            //没有具体的博客ID，直接获取所有的博客列表
            List<Blog> blogList = blogDao.selectAll();
            //将blogList的数据转化为Json格式
            String Json = objectMapper.writeValueAsString(blogList);
//        System.out.println(Json);
            resp.getWriter().write(Json);
        } else {
            //获取具体的博客详情
            int blogId = Integer.parseInt(msg);
//            System.out.println(blogId);
            Blog blog = blogDao.select(blogId);
//            System.out.println(blog.getPostTime());
            String Json = objectMapper.writeValueAsString(blog);
            resp.getWriter().write(Json);
        }
    }
}
