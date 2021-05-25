package reactivetrain;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws InterruptedException {

        @NonNull Observable<String> observable1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(e -> "observer1: " + e);

        @NonNull Observable<String> observable2 = Observable.interval(500, TimeUnit.MILLISECONDS)
                .map(e -> "observer2: " + e);

        @NonNull Subject<Object> publishSubject = PublishSubject.create();

        publishSubject.subscribe(System.out::println);

        observable1.subscribe(publishSubject);
        observable2.subscribe(publishSubject);
        publishSubject.onNext("pouya");
        Thread.sleep(10000);
    }
}
