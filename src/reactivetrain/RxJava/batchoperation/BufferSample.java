package reactivetrain.RxJava.batchoperation;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class BufferSample {

    public static void main(String[] args) throws InterruptedException{

        Observable.range(1, 30)
                .buffer(5, HashSet::new)
                .subscribe(System.out::println);

        System.out.println();

        Observable.range(1, 30)
                .buffer(5, 7)
                .subscribe(System.out::println);

        System.out.println();

        Observable.interval(50, TimeUnit.MILLISECONDS)
                .buffer(1, TimeUnit.SECONDS, 5) //time interval with maximum size of buffer
                .subscribe(System.out::println);

        System.out.println();

        //observable as boundary Indicator
        @NonNull Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);

        Observable.interval(30, TimeUnit.MILLISECONDS)
                .buffer(interval)
                .subscribe(e -> System.out.println("data receive is: " + e));

        Thread.sleep(10000);
    }
}
