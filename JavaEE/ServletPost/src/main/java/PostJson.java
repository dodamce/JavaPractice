import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

//存放Json转化后的数据
class user {
    public int userId;
    public int classId;
}

@WebServlet("/postJson")
public class PostJson extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建jackson对象
        ObjectMapper objectMapper = new ObjectMapper();
        // 将字符串转化为Java对象,第一个参数是待转化的Json字符串，第二个参数是转化的类型
        user msg = objectMapper.readValue(req.getInputStream(), user.class);

        resp.getWriter().write("userId: " + msg.userId + " classId: " + msg.classId);
    }
}
