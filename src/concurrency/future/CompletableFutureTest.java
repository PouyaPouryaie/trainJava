package concurrency.future;

import java.util.concurrent.*;

public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException{

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //future limitations
//        Future<String> stringFuture = executorService.submit(CompletableFutureTest::neverEndingComputation);
//        System.out.println("The result is: " + stringFuture.get());

        //CompletableFuture
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> neverEndingComputation());
        completableFuture.completeOnTimeout("this is complete data", 2, TimeUnit.SECONDS);
        System.out.println("data is: " + completableFuture.get());
        System.out.println("Is the CompletableFuture done? " + completableFuture.isDone());

        /**
         * ~~~~~ combineAsync ~~~~~~~~
         * We are using the method supplyAsync() of the CompletableFuture class which returns a new CompletableFuture
         * that is asynchronously completed by a task running in the ForkJoinPool.commonPool() with the value obtained
         * by calling the given Supplier
         */
        var combineResult = CompletableFuture.supplyAsync(
                CompletableFutureTest::getFirstString)
                .thenApply(s -> getSecondString(s));

        System.out.println(combineResult.get());

        //Reacting to Completion Without Blocking the Thread
        CompletableFuture.supplyAsync(() -> "this is first sentences")
                .thenApply(String::toUpperCase)
                .thenAccept(System.out::println);
    }

    static String getFirstString(){
        return "first";
    }

    static String getSecondString(String first){
        return first + " second";
    }

    static String neverEndingComputation(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "is done";
    }
}
