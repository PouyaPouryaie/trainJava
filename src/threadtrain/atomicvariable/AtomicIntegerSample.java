package threadtrain.atomicvariable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerSample {

    static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {

        //sample1: accumulate
        System.out.println("accumulate");
        AtomicInteger a1 = new AtomicInteger(4);
        System.out.println(a1.accumulateAndGet(2, (x,y) -> x * y));
        System.out.println(a1.getAndAccumulate(4, (x,y) -> x + y));
        System.out.println(a1.get());

        //sample2: update
        System.out.println("update");
        AtomicInteger a2 = new AtomicInteger(10);
        a2.updateAndGet( x -> x * 2);
        a2.getAndUpdate(x -> x + 5);
        System.out.println(a2.get());

        //sample3: compare
        System.out.println("compareAndExchange");
        AtomicInteger a = new AtomicInteger(0);
        for (int i=0; i<9; ++i)
        {
            a.updateAndGet(x -> x + 10);
            a.compareAndExchange(50,0);
            System.out.println(a.get());
        }

        //sample4: Array
        System.out.println("AtomicArray");
        int array_size = 4;
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array_size);

        for(int i=0; i < 4; i++){
            System.out.println( i + ": " + atomicIntegerArray.accumulateAndGet(i, i, (x,y) -> x + 2*y));
        }

        //compare in multi thread
        System.out.println("compareAndSet");
        AtomicInteger a4 = new AtomicInteger(0);
        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(
                () -> {
                    int x = a4.get();
                    for(int i=0; i < 20 ; i++){

                        x = a4.updateAndGet(z -> z + 10);

                        if(a4.compareAndSet(100, 0)){
                            System.out.println("cf1 resets atomic variable");
                            x = a4.get();
                        }

                        System.out.println("cf1 a = " + x);
                    }
                    return x;
                }
        );

        CompletableFuture<Integer> cf4 = CompletableFuture.supplyAsync(
                () -> {
                    int x = a4.get();
                    for(int i =0; i < 20; i++){
                        x = a4.updateAndGet(z -> z + 10);

                        if(a4.compareAndSet(80,0)){
                            System.out.println("cf2 resets atomic variable");
                            x = a4.get();
                        }

                        System.out.println("cf2 a = " + x);
                    }
                    return x;
                }
        );

        //CompletableFuture.allOf(cf3, cf4).join();

        //same value in multi thread
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(
                () -> {
                    for(int i=0; i < 10000; i++){
                        int x = num.addAndGet(10);
                        if (num.get() != (x+10))
                            System.out.println("cf1 THREAD READ: x= "
                                    + x +" num= " + num);
                    }
                    return num.get();
                }
        );

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(
                () -> {
                    for(int i=0; i < 10000; i++){
                        int x = num.addAndGet(-10);
                        if (num.get() != (x-10))
                            System.out.println("cf2 THREAD READ: x= "
                                    + x +" num= " + num);
                    }

                    return num.get();
                }
        );

        //CompletableFuture.allOf(cf1, cf2).join();
    }
}
