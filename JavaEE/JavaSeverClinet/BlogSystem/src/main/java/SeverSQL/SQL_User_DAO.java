package SeverSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//封装User表的增删查改
public class SQL_User_DAO {
    //查找用户信息，用于登录
    public User selectUserByName(String name) {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = GetMySQL.getConnection();
            String sql = "select * from javablog.user where username=?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            //查询结果为一个或者没有结果
            if (resultSet.next()) {
                User user = new User();
//                System.out.println("DEBUG SUCCESS");
                user.setUserId(resultSet.getInt("userId"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            GetMySQL.close(connection, statement, resultSet);
        }
        return null;
    }

    public User selectUserById(int id) {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        User user = new User();
        try {
            connection = GetMySQL.getConnection();
            String sql = "select * from javablog.user where userId=?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            //查询结果为一个或者没有结果
            if (resultSet.next()) {
                user.setUserId(resultSet.getInt("userId"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            GetMySQL.close(connection, statement, resultSet);
        }
        return user;
    }
}
