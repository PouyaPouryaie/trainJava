package reactivetrain.RxJava.basic;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class DisposableSample {

    //for dispose multi observable
    private static final CompositeDisposable disp = new CompositeDisposable();

    public static void main(String[] args) throws InterruptedException {

        //dispose one observable
        @NonNull Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        Disposable disposable = source.subscribe(e -> System.out.println("observer 1: " + e));

        Thread.sleep(3000);

        disposable.dispose();

        source.subscribe(e -> System.out.println("observer 2: " + e));

        Thread.sleep(10000);

        @NonNull Disposable dispose1 = source.subscribe(e -> System.out.println("observer 2-1: " + e));

        @NonNull Disposable dispose2 = source.subscribe(e -> System.out.println("observer 2-2: " + e));

        Thread.sleep(5000);

        disp.addAll(dispose1, dispose2);

        disp.dispose();

    }
}
