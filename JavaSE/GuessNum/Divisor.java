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
