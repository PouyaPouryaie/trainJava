package reactivetrain.RxJava.combining;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class MergeAndConcat {

    public static void main(String[] args) throws InterruptedException {

        //@NonNull Observable<String> src1 = Observable.just("Ella", "Alexa", "Lily");
        //@NonNull Observable<String> src2 = Observable.just("Priya", "Chloe");

        @NonNull Observable<String> src1 = Observable
                .interval(1, TimeUnit.SECONDS).take(8)
                .map(e -> "src1: " + e);
        @NonNull Observable<String> src2 = Observable
                .interval(100, TimeUnit.MILLISECONDS)
                .map(e -> "src2: " + e);

        // first solution
/*        Observable.merge(src1, src2)
                .subscribe(e -> System.out.println("merge: " + e));

        Observable.concat(src1, src2)
                .subscribe(e -> System.out.println("concat: " + e));*/

        // second solution
        src1.concatWith(src2)
                .subscribe(e -> System.out.println("concatWith: " + e));

        Thread.sleep(15000);
    }
}
