//import java.util.Scanner;

class People{
    public String toString(){
        return "Hello";
    }
}

public class  RecurSion{
    //递归求N的阶乘
    public static int Sion(int num){
        if(num<=1){
            return num;
        }
        return num*Sion(--num);
    }


    //递归求每一位和
    public static int CoutEveryNum(int num){
        if(num==0){
            return 0;
        }
        int ret=CoutEveryNum(num/10);
        return ret+num%10;
    }

    //递归打印每一位
    public static void PrintNum(int num){
        if(num<10){
            System.out.print(num+" ");
            return;
        }
        PrintNum(num/10);
        System.out.print(num%10+" ");
    }

    public static void move(char pos1,char pos2) {
        System.out.println(pos1+"-> "+pos2);
    }

    public static void Hannuo(int num,char pos1,char pos2,char pos3){
        if(num==1){
            move(pos1, pos3);
        }
        else{
            Hannuo(num-1, pos1, pos3, pos2);
            move(pos1, pos3);
            Hannuo(num-1, pos2, pos1, pos3);
        }
    }
    //汉诺塔
    public static void TowerofHanoi(int num){
        Hannuo(num,'A','B','C');
    }

    public static void main(String[] args) {
        // Scanner io=new Scanner(System.in);
        // int num=0;
        // while(io.hasNextInt()){
        //     num=io.nextInt();
        //     //System.out.println(CoutEveryNum(num));
        //     //PrintNum(num);
        //     TowerofHanoi(num);
        // }
        // io.close();
        People p=new People();
        System.out.println(p);
    }
}