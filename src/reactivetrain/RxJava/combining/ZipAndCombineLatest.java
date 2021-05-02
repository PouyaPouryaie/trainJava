package reactivetrain.RxJava.combining;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * zip have same speed for combine together, but combineLatest combine with any order
 */
public class ZipAndCombineLatest {

    public static void main(String[] args) throws InterruptedException {

        @NonNull Observable<Long> src1 = Observable.interval(1, TimeUnit.SECONDS);
        @NonNull Observable<Long> src2 = Observable.interval(100, TimeUnit.MILLISECONDS);

/*        Observable.zip(src1, src2, (aLong, aLong2) -> "source1: " + aLong + " source2: " + aLong2)
                .subscribe(System.out::println);*/

        Observable.combineLatest(src1, src2, (aLong, aLong2) -> "source1: " + aLong + " source2: " + aLong2)
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }
}
