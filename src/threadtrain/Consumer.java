package threadtrain;

public class Consumer extends Thread {

    private Buffer buffer;

    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        int data;
        while (true){
            data = buffer.consume();
        }
    }
}
