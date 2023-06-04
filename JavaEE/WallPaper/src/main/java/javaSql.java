import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class javaSql {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/java_sql?characterEncoding=utf8&&useSSL=false";
    private static final String user = "root";
    private static final String password = "000000";

    private static volatile MysqlDataSource dataSource = null;

    private static MysqlDataSource getDataSource() {
        if (dataSource == null) {
            synchronized (javaSql.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    dataSource.setURL(url);
                    dataSource.setUser(user);
                    dataSource.setPassword(password);
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
