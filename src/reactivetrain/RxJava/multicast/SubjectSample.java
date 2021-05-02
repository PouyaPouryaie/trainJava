package reactivetrain.RxJava.multicast;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

/**
 * subject use as observable and observer, so can multi observable subscribe into subject and
 * subject emit data for another subscriber
 * multi observer and multi observable
 * this async behaviour
 */
public class SubjectSample {

    public static void main(String[] args) throws InterruptedException {


        @NonNull Observable<Integer> src1 = Observable.just(10, 20, 30, 40)
                .subscribeOn(Schedulers.computation());
        @NonNull Observable<Integer> src2 = Observable.just(60, 70, 80, 90)
                .subscribeOn(Schedulers.computation());

        @NonNull Subject<Object> subjectSrc = PublishSubject.create();

        subjectSrc.subscribe(e -> System.out.println(e));
        subjectSrc.onNext("hello");

        src1.subscribe(subjectSrc);
        src2.subscribe(subjectSrc);

        Thread.sleep(5000);

    }
}
