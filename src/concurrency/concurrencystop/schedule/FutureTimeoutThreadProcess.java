package concurrency.concurrencystop.schedule;

import concurrency.concurrencystop.MyTask;

import java.util.concurrent.*;

public class FutureTimeoutThreadProcess {

    public static void main(String[] args) {

        ExecutorService servicePool = Executors.newFixedThreadPool(2);

        MyTask myTask = new MyTask();
        Future<?> future = servicePool.submit(myTask);

        try {
            future.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            future.cancel(true);
            myTask.stop();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        servicePool.shutdownNow();
    }
}
