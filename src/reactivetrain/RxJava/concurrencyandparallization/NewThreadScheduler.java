package reactivetrain.RxJava.concurrencyandparallization;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * this scheduler terminate thread after complete task.
 */
public class  NewThreadScheduler {

    public static void main(String[] args) throws InterruptedException{

        @NonNull Observable<String> src = Observable.just("pizza", "pasta", "fires", "curry", "chown mein")
                .subscribeOn(Schedulers.newThread());


        src.subscribe(e -> task());

        Thread.sleep(6000); // because newThread not use thread pool, so thread is not back for reuse

        src.subscribe(e -> task());
        src.subscribe(e -> task());
        src.subscribe(e -> task());
        src.subscribe(e -> task());

        Thread.sleep(30000);
    }

    public static void task() throws InterruptedException{

        Thread.sleep(1000);
        System.out.println("computation Done by: " + Thread.currentThread().getName());
    }
}
