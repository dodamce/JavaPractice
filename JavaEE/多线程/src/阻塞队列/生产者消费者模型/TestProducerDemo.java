package 阻塞队列.生产者消费者模型;

public class TestProducerDemo {
    public static void main(String[] args) {
        MyBlockQueue queue=new MyBlockQueue();
        //消费者
        Thread customer=new Thread(){
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("消费元素+ " + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        customer.start();

        //生产者
        Thread producer =new Thread(){
            public void run(){
                for(int i=0;i<50;i++){
                    try {
                        queue.put(i);
                        System.out.println("生产元素 "+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();

        try {
            producer.join();
            customer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
