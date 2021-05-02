package concurrency.concurrencystop.interrupts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class TimeoutThread {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        interruptFuture(executorService);
        //interruptPools(executorService);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    private static void interruptPools(ExecutorService executorService){

        AtomicInteger count = new AtomicInteger(0);
        executorService.submit(() -> {
            while (!Thread.currentThread().isInterrupted()){
                count.getAndIncrement();
                System.out.println("i am working with " + count);
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();
    }

    private static void interruptFuture(ExecutorService executorService){

        AtomicInteger count = new AtomicInteger(0);
        Future<?> future = executorService.submit(() -> {
            while (!Thread.currentThread().isInterrupted()){
                count.getAndIncrement();
                System.out.println("i am working in future with " + count);
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        future.cancel(true);
    }
}
