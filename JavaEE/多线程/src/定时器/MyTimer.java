package 定时器;

import java.util.concurrent.PriorityBlockingQueue;

class Task implements Comparable<Task>{//描述任务
    private Runnable command;//执行的任务
    public long time;//这个任务多少时间要在什么时候执行

    public void run() {
        command.run();
    }

    public Task(Runnable run, long time) {
        this.command = run;
        this.time = System.currentTimeMillis() + time;
    }

    //指定优先队列的优先级
    @Override
    public int compareTo(Task o) {
        return (int)(this.time-o.time);
    }
}

class MyTimer {
    private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();//组织任务

    public void schedule(Runnable command, long time) {
        Task task = new Task(command, time);
        queue.put(task);
        synchronized (locker){
            locker.notify();//重新添加任务时唤醒线程，保证新加入的任务不会错过。
        }
    }

    private Object locker=new Object();//解决忙等问题

    public MyTimer() {
        //创建线程，扫描队列。
        Thread thread = new Thread() {
            public void run() {
                while (true) {
                    try {
                        Task task = queue.take();
                        long curTime = System.currentTimeMillis();
                        if (task.time > curTime) {
                            //时间未到
                            queue.put(task);
                            synchronized(locker) {
                                locker.wait(task.time-curTime);
                            }
                        } else {
                            //时间到了
                            task.run();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        thread.start();
    }
}
