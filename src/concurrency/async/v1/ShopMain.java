package concurrency.async.v1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ShopMain {

    public static void main(String[] args){

        Shop shop = new Shop("BestShop");

        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getAsyncPrice("my Favorite Product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation return after " + invocationTime + " msecs");

        doSomethingElse();

        try{
            double price = futurePrice.get();
            System.out.printf("price is %.2f%n", price);
        }catch (ExecutionException | InterruptedException e){
            throw new RuntimeException();
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    private static void doSomethingElse() {
        System.out.println("Doing something else ...");
    }
}
