<<<<<<< HEAD
import java.util.Scanner;

public class Divisor {
    public static void main(String[] args) {
        Scanner io=new Scanner(System.in);
        int left=io.nextInt();int right=io.nextInt();
        //计算最大公约数
        int mod=right%left;
        while(mod!=0){
            right=left;
            left=mod;
            mod=right%left;
        }
        System.out.println("Num="+left);
        io.close();
    }
}
=======
import java.util.Scanner;

public class Divisor {
    public static void main(String[] args) {
        Scanner io=new Scanner(System.in);
        int left=io.nextInt();int right=io.nextInt();
        //计算最大公约数
        int mod=right%left;
        while(mod!=0){
            right=left;
            left=mod;
            mod=right%left;
        }
        System.out.println("Num="+left);
        io.close();
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
