package 登录测试;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class log {
    public static void main(String[] args) {
        JFrame frame = new JFrame("登录");
        frame.setBounds(400, 200, 300, 300);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel name = new JLabel("账号:");
        JLabel key = new JLabel("密码:");
        JTextField nameField = new JTextField("请输入账号", 20);
        JPasswordField keyField = new JPasswordField("", 20);
        JTextField method = new JTextField("登录状态:", 25);
        JButton button = new JButton("登录");

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = nameField.getText();
                String key = keyField.getText();

                //获取数据库集
                MySQL mySQL = new MySQL();
                Connection connection = mySQL.getConnection();
                String sql = "SELECT * FROM user";
                boolean flag = false;
                try {
                    mySQL.statement = connection.prepareStatement(sql);
                    mySQL.resultSet = mySQL.statement.executeQuery();
                    //遍历结果
                    while (mySQL.resultSet.next()) {
                        String id = mySQL.resultSet.getString("id");
                        String password = mySQL.resultSet.getString("password");
                        if (username.equals(id) && password.equals(key)) {
                            flag = true;
                            method.setText("登录成功");
                            break;
                        }
                    }
                    if (!flag) {
                        method.setText("登录失败，数据库无此成员");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        mySQL.closeConnection();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        frame.add(name);
        frame.add(nameField);
        frame.add(key);
        frame.add(keyField);
        frame.add(method);
        frame.add(button);

        //固定大小
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
