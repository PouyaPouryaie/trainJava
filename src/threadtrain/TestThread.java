package threadtrain;

public class TestThread {

    public static void main(String[] args){


        System.out.println("start program");
        Thread t1 = new Thread(TestThread::run);
        t1.start();

        try{
            Thread.sleep(5000);
            System.out.println("main wake up");
        }catch (InterruptedException ie){
            System.out.println("interrupt exception");
        }

        t1.interrupt();

    }

    public static void run(){

        System.out.println("thread run");

        while(true){
            try{
                Thread.sleep(1000);
                System.out.println("I am wake up");
            }catch (InterruptedException ie){
                System.out.println("interrupt exception");
                return;
            }
        }
    }
}
