package reactivetrain.RxJava.basic;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

/**
 * convert cold observable to hot observable
 */
public class ConnectableFeature {

    public static void main(String[] args) throws InterruptedException {
        @NonNull ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();

        //for start observable
        source.connect();

        Thread.sleep(2000);

        source.subscribe(aLong -> System.out.println("source 1 data is : " + aLong));

        Thread.sleep(3000);

        source.subscribe(aLong -> System.out.println("source 2 data is : " + aLong));

        Thread.sleep(5000);
    }
}
