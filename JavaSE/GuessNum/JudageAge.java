<<<<<<< HEAD
import java.util.Scanner;

public class JudageAge {
    public static void main(String[] args) {
        Scanner stream=new Scanner(System.in);
        int age=stream.nextInt();
        if(age<=18){
            System.out.println("青少年");
        }
        else if(age>18&&age<=50){
            System.out.println("中年");
        }
        else{
            System.out.println("老年");
        }
        stream.close();
    }
}
=======
import java.util.Scanner;

public class JudageAge {
    public static void main(String[] args) {
        Scanner stream=new Scanner(System.in);
        int age=stream.nextInt();
        if(age<=18){
            System.out.println("青少年");
        }
        else if(age>18&&age<=50){
            System.out.println("中年");
        }
        else{
            System.out.println("老年");
        }
        stream.close();
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
