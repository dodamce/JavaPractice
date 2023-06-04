<<<<<<< HEAD
import java.util.Scanner;

public class Register {
    public static void main(String[] args) {
        Scanner io=new Scanner(System.in);
        int time=3;
        String str="12345";
        while(time>0){
            System.out.println("请输入登录密码:");
            String key=io.nextLine();
            if(key.equals(str)){
                System.out.println("登录成功");
                break;
            }
            System.out.println("密码错误");
            time--;
        }
        if(time==0){
            System.out.println("次数用尽，强制退出");
        }
        io.close();
    }
}
=======
import java.util.Scanner;

public class Register {
    public static void main(String[] args) {
        Scanner io=new Scanner(System.in);
        int time=3;
        String str="12345";
        while(time>0){
            System.out.println("请输入登录密码:");
            String key=io.nextLine();
            if(key.equals(str)){
                System.out.println("登录成功");
                break;
            }
            System.out.println("密码错误");
            time--;
        }
        if(time==0){
            System.out.println("次数用尽，强制退出");
        }
        io.close();
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
