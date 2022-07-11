package 线程同步;

public class ThreadDemo1 {
    static class MyWait implements Runnable {
        private Object locker = null;

        MyWait(Object object) {
            this.locker = object;
        }

        public void run() {
            synchronized (locker) {
                System.out.println("wait begin....");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait end!");
            }
        }
    }

    static class MyNotify implements Runnable {
        Object locker = null;

        MyNotify(Object object) {
            this.locker = object;
        }

        public void run() {
            synchronized (locker) {
                System.out.println("notify begin....");
                locker.notify();
                System.out.println("notify end!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Thread thread=new Thread(new MyWait(locker));
        Thread thread1=new Thread(new MyNotify(locker));
        thread.start();
        Thread.sleep(3000);
        thread1.start();
    }
}
