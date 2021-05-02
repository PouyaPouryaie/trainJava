package reactivetrain.RxJava.concurrencyandparallization;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * same as computation but as you want you can get thread
 */
public class IoScheduler {

    public static void main(String[] args) throws InterruptedException{

        @NonNull Observable<String> src = Observable.just("pizza", "pasta", "fires", "curry", "chown mein")
                .subscribeOn(Schedulers.io());


        src.subscribe(e -> ioOperation());
        src.subscribe(e -> ioOperation());
        src.subscribe(e -> ioOperation());
        src.subscribe(e -> ioOperation());
        src.subscribe(e -> ioOperation());

        Thread.sleep(30000);
    }

    public static void ioOperation() throws InterruptedException{

        Thread.sleep(1000);
        System.out.println("computation Done by: " + Thread.currentThread().getName());
    }
}
