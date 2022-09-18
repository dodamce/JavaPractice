package FirstSwing;

import javax.swing.*;
import java.awt.*;

public class Test {

    public static void main(String[] args) {
        JFrame frame = new JFrame("frame");
        frame.setBounds(400, 200, 300, 300);

        frame.setLayout(new FlowLayout(FlowLayout.LEFT));


        //常见布局
//        FlowLayout
//        BorderLayout
//        GridLayout

        //文本域组件
//        JTextArea area = new JTextArea(20, 10);
//        frame.add(area);
//        /*设置自动换行*/
//        area.setLineWrap(true);
        /*获取用户输入内容*/
        //area.getText();
        //文本框组件、密码框组件
//        JLabel label = new JLabel("账号");
//        JTextField text = new JTextField("输入账号", 20);
//
//        JPasswordField key = new JPasswordField("", 20);
////        key.setEchoChar('*');
//        JLabel label1 = new JLabel("密码");
//        frame.add(label);
//        frame.add(text);
//
//        frame.add(label1);
//        frame.add(key);
        //菜单
//        JMenuBar jMenuBar = new JMenuBar();
//        JMenu menu = new JMenu("菜单一");
//        JMenuItem jMenuItem1 = new JMenuItem("选项1");
//        JMenuItem jMenuItem2 = new JMenuItem("选项2");
//        menu.add(jMenuItem1);
//        menu.add(jMenuItem2);
//        jMenuBar.add(menu);
//        frame.add(jMenuBar);

        //下拉组件
//        JComboBox box = new JComboBox();
//        box.addItem("请选择学历:");
//        box.addItem("高中");
//        box.addItem("大学");
//        box.addItem("研究生");
//        frame.add(box);
        //复选框
//        JCheckBox checkBox1 = new JCheckBox("睡觉", false);
//        JCheckBox checkBox2 = new JCheckBox("睡觉", false);
//        JCheckBox checkBox3 = new JCheckBox("睡觉", false);
//
//        frame.add(checkBox1);
//        frame.add(checkBox2);
//        frame.add(checkBox3);
        //单选框
//        JRadioButton jRadioButton = new JRadioButton("男");
//        JRadioButton jRadioButton1 = new JRadioButton("女");
//        ButtonGroup buttonGroup = new ButtonGroup();
//        buttonGroup.add(jRadioButton);
//        buttonGroup.add(jRadioButton1);
//
//        frame.add(jRadioButton);
//        frame.add(jRadioButton1);

//        //文本框
//        JLabel jLabel = new JLabel("账号", SwingConstants.LEFT);
//        frame.add(jLabel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("frame");
//        frame.setBounds(200, 200, 500, 500);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        JButton jb = new JButton("Test");
//        JPanel jp = new JPanel(new FlowLayout());
//        jp.add(jb);
//        frame.add(jp);
//        frame.setVisible(true);
//    }
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("first swing JFrame");
//        frame.setSize(400, 200);
//        frame.setLocation(400, 300);
//
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        JDialog dialog = new JDialog(frame, "Dialog");
//        dialog.setBounds(400,300,100,100);
//
//        dialog.setVisible(true);
//        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//    }
}
