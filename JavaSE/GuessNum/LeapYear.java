<<<<<<< HEAD
import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner io=new Scanner(System.in);
        while(io.hasNextInt()){
            int num=io.nextInt();
            if((num%4==0&&num%100==0)||(num%400==0)){
                System.out.println("是闰年");
            }
            else{
                System.out.println("不是闰年");
            }
        }
        io.close();
    }
}
=======
import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner io=new Scanner(System.in);
        while(io.hasNextInt()){
            int num=io.nextInt();
            if((num%4==0&&num%100==0)||(num%400==0)){
                System.out.println("是闰年");
            }
            else{
                System.out.println("不是闰年");
            }
        }
        io.close();
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
