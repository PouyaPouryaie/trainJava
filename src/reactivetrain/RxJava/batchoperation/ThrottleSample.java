package reactivetrain.RxJava.batchoperation;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * this model drop some data based on time, or inactivate system
 * throttleFirst,throttleLast,throttleWithTimeout
 */
public class ThrottleSample {

    public static void main(String[] args) {

        @NonNull Observable<Object> src1 = Observable.create(
                emitter -> {
                    emitter.onNext("A");
                    Thread.sleep(200);

                    emitter.onNext("B");
                    Thread.sleep(100);

                    emitter.onNext("C");
                    Thread.sleep(400);

                    emitter.onNext("D");
                    Thread.sleep(300);

                    emitter.onNext("E");
                    Thread.sleep(800);

                    emitter.onNext("F");
                    Thread.sleep(900);

                    emitter.onNext("X");
                    Thread.sleep(600);

                    emitter.onNext("Y");
                    Thread.sleep(1000);

                    emitter.onNext("Z");

                    emitter.onComplete();
                }
        );

        src1
                //.throttleFirst(1000, TimeUnit.MILLISECONDS)
                //.sample(1000, TimeUnit.MILLISECONDS) // throttleLast
                .debounce(700, TimeUnit.MILLISECONDS) //throttleWithTimeout
                .subscribe(
                item -> System.out.println(item),
                Throwable::printStackTrace,
                () -> System.out.println("Completed")
        );
    }
}
