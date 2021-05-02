package concurrency.async.v1;

import concurrency.async.ExchangeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BestPriceFinder {

    private final List<Shop> shops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("MyFavoriteShop"),
            new Shop("ShopEasy"),
            new Shop("BuyItAll"),
            new Shop("BestEasy2")
    );


    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(),100),(Runnable r)->{
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    public List<String> findPricesSequential(String product){
        return shops.stream()
                .map(shop -> shop.getName() + " price is " + shop.getPrice(product))
                .collect(Collectors.toList());
    }

    public List<String> findPricesParallel(String product){
        return shops.parallelStream()
                .map(shop -> shop.getName() + " price is " + shop.getPrice(product))
                .collect(Collectors.toList());
    }

    public List<String> findPricesFuture(String product){

        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getName() + " price is " + shop.getPrice(product),executor))
                        .collect(Collectors.toList());

        List<String> prices = priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        return prices;
    }

    public List<String> findPriceInUSD(String product){
        List<CompletableFuture<Double>> priceFutures = new ArrayList<>();

        for(Shop shop:shops) {
            CompletableFuture<Double> futurePriceInUSD =
                    CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                    .thenCombine(
                            CompletableFuture.supplyAsync(
                                    () -> ExchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.USD))
                                    .completeOnTimeout(
                                            ExchangeService.DEFAULT_RATE, 1, TimeUnit.SECONDS), (price, rate) -> price * rate)
                    .orTimeout(3, TimeUnit.SECONDS);
            priceFutures.add(futurePriceInUSD);
        }

        List<String> prices = priceFutures.stream()
                .map(CompletableFuture::join)
                .map(price -> "price is " + price)
                .collect(Collectors.toList());
        return prices;
    }
}
