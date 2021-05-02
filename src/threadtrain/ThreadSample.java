package threadtrain;

public class ThreadSample {

    public static void main(String[] args){

        Thread thread1 = new Thread(ThreadSample::exe);
        Thread thread2 = new Thread(ThreadSample::exe);

        thread1.start();
        thread2.start();
    }

    public static void exe(){
        for(int i=0; i<100 ; i++){
            System.out.println("number is " + i*i);
        }
    }
}
