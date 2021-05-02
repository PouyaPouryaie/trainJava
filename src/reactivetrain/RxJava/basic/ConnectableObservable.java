package reactivetrain.RxJava.basic;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * connectableObservable can cold observable change to hot observable
 * all observer connect to one observable, so observer can't get data from scratch
 */
public class ConnectableObservable {

    public static void main(String[] args) throws InterruptedException {
        io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<Long> source =
                Observable.interval(1, TimeUnit.SECONDS).publish();

        // this for start observable and fire emitter
        source.connect();

        source.subscribe(System.out::println);

        Thread.sleep(10000);

        source.subscribe(System.out::println);

        Thread.sleep(10000);
    }
}
