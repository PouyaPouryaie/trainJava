package threadtrain.semaphoresample;

import java.util.Random;

public class RestaurantCustomer extends Thread {

    private Restaurant r;
    private int customerId;
    private static final Random random = new Random();

    public RestaurantCustomer(Restaurant r, int customerId) {
        this.r = r;
        this.customerId = customerId;
    }

    @Override
    public void run(){

        r.getTable(this.customerId);
        try {
            int eatingTime = random.nextInt(30) + 1;
            System.out.println("Customer #" + this.customerId +
                    " will eat for " + eatingTime +
                    " seconds.");
            Thread.sleep(eatingTime * 1000);
            System.out.println("Customer #" + this.customerId +
                    " is done eating.");
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }

        finally {
            r.returnTable(this.customerId);
        }

    }
}
