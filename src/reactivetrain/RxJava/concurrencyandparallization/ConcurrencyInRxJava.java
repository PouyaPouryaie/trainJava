package reactivetrain.RxJava.concurrencyandparallization;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

/**
 * how receive async in rxjava
 */
public class ConcurrencyInRxJava {

    public static void main(String[] args) {

        @NonNull Observable<Object> observable = Observable.create(emitter -> {
            new Thread(() -> {
                emitter.onNext("pouya");
                emitter.onNext("hasan");
            }).start();
        });

        observable.subscribe( e-> System.out.println("view 1: " + e + " thread is : " + Thread.currentThread().getName()));
        observable.subscribe( e-> System.out.println("view 2: " + e + " thread is : " + Thread.currentThread().getName()));
    }
}
