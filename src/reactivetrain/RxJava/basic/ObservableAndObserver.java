package reactivetrain.RxJava.basic;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class ObservableAndObserver {
    public static void main(String[] args) {

        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                emitter.onNext(100);
                emitter.onNext(200);
                emitter.onComplete();
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("I am subscribe");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("data is: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("data has error");
            }

            @Override
            public void onComplete() {
                System.out.println("data completed");
            }
        };

        observable.subscribe(observer);
    }
}
