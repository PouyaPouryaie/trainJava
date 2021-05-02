package reactivetrain.RxJava.combining;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * ambiguous: if multi source send same data and you need faster data
 */
public class Ambiguous {

    public static void main(String[] args) throws InterruptedException {

        @NonNull Observable<String> src1 = Observable.interval(1, TimeUnit.SECONDS).take(10)
                .map(a -> "src1: " + a);
        @NonNull Observable<String> src2 = Observable.interval(1000, TimeUnit.MILLISECONDS).take(10)
                .map(a -> "src2: " + a);


        // first solution
        Observable.amb(Arrays.asList(src1, src2))
                .subscribe(System.out::println);

        // second solution
        src1.ambWith(src2)
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }
}
