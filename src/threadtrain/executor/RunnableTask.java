package threadtrain.executor;

import java.util.Random;

public class RunnableTask implements Runnable{


    private int taskId;
    private int loopcounter;
    private Random random = new Random();

    public RunnableTask(int taskId, int loopcounter) {
        this.taskId = taskId;
        this.loopcounter = loopcounter;
    }

    @Override
    public void run() {
        for(int i = 1; i <= loopcounter; i++){
            try{
                int sleepTime = random.nextInt(10) + 1;
                System.out.println("Task #" + this.taskId +
                        " - Iteration #" + i +
                        " is going to sleep for " +
                        sleepTime + " seconds.");
                Thread.sleep(sleepTime * 1000);

            }catch (InterruptedException e){
                System.out.println("Task #" + this.taskId +
                        " has been interrupted.");
                break;
            }
        }

    }
}
