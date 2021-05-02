package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Factorial {

    public static void main(String[] args) {
        int number = 20;

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Long> futureTask = executorService.submit(() -> factorial(number));

        while (!futureTask.isDone()){
            System.out.println("FutureTask is not finished yet...");
        }

        try {
            long result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    public static long factorial(int number){
        long result = 1;

        for(int i = number; i > 0; i--){
            result *= i;
        }

        return result;
    }
}
