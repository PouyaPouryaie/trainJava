package reactivetrain.RxJava.multicast;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Caching {

    public static void main(String[] args) throws InterruptedException {
        @NonNull Observable<Long> cache = Observable.interval(1, TimeUnit.SECONDS)
                .cache();

        cache.map(e -> "reply data1 " + e).subscribe(System.out::println);

        Thread.sleep(5000);

        cache.map(e -> "reply data2 " + e).subscribe(System.out::println);

        Thread.sleep(5000);
    }
}