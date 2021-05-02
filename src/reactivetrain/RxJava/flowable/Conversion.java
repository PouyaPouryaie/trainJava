package reactivetrain.RxJava.flowable;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * you can leverage between flowable and observable with toObservable or toFlowable(backpressure)
 *
 * when flowable convert to observable, which no need backpressure
 */
public class Conversion {

    public static void main(String[] args) throws InterruptedException {
        Observable.range(1, 50000)
                .toFlowable(BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.io())
                .subscribe(e -> System.out.println(e + " " + Thread.currentThread().getName()));

        Thread.sleep(10000);
    }
}
