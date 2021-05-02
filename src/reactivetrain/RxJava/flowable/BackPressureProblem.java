package reactivetrain.RxJava.flowable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class BackPressureProblem {

    public static void main(String[] args) {

        Observable.range(1, 10000)
                .map(e -> {
                    sleep(10);
                    System.out.println("data is: " + e + " ThreadName: " + Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                .subscribe(e ->{
                    sleep(300);
                    System.out.println("data is: " + e + " ThreadName: " + Thread.currentThread().getName());
                });

        sleep(100000);
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
