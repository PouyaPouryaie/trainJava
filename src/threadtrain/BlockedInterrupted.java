package threadtrain;

public class BlockedInterrupted {

    public static void main(String[] args){

        Thread t = new Thread(BlockedInterrupted::run);
        t.start();

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println("main intrrupt");
        }

        t.interrupt();
    }

    public static void run(){
        int count  = 1;
        while(true){
            try{

                Thread.sleep(1000);
                System.out.println("counter is " + count++);
            }catch(InterruptedException e){
                System.out.println("I got Interrupt !");
                return;
            }
        }
    }
}
