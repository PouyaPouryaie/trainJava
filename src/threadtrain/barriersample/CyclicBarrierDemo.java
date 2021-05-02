package threadtrain.barriersample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private CyclicBarrier cyclicBarrier;
    private List<List<Integer>> partialResults = Collections.synchronizedList(new ArrayList<>());
    private Random random = new Random();
    private int THREAD_COUNT;
    private int LIST_COUNT;

    private void runSimulation(int threadCount, int listCount){
        THREAD_COUNT = threadCount;
        LIST_COUNT = listCount;

        cyclicBarrier = new CyclicBarrier(THREAD_COUNT, new AggregatorThread());
        System.out.println("spawning " + THREAD_COUNT + " worker threads to compute " + LIST_COUNT + " partial result each");
        for(int i = 0 ; i < THREAD_COUNT; i++){
            Thread worker = new Thread(new NumberCruncherThread());
            worker.setName("Thread " + i);
            worker.start();
        }

    }

    class NumberCruncherThread implements Runnable{

        @Override
        public void run() {
            String thisThreadName = Thread.currentThread().getName();
            List<Integer> partialResult = new ArrayList<>();
            for(int i = 0; i < LIST_COUNT; i++){
                Integer num = random.nextInt(10);
                System.out.println(thisThreadName + ": crunching some numbers! final result - " + num);
                partialResult.add(num);
            }
            partialResults.add(partialResult);
            try{
                System.out.println(thisThreadName + " waiting for others to reach barrier.");
                cyclicBarrier.await();
            }catch (InterruptedException | BrokenBarrierException e){
                e.printStackTrace();
            }
        }
    }


    class AggregatorThread implements Runnable{

        @Override
        public void run() {

            String thisThreadName = Thread.currentThread().getName();
            System.out.println(thisThreadName + " computing final sum of " + THREAD_COUNT + " workers, having " + LIST_COUNT + " result each.");
            int sum = 0;
            for(List<Integer> threadResult : partialResults){
                System.out.print("Adding ");
                for(Integer partialResult : threadResult){
                    System.out.print(partialResult + " ");
                    sum += partialResult;
                }
                System.out.println();
            }
            System.out.println(Thread.currentThread().getName() + ": final result is " + sum);
        }
    }

    public static void main(String[] args){
        CyclicBarrierDemo play = new CyclicBarrierDemo();
        play.runSimulation(5, 3);
    }

}
