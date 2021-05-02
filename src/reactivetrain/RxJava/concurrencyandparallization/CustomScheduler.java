package reactivetrain.RxJava.concurrencyandparallization;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomScheduler {

    public static void main(String[] args) throws InterruptedException{

        ExecutorService executorService = Executors
                .newFixedThreadPool(20);

        Scheduler scheduler = Schedulers.from(executorService);

        @NonNull Observable<String> src = Observable.just("pizza", "pasta", "fires", "curry", "chown mein")
                .subscribeOn(scheduler)
                .doFinally(executorService::shutdown);


        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());

    }

    public static void compute() throws InterruptedException{

        Thread.sleep(1000);
        System.out.println("computation Done by: " + Thread.currentThread().getName());
    }
}
