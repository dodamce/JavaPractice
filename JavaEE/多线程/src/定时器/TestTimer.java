package 定时器;

public class TestTimer {
    public static void main(String[] args) {
        MyTimer timer=new MyTimer();
        System.out.println("开始运行");
        timer.schedule(new Runnable(){
            public void run(){
                System.out.println("Hello Timer");
            }
        },3000);
    }
}
