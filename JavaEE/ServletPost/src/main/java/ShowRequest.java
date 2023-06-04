import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showRequest")
public class ShowRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // super.doGet(req, resp);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<h3> 首行部分 </h3>");
        stringBuilder.append(req.getProtocol()).append("<br>"); //协议的名称和版本
        stringBuilder.append(req.getMethod()).append("<br>"); //请求使用的方法
        stringBuilder.append(req.getRequestURI()).append("<br>"); //获取请求uri
        stringBuilder.append(req.getContextPath()).append("<br>"); //返回请求上下文的请求URI部分
        stringBuilder.append(req.getQueryString()).append("<br>"); //返回包含在路径后的请求URL中的查询字符串
        stringBuilder.append("<h3> header 部分 </h3>");
        Enumeration<String> headerNames = req.getHeaderNames(); //获取报头所有项名称
        while (headerNames.hasMoreElements()) {
            //迭代器遍历枚举元素
            String name = headerNames.nextElement();
            String value = req.getHeader(name); //获取HTTP报头对应名称的值
            stringBuilder.append(name).append(":").append(value).append("<br>");
        }

        // 将数据写到响应中
        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write(stringBuilder.toString());
    }
}
