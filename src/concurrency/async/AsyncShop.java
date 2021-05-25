package concurrency.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class AsyncShop {

    private final String name;
    private final Random random;

    public AsyncShop(String name){
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getName(){return name;}

    public double calculatePrice(String product) {
        Utils.delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public Future<Double> getPrice(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }
}
