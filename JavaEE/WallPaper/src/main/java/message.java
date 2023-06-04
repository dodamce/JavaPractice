import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class MessageTitle {
    public String from;
    public String to;
    public String speck;
}

@WebServlet("/TestServe")
public class message extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    //将一个消息保存到数据库中
    private void save(MessageTitle msg) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = javaSql.getConnection();
            //构造sql语句
            String sql = "insert into message values(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, msg.from);
            preparedStatement.setString(2, msg.to);
            preparedStatement.setString(3, msg.speck);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            javaSql.close(connection, preparedStatement, null);
        }
    }

    //从数据库中取所有的数据
    private List<MessageTitle> load() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<MessageTitle> list = new ArrayList<>();
        try {
            connection = javaSql.getConnection();
            String sql = "select * from message";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            //遍历结果集
            while (resultSet.next()) {
                MessageTitle msg = new MessageTitle();
                msg.from = resultSet.getString("from");
                msg.to = resultSet.getString("to");
                msg.speck = resultSet.getString("speck");
                list.add(msg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            javaSql.close(connection, preparedStatement, resultSet);
        }
        return list;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理提交消息请求
        MessageTitle message = objectMapper.readValue(req.getInputStream(), MessageTitle.class);

        //保存数据
        save(message);
        //返回的数据为json格式
        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write("{ \"ok\": true }");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取消息队列，返回客户端
        List<MessageTitle> list = load();
        String json = objectMapper.writeValueAsString(list);
        System.out.println(json);

        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write(json);
    }
}
