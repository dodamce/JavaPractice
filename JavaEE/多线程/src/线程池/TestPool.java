package 线程池;

public class TestPool {
    public static void main(String[] args) {
        //创建线程池实例
        MyThreadPool threadPool=new MyThreadPool();
        for(int i=0;i<20;i++){
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("MyThreadPool");
                }
            });
        }
    }
}
