package concurrency.concurrencystop;

import java.util.concurrent.atomic.AtomicBoolean;

public class MyTask implements Runnable{

    //volatile boolean keepRunning = true;
    AtomicBoolean keepRunning = new AtomicBoolean(true);

    @Override
    public void run() {
        while (keepRunning.get()){
            System.out.println("I am working in process");
        }
    }

    public void stop(){
        keepRunning.set(false);
    }
}
