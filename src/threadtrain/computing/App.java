package threadtrain.computing;

import java.util.Arrays;
import java.util.Random;


/**
 * show how to use multi thread and stream for computing sum of number in array
 */
public class App {


    public static void main(String[] args){

        Random random = new Random();
        long[] array = random.longs(1000000, 1,1000).toArray();

        long[] array1 = new long[250000];
        long[] array2 = new long[250000];
        long[] array3 = new long[250000];
        long[] array4 = new long[250000];

        System.arraycopy(array, 0, array1, 0, array1.length);
        System.arraycopy(array, 250000, array2, 0, array2.length);
        System.arraycopy(array, 500000, array3, 0, array3.length);
        System.arraycopy(array, 750000, array4, 0, array4.length);

        /**
         * thread section
         */
        ComputingSum computingSum1 = new ComputingSum("c1", array1, new SumResult());
        ComputingSum computingSum2 = new ComputingSum("c2", array2, new SumResult());
        ComputingSum computingSum3 = new ComputingSum("c3", array3, new SumResult());
        ComputingSum computingSum4 = new ComputingSum("c4", array4, new SumResult());

        Thread t1 = new Thread(computingSum1::sum);
        Thread t2 = new Thread(computingSum2::sum);
        Thread t3 = new Thread(computingSum3::sum);
        Thread t4 = new Thread(computingSum4::sum);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();

        }catch (InterruptedException e){
            e.printStackTrace();
        }

        long total = computingSum1.getSumResult().getResult() +
                computingSum2.getSumResult().getResult() +
                computingSum3.getSumResult().getResult() +
                computingSum4.getSumResult().getResult();

        System.out.println("result of thread total : " + total);


        /**
         * stream section
         */
        long streamSum = Arrays.stream(array).parallel().sum();
        System.out.println("result of stream is : " + streamSum);


        System.out.println("we are done");

    }
}
