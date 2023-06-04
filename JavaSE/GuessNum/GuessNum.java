<<<<<<< HEAD
import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args) {
        Random rad=new Random();
        int num=rad.nextInt(11);//生成的0-10

        Scanner del=new Scanner(System.in);
        while(true){
            int guess=del.nextInt();
            if(guess==num){
                System.out.println("猜大了");
                break;
            }
            else if(guess>num){
                System.out.println("猜大了");
            }
            else{
                System.out.println("猜小了");
            }
        }

        del.close();
    }
}
=======
import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args) {
        Random rad=new Random();
        int num=rad.nextInt(11);//生成的0-10

        Scanner del=new Scanner(System.in);
        while(true){
            int guess=del.nextInt();
            if(guess==num){
                System.out.println("猜大了");
                break;
            }
            else if(guess>num){
                System.out.println("猜大了");
            }
            else{
                System.out.println("猜小了");
            }
        }

        del.close();
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
