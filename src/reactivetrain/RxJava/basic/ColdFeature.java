package reactivetrain.RxJava.basic;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class ColdFeature {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        Observable<Integer> source = Observable.fromIterable(list);
        source.subscribe(System.out::println);

        list = getData(list);

        source.subscribe(System.out::println);
    }

    private static List<Integer> getData(List<Integer> list){
        list.add(19);
        return list;
    }

}
