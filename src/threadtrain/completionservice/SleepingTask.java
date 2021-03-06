package threadtrain.completionservice;

import java.util.Random;
import java.util.concurrent.Callable;

public class SleepingTask implements Callable<TaskResult> {

    private int taskId;
    private int loopCounter;
    private Random random = new Random();

    public SleepingTask(int taskId, int loopCounter) {
        this.taskId = taskId;
        this.loopCounter = loopCounter;
    }

    @Override
    public TaskResult call() throws Exception {

        int totalSleepTime = 0;
        for(int i = 1; i <= loopCounter; i++){
            try {
                int sleepTime = random.nextInt(10) + 1;
                System.out.println("Task #" + this.taskId + " - Iteration #" + i
                        + " is going to sleep for " + sleepTime + " seconds.");
                Thread.sleep(sleepTime * 1000);
                totalSleepTime = totalSleepTime + sleepTime;
            }catch (InterruptedException e){
                System.out.println("Task #" + this.taskId +
                        " has been interupted.");

                throw e;
            }
        }

        return new TaskResult(taskId, totalSleepTime);
    }
}
