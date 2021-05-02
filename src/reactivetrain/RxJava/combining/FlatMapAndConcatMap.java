package reactivetrain.RxJava.combining;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

/**
 * concatMap (have order)
 * flatMap
 */
public class FlatMapAndConcatMap {

    public static void main(String[] args) {

        List<String> strings = List.of("Hello", "Reactive", "Programming");

        Observable.fromIterable(strings)
                .flatMap(e -> Observable.fromArray(e.split("")))
                .reduce((a,b) -> a + b)
                .subscribe(System.out::println);
    }
}
