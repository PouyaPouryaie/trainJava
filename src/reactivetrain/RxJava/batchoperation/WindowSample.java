package reactivetrain.RxJava.batchoperation;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * difference between window and window is return type, window return observable
 * but window return collection of data
 */
public class WindowSample {

    public static void main(String[] args) throws InterruptedException{

        Observable.range(1, 30)
                .window(5)
                .flatMap(e -> e)
                .subscribe(System.out::println);

        System.out.println();

        Observable.range(1, 30)
                .window(5, 7)
                .flatMap(e -> e)
                .subscribe(System.out::println);

        System.out.println();

        Observable.interval(50, TimeUnit.MILLISECONDS)
                .window(1, TimeUnit.SECONDS, 5) //time interval with maximum size of window
                .flatMap(e -> e)
                .subscribe(System.out::println);

        System.out.println();

        //observable as boundary Indicator
        @NonNull Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);

        Observable.interval(30, TimeUnit.MILLISECONDS)
                .window(interval)
                .flatMap(e -> e)
                .subscribe(e -> System.out.println("data receive is: " + e));

        Thread.sleep(10000);
    }
}
