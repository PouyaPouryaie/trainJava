package reactivetrain.RxJava.concurrencyandparallization;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.time.LocalTime;

/**
 * FlatMap for concurrency
 * how use flatmap for create observable for each emission and compute parallel and send concurrent
 */
public class FlatMapForConcurrency {
    public static void main(String[] args) throws InterruptedException {
//        Observable.just("Pizza", "Pasta", "Fries", "Curry", "Chow mein")
//                .map(e -> compute(e))
//                .subscribe(System.out::println);

        Observable.just("Pizza", "Pasta", "Fries", "Curry", "Chow mein")
                .flatMap(e -> Observable.just(e)
                        .subscribeOn(Schedulers.io())
                        .map(str -> compute(str)))
                .subscribe(System.out::println);

        Thread.sleep(7000);
    }

    public static String compute(String element) throws InterruptedException {
        Thread.sleep(1000);
        String result = element + " PrintedBy: " + Thread.currentThread().getName() + " at: " + LocalTime.now();
        return result;
    }
}
