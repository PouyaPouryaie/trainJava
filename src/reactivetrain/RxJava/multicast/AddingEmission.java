package reactivetrain.RxJava.multicast;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

/**
 * use subject for manually emission data
 * because subject is not thread safe and in multi thread may be not
 * work sequential, so suggest to use toSerialized
 */
public class AddingEmission {

    public static void main(String[] args) {

        @NonNull PublishSubject<Object> src = PublishSubject.create();

        @NonNull Subject<Object> serialized = src.toSerialized(); // this is thread safe

        serialized.subscribe(System.out::print);

        serialized.onNext("hello ");
        serialized.onNext("world ");

        serialized.subscribe(e -> System.out.println("\ndata 2 is " + e));

        serialized.onNext("pouya");
        serialized.onComplete();

    }
}
