package threadtrain;

public class JoinRight {

    public static void main(String[] args){

        Thread t1 = new Thread(JoinRight::print);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("we are done");
    }

    public static void print(){
        for(int i=0; i < 20; i++){
            System.out.println("count " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
