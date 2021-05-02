package threadtrain;

public class ThreadState extends Thread {

    private boolean keepRunning = true;
    private boolean wait = false;
    private Object syncObj = null;

    public ThreadState(Object syncObj){
        this.syncObj = syncObj;
    }

    @Override
    public void run() {

        while (keepRunning){
            synchronized (syncObj){
                if(wait){
                    try{
                        syncObj.wait();
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
            }
        }
    }

    public void setKeepRunning(boolean keepRunning){
        this.keepRunning = keepRunning;
    }

    public void setWait(boolean wait){
        this.wait = wait;
    }
}
