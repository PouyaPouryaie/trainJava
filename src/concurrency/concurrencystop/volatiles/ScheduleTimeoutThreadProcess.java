package concurrency.concurrencystop.volatiles;

import concurrency.concurrencystop.MyTask;

public class ScheduleTimeoutThreadProcess {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        Thread t1 = new Thread(myTask);
        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myTask.stop();
    }
}
