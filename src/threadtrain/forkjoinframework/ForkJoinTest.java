package threadtrain.forkjoinframework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinTest {

    // Create a ForkJoinPool to run the task
    private static ForkJoinPool pool = new ForkJoinPool();

    public static void main(String[] args) {

        // Create an instance of the task
        RandomIntSum task = new RandomIntSum(10);

        // Run the task
        long sum = pool.invoke(task);
        System.out.println("Sum is " + sum);

        //ForkJoinSumCalculator
        long[] numbers = LongStream.rangeClosed(1, 100000000).toArray();
        ForkJoinTask<Long> sumTask = new ForkJoinSumCalculator(numbers);
        long result = pool.invoke(sumTask);
        System.out.println(result);
    }
}
