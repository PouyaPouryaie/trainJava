package reactivetrain.RxJava.multicast;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.*;

import java.util.concurrent.TimeUnit;

/**
 * publishSubject
 * ReplaySubject
 * BehaviorSubject
 * AsyncSubject
 * unicastSubject
 */
public class SubjectTypeSample {

    public static void main(String[] args) throws InterruptedException {
        //publish : emission data from point you subscribe
        //@NonNull Subject<Object> src = PublishSubject.create();

        //replay : subscribe all data
        //@NonNull Subject<Object> src = ReplaySubject.create();

        //behavior : subscribe from most recently data before emission
        //@NonNull Subject<Object> src = BehaviorSubject.create();

        //async : just last data show after onComplete, so do not use for infinite
        @NonNull Subject<Object> src = AsyncSubject.create();

        src.subscribe(e -> System.out.println("client1: " + e));
        src.onNext("a");
        src.onNext("b");
        src.onNext("c");

        src.subscribe(e -> System.out.println("client2: " + e));

        src.onNext("d");
        src.onNext("e");
        src.onComplete();

        //unicast : buffered data, and when subscribe observer send all data buffered, must be single observer
        @NonNull Subject<Object> subject = UnicastSubject.create();

        Observable.interval(500, TimeUnit.MILLISECONDS)
                .subscribe(subject);

        Thread.sleep(2000);

        subject.subscribe(System.out::println);
        Thread.sleep(2000);
    }
}
