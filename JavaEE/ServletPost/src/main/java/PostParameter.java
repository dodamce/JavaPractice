import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PostParameter")
public class PostParameter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // super.doPost(req, resp);
        // userid=10&classid=20
        String userid = req.getParameter("userId");
        String classId = req.getParameter("classId");

        resp.getWriter().write("userId:" + userid + " classId:" + classId + "Test");

    }
}
