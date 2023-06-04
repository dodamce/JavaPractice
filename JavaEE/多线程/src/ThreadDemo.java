class MyThread extends Thread {
    //重写Thread中的run函数
    public void run() {
        System.out.println("Hello Thread");
    }
}
class MyRunnable implements Runnable{
    public void run(){
        System.out.println("Hello MyRunnable");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();

        Thread thread1=new Thread(new MyRunnable());
        thread1.start();

        //匿名类，继承Thread
        Thread thread2=new Thread(){
            @Override
            public void run(){
                System.out.println("Hello New Thread");
            }
        };
        thread2.start();

        //lambda表达式
        Thread thread3= new Thread(()->{
            System.out.println("Hello lambda");
        });
        thread3.start();
    }
}
