package threadtrain.forkjoinframework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.RecursiveTask;

public class RandomIntSum extends RecursiveTask<Long> {

    private static Random randGenerator = new Random();
    private int count;


    public RandomIntSum(int count) {
        this.count = count;
    }

    public int getRandomInteger() {
        // Generate the next randon integer between 1 and 100
        int n = randGenerator.nextInt(100) + 1;
        System.out.println("Generated a random integer: " + n);
        return n;
    }

    @Override
    protected Long compute() {

        long result = 0;

        if(this.count <=0){
            return 0L;
        }
        if(count == 1){
            return (long) this.getRandomInteger();
        }

        // Multiple numbers. Divide them into many single tasks. Keep the references of
        // all tasks to call thier join() method later
        List<RecursiveTask<Long>>forks = new ArrayList<>();
        for(int i = 0; i < this.count; i++) {
            RandomIntSum subTask = new RandomIntSum(1);
            subTask.fork(); // Launch the subtask
            // Keep the subTask references to combine the results later
            forks.add(subTask);
        }

        // Now wait for all subtasks to finish and combine the result
        for(RecursiveTask<Long> subTask : forks) {
            result = result + subTask.join();
        }
        return result;
    }
}
