package reactivetrain.RxJava.operators;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.List;

/**
 * suppressing: filter,take, skip, distinct, elementAt
 * transforming: map, cast, scan, delay, sorted, repeat, delaySubscription
 * reduce: count, reduce, contains, all, any
 * collection: toList (Single), toSortedList, toMap, collect
 * ErrorRecovery: OnErrorReturnItem, onErrorReturn, onErrorResumeNext, retry
 * Action: doOnNext, doOnError, doOnSubscribe, doOnComplete
 */

public class OperatorsSample {

    public static void main(String[] args) {

        @NonNull Observable<Employee> source = Observable.just(
                new Employee(101, "Alexa", 60000, 4.0),
                new Employee(102, "Donald", 94000, 4.7),
                new Employee(103, "Pit", 65000, 4.0),
                new Employee(104, "Sam", 85000, 4.4),
                new Employee(105, "Joy", 50000, 3.6),
                new Employee(106, "Joly", 85000, 4.5),
                new Employee(107, "Jan", 60000, 4.0),
                new Employee(108, "Marry", 940000, 4.7),
                new Employee(109, "Mona", 75000, 4.3)
        );

        source
                .filter(employee -> employee.getRating()>4.0)
                .sorted((o1, o2) -> Double.compare(o2.getRating(), o1.getRating()))
                .map(e -> e.getName())
                .take(4)
                .toList()
                .subscribe(System.out::println);

        List<Integer> list = List.of(200, 500, 300, 250, 340, 190, 234, 999, 1030, 3400, 996, 789, 251);

        Observable.fromIterable(list)
                //.scan((a, b) -> a + b)
                .reduce(Integer::sum)
                .subscribe(System.out::println);

    }
}
