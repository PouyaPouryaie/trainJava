package concurrency.future;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SampleFuture {

    public Future<String> calculateSync() {
        CompletableFuture<String> completableFuture = new CompletableFuture();

        Executors.newCachedThreadPool().submit(() -> {
           Thread.sleep(5000);
           completableFuture.complete(doWork("hello"));
           return null;
        });

        return completableFuture;
    }

    private String doWork(String message){
        return LocalDateTime.now() + ", message is " + message;
    }
}
