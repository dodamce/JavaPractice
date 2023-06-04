<<<<<<< HEAD
import java.util.Scanner;

public class PrimeNum {

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        int num = io.nextInt();

        // 除了1和他本身
        boolean flag=true;
        for (int i = 2; i <=Math.sqrt(num); i++) {
            if(num%i==0){
                flag=false;
                break;
            }
        }
        if(flag==true){
            System.out.println("不是素数");
        }
        else{
            System.out.println("是素数");
        }
        io.close();
    }
}
=======
import java.util.Scanner;

public class PrimeNum {

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        int num = io.nextInt();

        // 除了1和他本身
        boolean flag=true;
        for (int i = 2; i <=Math.sqrt(num); i++) {
            if(num%i==0){
                flag=false;
                break;
            }
        }
        if(flag==true){
            System.out.println("不是素数");
        }
        else{
            System.out.println("是素数");
        }
        io.close();
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
