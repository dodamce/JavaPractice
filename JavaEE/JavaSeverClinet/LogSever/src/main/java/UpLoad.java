import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
@WebServlet("/upload")
public class UpLoad extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("img");
        System.out.println(part.getSize());
        System.out.println(part.getSubmittedFileName());
        System.out.println(part.getContentType());

        //这里选择写入图片文件
        part.write("E:\\TmpBuff\\tmp.jpg");

        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("上传成功");
    }
}
