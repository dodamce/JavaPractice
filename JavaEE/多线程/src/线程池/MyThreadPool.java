package 线程池;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyThreadPool {
    //工作线程
    class workThread extends Thread {
        //从队列中取任务
        private  BlockingQueue<Runnable>queue;
        public workThread(BlockingQueue<Runnable> queue) {
            this.queue=queue;
        }

        public void run(){
            while(true){
                try {
                    Runnable task=queue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //阻塞队列组织任务
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    private ArrayList<workThread> list = new ArrayList<>();

    private static final int MAX_WORK_SIZE = 10;

    public void submit(Runnable command) {
        try {
            if (list.size() < MAX_WORK_SIZE) {
                //线程数量不足时，创建新线程，并启动
                workThread work = new workThread(queue);
                work.start();
                list.add(work);
            }
            queue.put(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
