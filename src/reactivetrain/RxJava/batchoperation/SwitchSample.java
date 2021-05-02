package reactivetrain.RxJava.batchoperation;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * emit original data then call source, so base on time of original and source,
 * source can be print some of data, and then original emit new data
 */
public class SwitchSample {

    public static void main(String[] args) throws InterruptedException{

        @NonNull Observable<String> source = Observable
                .just("John", "Lily", "Emma", "Reyan", "Darshin")
                .concatMap(e ->
                    Observable.just(e)
                            .delay(ThreadLocalRandom.current().nextInt(1000), TimeUnit.MILLISECONDS)
                    );

        Observable.interval(1, TimeUnit.SECONDS)
                .switchMap(e -> source)
                .subscribe(System.out::println);

        Thread.sleep(10000);

    }
}
