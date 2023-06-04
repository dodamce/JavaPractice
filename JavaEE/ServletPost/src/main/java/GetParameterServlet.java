import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Parameter")
public class GetParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // super.doGet(req, resp);
        // /pParameter?userId=123&classId=450
        String userid = req.getParameter("userId");
        String classid = req.getParameter("classId");
        resp.getWriter().write("userId=" + userid + " classId=" + classid);
    }
}