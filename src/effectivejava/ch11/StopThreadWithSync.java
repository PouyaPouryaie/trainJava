package effectivejava.ch11;

import java.util.concurrent.TimeUnit;

public class StopThreadWithSync {

    private static boolean stopRequest;

    private static synchronized void requestStop(){
        stopRequest = true;
    }

    private static synchronized boolean stopRequested(){
        return stopRequest;
    }

    public static void main(String[] args) throws InterruptedException{

        Thread backGroundThread = new Thread(() ->{
            int i = 0;
            while (!stopRequested()){
                i++;
                System.out.println(i);
            }
        });

        backGroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
