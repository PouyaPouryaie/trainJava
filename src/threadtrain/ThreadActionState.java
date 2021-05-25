package threadtrain;

public class ThreadActionState extends Thread{

    private volatile boolean keepRunning = true;
    private boolean suspended = false;

    public synchronized void stopThread(){
        this.keepRunning = false;
        this.notify();
    }

    public synchronized void suspendThread(){
        this.suspended = true;
    }

    public synchronized void resumeThread(){
        this.suspended = false;
        this.notify();
    }

    @Override
    public void run() {
        System.out.println("thread is started");
        while(keepRunning){
            try{
                System.out.println("going to sleep");
                Thread.sleep(1000);

                synchronized (this){
                    while (suspended){
                        System.out.println("suspended....");
                        this.wait();
                        System.out.println("Resumed...");
                    }
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread stopped...");
    }

    public static void main(String[] args){
        ThreadActionState t = new ThreadActionState();

        t.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.suspendThread();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.resumeThread();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.stopThread();
    }
}
