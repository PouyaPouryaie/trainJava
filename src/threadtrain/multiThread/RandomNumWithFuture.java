package threadtrain.multiThread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class RandomNumWithFuture {

    public static void main(String[] args) {

        Callable<Integer> c1 = () -> (new Random()).nextInt(100);
        Runnable r = () -> System.out.println("Runnable");

        FutureTask<Integer> ft1 = new FutureTask<>(c1);
        FutureTask<Integer> ft2 = new FutureTask<>(r, -1);

        ft1.run();ft2.run();

        try{
            int i = ft1.get();
            int j = ft2.get();
            System.out.println(i + " " + j);
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }
    }
}
