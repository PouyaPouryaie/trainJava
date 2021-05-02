package threadtrain.latch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class LatchHelperService extends Thread {

    private int id;
    private CountDownLatch latch;
    private Random random = new Random();

    public LatchHelperService(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run(){

        try {
            int startupTime = random.nextInt(30) + 1;
            System.out.println("Service #" + id + " starting in "
                    + startupTime + " seconds...");
            Thread.sleep(startupTime * 1000);
            System.out.println("Service #" + id + " has started...");

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            this.latch.countDown();
        }



    }
}
