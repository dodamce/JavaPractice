//程序入口

import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class main {
    public static User login(){
        System.out.println("输入用户姓名");
        Scanner io=new Scanner(System.in);
        String name=io.nextLine();
        System.out.println("输入用户权限 1:管理员 0:普通用户");
        int choice=io.nextInt();
        if(choice==0||choice==1) {
            if (choice == 1) {
                return new AdminUser(name);
            }
            else{
                return new NormalUser(name);
            }
        }
        else{
            System.out.println("用户权限错误，退出程序");
            return null;
        }
    }
    public static void main(String[] args) {
        BookList bookList=new BookList();
        User user=login();//向上转型
        while(user!=null) {
            int choice = user.menu();//动态绑定
            user.SelectWork(choice, bookList);
        }
    }
}
