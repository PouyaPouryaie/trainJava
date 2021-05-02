package reactivetrain.RxJava.concurrencyandparallization;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ComputationScheduler {

    public static void main(String[] args) throws InterruptedException{

        @NonNull Observable<String> src = Observable.just("pizza", "pasta", "fires", "curry", "chown mein")
                .subscribeOn(Schedulers.computation());


        src.subscribe(e -> {
            System.out.println("src1: " + e);
            compute();
        });
        src.subscribe(e -> {
            System.out.println("src2: " + e);
            compute();
        });
        src.subscribe(e -> {
            System.out.println("src3: " + e);
            compute();
        });
        src.subscribe(e -> {
            System.out.println("src4: " + e);
            compute();
        });
        src.subscribe(e -> {
            System.out.println("src5: " + e);
            compute();
        });

//        src.subscribe(e -> compute());
//        src.subscribe(e -> compute());
//        src.subscribe(e -> compute());
//        src.subscribe(e -> compute());
//        src.subscribe(e -> compute());

        Thread.sleep(30000);
    }

    public static void compute() throws InterruptedException{

        Thread.sleep(1000);
        System.out.println("computation Done by: " + Thread.currentThread().getName());
    }
}
