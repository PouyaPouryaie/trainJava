package threadtrain.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTaskTest {

    public static void main(String[] args){
        final int THREAD_COUNT = 3;
        final int TASK_COUNT = 5;
        final int LOOP_COUNT = 3;

        // Get an executor with three threads in its thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        // Create five tasks and submit them to the executor
        for(int i = 1; i <= TASK_COUNT; i++){
            RunnableTask runnableTask = new RunnableTask(i, LOOP_COUNT);
            executorService.submit(runnableTask);
        }

        // Let’s shutdown the executor
        executorService.shutdown();
    }
}
