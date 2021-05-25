package threadtrain;

import java.util.Random;

public class Producer extends Thread {

    private Buffer buffer;

    public Producer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {

        Random rand = new Random();
        while(true){
            int data = rand.nextInt();
            buffer.produce(data);
        }
    }
}
