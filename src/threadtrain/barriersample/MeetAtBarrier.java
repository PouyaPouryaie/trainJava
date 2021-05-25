package threadtrain.barriersample;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MeetAtBarrier extends Thread{

    private CyclicBarrier cyclicBarrier;
    private int customerId;
    private static final Random random = new Random();

    public MeetAtBarrier(CyclicBarrier cyclicBarrier, int customerId) {
        this.cyclicBarrier = cyclicBarrier;
        this.customerId = customerId;
    }

    @Override
    public void run(){

        try{

            int workTime = random.nextInt(30) + 1;
            System.out.println("Thread #" + customerId + " is going to work for " +
                    workTime + " seconds");
            Thread.sleep(workTime * 1000);
            System.out.println("Thread #" + customerId + " is waiting at the barrier...");
            this.cyclicBarrier.await();
            System.out.println("Thread #" + customerId + " passed the barrier...");
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }catch (BrokenBarrierException b){
            b.printStackTrace();
        }
    }

    public static void main(String[] args){
        Runnable barrierAction = () -> System.out.println("We are all together. It's party time...");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, barrierAction);

        for(int i = 1; i <= 3; i++){
            MeetAtBarrier meetAtBarrier = new MeetAtBarrier(cyclicBarrier, i);
            meetAtBarrier.start();
        }

    }
}
