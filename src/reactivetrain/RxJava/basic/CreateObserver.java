package reactivetrain.RxJava.basic;

import io.reactivex.rxjava3.core.Observable;

public class CreateObserver {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("hello", "world", "?");

        observable.subscribe(s -> System.out.println(s),
                Throwable::printStackTrace,
                () -> System.out.println("completed"));

        System.out.println();

        // if you are infinite data
        observable.subscribe(s -> System.out.println(s), Throwable::printStackTrace);

        System.out.println();

        // basic model
        observable.subscribe(s -> System.out.println(s));

        // this is anonymous created
/*        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };*/
    }
}
