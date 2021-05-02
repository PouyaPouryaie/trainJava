package threadtrain;

public class ThreadIntrruptAnotherThread {

    public static void main(String[] args){

        Thread t = new Thread(ThreadIntrruptAnotherThread::run);
        t.start();

        try {
            Thread.currentThread().sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        t.interrupt();
    }

    public static void run(){
        int count = 0;

        while(!Thread.interrupted()){
            count++;
        }
        System.out.println("Counter:" + count);
    }
}
