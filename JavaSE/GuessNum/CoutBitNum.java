<<<<<<< HEAD
import java.util.Scanner;

public class CoutBitNum {

    //计算一个数字中二进制的个数
    public static void main(String[] args) {
        Scanner io=new Scanner(System.in);
        int num=io.nextInt();
        int ret=0;
        for(int i=0;i<32;i++){
            if((num&1)==1){
                ret++;
            }
            num=num>>1;
        }
        System.out.println(ret);
        io.close(); 
    }
}
=======
import java.util.Scanner;

public class CoutBitNum {

    //计算一个数字中二进制的个数
    public static void main(String[] args) {
        Scanner io=new Scanner(System.in);
        int num=io.nextInt();
        int ret=0;
        for(int i=0;i<32;i++){
            if((num&1)==1){
                ret++;
            }
            num=num>>1;
        }
        System.out.println(ret);
        io.close(); 
    }
}
>>>>>>> 0b04fd50139e8c47c05c68c9a1899337be946a02
