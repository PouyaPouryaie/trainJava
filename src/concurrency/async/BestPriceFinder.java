package concurrency.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BestPriceFinder {

    private final List<Shop> shops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("MyFavoriteShop"),
            new Shop("ShopEasy"),
            new Shop("BuyItAll"),
            new Shop("BestEasy2"),
            new Shop("BestEasy7"),
            new Shop("BestEasy6"),
            new Shop("BestEasy3"),
            new Shop("BestEasy4"),
            new Shop("BestEasy5")
    );


    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(),100),(Runnable r)->{
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    public List<String> findPricesSequential(String product){
        return shops.stream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    public List<String> findPricesParallel(String product){
        return shops.parallelStream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    public List<String> findPricesFuture(String product){

        List<CompletableFuture<String>> priceFutures = findPriceStream(product).collect(Collectors.<CompletableFuture<String>>toList());

        List<String> prices = priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        return prices;
    }

    public Stream<CompletableFuture<String>> findPriceStream(String product){
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product),executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote),executor)));
    }


    public void printPricesStream(String product){
        long start = System.nanoTime();
        CompletableFuture[] futures = findPriceStream(product)
                .map(f -> f.thenAccept(s -> System.out.println(s + " (done in " + ((System.nanoTime() - start) / 1_000_000) + " mescs)")))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
        System.out.println("All shops have now responded in " + ((System.nanoTime() - start)/ 1_000_000) + " mescs");
    }

    public void printPricesStream2(String product){
        long start = System.nanoTime();
        List<Void> futures = findPriceStream(product)
                .map(f -> f.thenAccept(s -> System.out.println(s + " (done in " + ((System.nanoTime() - start) / 1_000_000) + " mescs)")))
                .map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println("All shops have now responded in " + ((System.nanoTime() - start)/ 1_000_000) + " mescs");
    }
}
