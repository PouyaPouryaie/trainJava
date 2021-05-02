package reactivetrain.RxJava.concurrencyandparallization;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * get you an option to task run sync
 */
public class SingleScheduler {

    public static void main(String[] args) throws InterruptedException{

        @NonNull Observable<String> src = Observable.just("pizza", "pasta", "fires", "curry", "chown mein")
                .subscribeOn(Schedulers.single());


        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());

        Thread.sleep(30000);
    }

    public static void sensitiveTask() throws InterruptedException{

        Thread.sleep(1000);
        System.out.println("computation Done by: " + Thread.currentThread().getName());
    }
}
