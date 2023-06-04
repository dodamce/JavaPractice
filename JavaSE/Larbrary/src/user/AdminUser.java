<<<<<<< HEAD
package user;

import operation.*;

public class AdminUser extends User{

    public AdminUser(String name) {
        super(name);
        this.operation=new Operation[]{new ExitOperation(),new FindOperation(),new AddOperation()
                ,new DelOperation(),new DisplayOperation()
        };

    }

    public int menu(){
        System.out.println("Hello Admin "+this.name+": ");
        System.out.println("=====管理员菜单=====");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("=================");
        return choice.nextInt();
    }
}
=======
package user;

import operation.*;

public class AdminUser extends User{

    public AdminUser(String name) {
        super(name);
        this.operation=new Operation[]{new ExitOperation(),new FindOperation(),new AddOperation()
                ,new DelOperation(),new DisplayOperation()
        };

    }

    public int menu(){
        System.out.println("Hello Admin "+this.name+": ");
        System.out.println("=====管理员菜单=====");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("=================");
        return choice.nextInt();
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
