package reactivetrain.RxJava.variants;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

/**
 * single, maybe, completable
 */
public class VariantsObserver {

    public static void main(String[] args) {

        Observable<String> source = Observable.just("pouya", "alex","ali", "hamid");
        Observable<String> sourceEmpty = Observable.empty();

        source.filter(e -> e.startsWith("a"))
                .first("no Name")
                .subscribe(e -> System.out.println("the first name is " + e));


        Single.just(Observable.just("pouya", "hasan").toList()).subscribe(System.out::println);

        //maybe Sample
        sourceEmpty.firstElement()
                .subscribe(System.out::print, //onsuccess
                        Throwable::printStackTrace, // onError
                        () -> System.out.println("completed")); //done

        //completable
        Completable completable = Completable.complete();

        completable.subscribe(() -> System.out.println("done"));

        Completable.fromRunnable(() -> System.out.println("some process"))
                .subscribe(() -> System.out.println("return result"));

    }
}
