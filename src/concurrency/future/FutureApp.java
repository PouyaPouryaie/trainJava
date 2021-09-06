package concurrency.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FutureApp {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        SampleFuture sampleFuture = new SampleFuture();
        Future<String> stringFuture = sampleFuture.calculateSync();

        System.out.println("i am waiting");

        String result = null;
        try {
            result = stringFuture.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);

        // use async
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> future = completableFuture.thenApply(s -> s + " world");
        System.out.println(future.get());

        //parallel
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        System.out.println(combined);
    }
}
