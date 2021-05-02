package concurrency.concurrencystop.schedule;

import concurrency.concurrencystop.MyTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadProcess {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        Thread t1 = new Thread(myTask);
        t1.start();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.schedule(() -> {
            System.out.println("stop task with schedules");
            myTask.stop();
        }, 1000, TimeUnit.MILLISECONDS);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        service.shutdownNow();
    }
}
