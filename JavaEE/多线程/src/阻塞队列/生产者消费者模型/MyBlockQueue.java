package 阻塞队列.生产者消费者模型;

class MyBlockQueue {
    private int[] array = new int[10];
    private int head = 0;
    private int till = 0;
    private int size = 0;
    Object locker = new Object();

    //put入队列
    public void put(int num) throws InterruptedException {
        synchronized(locker) {
            while (size == array.length) {
                //阻塞等待
                System.out.println("队列已满，阻塞等待");
                locker.wait();
            }
            array[till++] = num;
            size++;
            if (till >= array.length) {
                till = 0;
            }
            //唤醒take线程
            locker.notify();
        }
    }

    //take出队列
    public int take() throws InterruptedException {
        synchronized (locker) {
            if (size == 0) {
                System.out.println("队列为空，阻塞等待");
                locker.wait();
            }
            int pop = array[head];
            head++;
            if (head >= array.length) {
                head = 0;
            }
            size--;
            locker.notify();//唤醒put线程
            return pop;
        }
    }
}
