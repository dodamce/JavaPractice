import java.util.Scanner;

public class TestJava {
    public static void main(String[] args) {
        Scanner deal=new Scanner(System.in);
        int a=deal.nextInt();
        if(a%2==0){
            System.out.println(a);
        }
        else{
            System.out.println("技术");
        }
    }
}
