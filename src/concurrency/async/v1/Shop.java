package concurrency.async.v1;

import concurrency.async.Utils;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    private final String name;
    private final Random random;

    public Shop(String name){
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getName(){return name;}

    public double getPrice(String product){
        return calculatePrice(product);
    }

    public double calculatePrice(String product) {
        Utils.delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public Future<Double> getAsyncPrice(String product){
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                completableFuture.complete(price);
            }catch (Exception ex){
                completableFuture.completeExceptionally(ex);
            }
        }).start();
        return completableFuture;
    }
}
