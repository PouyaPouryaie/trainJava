package reactivetrain.RxJava.combining;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import reactivetrain.RxJava.operators.Employee;

public class Grouping {

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

        source.groupBy(employee -> employee.getRating())
                .flatMapSingle(e -> e.toMultimap(keyEmployee -> e.getKey(), valueEmployee -> valueEmployee.getName()))
                .subscribe(System.out::println);

        System.out.println();

        source.groupBy(employee -> employee.getRating())
                .flatMapSingle(e -> e.toList())
                .subscribe(System.out::println);
    }
}
