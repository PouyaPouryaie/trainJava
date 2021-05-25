package effectivejava.ch11;

import java.util.concurrent.TimeUnit;

public class StopThreadWithVolatile {

    private static volatile boolean stopRequest;

    public static void main(String[] args) throws InterruptedException{

        Thread backgroundThread = new Thread(()->{
           int i = 0;

           while (!stopRequest){
               i++;
               System.out.println(i);
           }
        });

        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequest = true;
    }
}
