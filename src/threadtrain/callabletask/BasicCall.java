package threadtrain.callabletask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class BasicCall {

    public static void main(String[] args) {

        BasicCallable callRunner = new BasicCallable(2000, 10, 20);
        BasicCallable callRunner2 = new BasicCallable(3000, 70, 40);
        BasicCallable callRunner3 = new BasicCallable(1000, 20, 20);

        /**
         * One way to execute a Callable is to use a FutureTask, which implements both
         * the Future and Runnable interfaces, so that you can construct a thread for
         * running it
         **/
        var integerFutureTask = new FutureTask<>(callRunner);
        var integerFutureTask2 = new FutureTask<>(callRunner2);
        var integerFutureTask3 = new FutureTask<>(callRunner3);
        var t = new Thread(integerFutureTask);
        var t2 = new Thread(integerFutureTask2);
        var t3 = new Thread(integerFutureTask3);
        t.start();
        t2.start();
        t3.start();

        try {
            System.out.println("result is " + integerFutureTask3.get());
            System.out.println("result is " + integerFutureTask.get());
            System.out.println("result is " + integerFutureTask2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
