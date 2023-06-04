<<<<<<< HEAD
package user;

import operation.*;

import java.util.Scanner;

public class NormalUser extends User{

    public NormalUser(String name){
        super(name);
        this.operation=new Operation[]{new ExitOperation(),new FindOperation(),new BorrowOperation()
                ,new ReturnOperation(),new DisplayOperation()
        };
    }

    public int menu(){
        System.out.println("Hello User "+this.name+": ");
        System.out.println("=====操作菜单=====");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("================");
        return choice.nextInt();
    }
}
=======
package user;

import operation.*;

import java.util.Scanner;

public class NormalUser extends User{

    public NormalUser(String name){
        super(name);
        this.operation=new Operation[]{new ExitOperation(),new FindOperation(),new BorrowOperation()
                ,new ReturnOperation(),new DisplayOperation()
        };
    }

    public int menu(){
        System.out.println("Hello User "+this.name+": ");
        System.out.println("=====操作菜单=====");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("================");
        return choice.nextInt();
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
