public class TestThreadSur {
    static class Counter {
        public int count = 0;

        public void Increase() {
            ++count;
        }
    }

    static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.Increase();
                }
            }
        };
        Thread thread1 = new Thread() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.Increase();
                }
            }
        };
        thread.start();thread1.start();
        thread.join();thread1.join();
        System.out.println(counter.count);
    }
}
