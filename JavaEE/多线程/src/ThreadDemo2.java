public class ThreadDemo2 {
    public static void main(String[] args) {
        Thread thread=new Thread(){
            @Override
            public void run(){
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println("线程运行中...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();//如果线程正在休眠，此时会抛出异常
    }
}
