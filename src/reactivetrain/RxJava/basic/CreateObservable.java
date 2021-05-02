package reactivetrain.RxJava.basic;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateObservable {

    public static void main(String[] args) {

        /**
         * all method:
         * create, just, fromIterable, range(s,e), interval(time, unit),
         * future, empty, never, error, defer(supplier), fromCallable
         */

        // create method
        Observable<Integer> source = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        });

        source.subscribe(System.out::println);

        // just method
        Observable<Integer> just = Observable.just(10,20,30);
        just.subscribe(System.out::println);

        // from Iterable
        List<Integer> list = List.of(100,200, 300);
        Observable<Integer> listObserve = Observable.fromIterable(list);
        listObserve.subscribe(System.out::println);

        // from range
        Observable.range(3,10).subscribe(System.out::println);

        // interval : this need run in separate thread, and need main thread to sleep
        Observable.interval(2, TimeUnit.SECONDS).subscribe(System.out::println);

        // defer : create separate state for each observer
        List<String> list1 = new ArrayList<>();
        list1.add("pouya"); list1.add("ali");
        Observable<String> sourceDiffer = Observable.defer(() -> Observable.fromIterable(list1));
        sourceDiffer.subscribe(System.out::println);
        list1.add("hasan");
        sourceDiffer.subscribe(System.out::println);
    }
}