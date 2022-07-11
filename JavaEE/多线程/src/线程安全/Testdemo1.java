package 线程安全;

public class Testdemo1 {
    static class Counter {
        public int count = 0;

        synchronized public void increase() {
            count++;
            //synchronized不仅能加锁，还可以解决内存可见性。减少优化，速度减慢。
            String str="abc";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread = new Thread() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increase();
                    System.out.println("1");
                }
            }
        };

        Thread thread1 = new Thread() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increase();
                    System.out.println("2");
                }
            }
        };

        thread.start(); thread1.start();
        thread.join();thread1.join();
        System.out.println(counter.count);
    }
}
