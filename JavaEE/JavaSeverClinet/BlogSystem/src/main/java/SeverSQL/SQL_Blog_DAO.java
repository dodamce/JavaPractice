package SeverSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//封装Blog表的增删查改
public class SQL_Blog_DAO {
    public void insert(Blog blog) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = GetMySQL.getConnection();

            //构造sql语句
            String sql = "insert into javablog.blog values(null,?,?,?,now())";

            statement = connection.prepareStatement(sql);
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setInt(3, blog.getUserId());

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            GetMySQL.close(connection, statement, null);
        }
    }

    //获取所有博客
    public List<Blog> selectAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Blog> lists = new ArrayList<>();
        try {
            connection = GetMySQL.getConnection();
            //desc 按照降序排列
            String sql = "select * from javablog.blog order by postTime desc ";
            statement = connection.prepareStatement(sql);

            result = statement.executeQuery();

            //变量结果集合
            while (result.next()) {
                Blog blog = new Blog();
                blog.setBlogId(result.getInt("blogId"));
                blog.setTitle(result.getString("title"));
                //如果摘要太长了，进行截取
                String content = result.getString("content");
                if (content.length() > 50) {
                    content = content.substring(0, 50) + "...";
                }
                blog.setContent(content);
                blog.setUserId(result.getInt("userId"));
                blog.setPostTime(result.getTimestamp("postTime"));
                lists.add(blog);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            GetMySQL.close(connection, statement, result);
        }
        return lists;
    }

    //根据博客id查询博客
    public Blog select(int blogId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Blog blog = new Blog();
        try {
            connection = GetMySQL.getConnection();
            String sql = "select * from javablog.blog where blogId=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);

            result = statement.executeQuery();//主键一定是唯一的
//            System.out.println(result);
            //变量结果集合
            if (result.next()) {
                blog.setBlogId(result.getInt("blogId"));
                blog.setTitle(result.getString("title"));
                blog.setContent(result.getString("content"));
                blog.setUserId(result.getInt("userId"));
//                System.out.println("DEBUG:" + result.getTimestamp("postTime"));
                blog.setPostTime(result.getTimestamp("postTime"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            GetMySQL.close(connection, statement, result);
        }
        return blog;
    }

    public void drop(int blogId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = GetMySQL.getConnection();
            String sql = "delete from javablog.blog where blogId=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            GetMySQL.close(connection, statement, null);
        }
    }

}
