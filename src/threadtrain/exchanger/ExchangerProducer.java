package threadtrain.exchanger;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class ExchangerProducer extends Thread {

    private Exchanger<ArrayList<Integer>> exchanger;
    private ArrayList<Integer> buffer = new ArrayList<>();
    private int bufferLimit;
    private Random random = new Random();
    private int currentValue = 0;

    public ExchangerProducer(Exchanger<ArrayList<Integer>> exchanger, int bufferLimit) {
        this.exchanger = exchanger;
        this.bufferLimit = bufferLimit;
    }

    @Override
    public void run(){

        while (true){
            try{
                System.out.println("Producer is filling the buffer with data...");
                int sleepTime = random.nextInt(20) + 1;
                Thread.sleep(sleepTime * 1000);

                this.fillBuffer();
                System.out.println("Producer has produced:" + buffer);

                System.out.println("Producer is waiting to exchange the data...");
                buffer = exchanger.exchange(buffer);

            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public void fillBuffer(){
        for(int i = 1; i <= bufferLimit; i++){
            buffer.add(++currentValue);
        }
    }
}
