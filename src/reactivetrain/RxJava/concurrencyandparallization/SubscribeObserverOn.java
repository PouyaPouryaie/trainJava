package reactivetrain.RxJava.concurrencyandparallization;

import io.reactivex.rxjava3.core.Observable;

import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * how change schedulers based on task we want doing,
 * this model position of subscribeOn and observerOn is matter.
 * we use observerOn for change scheduler.
 * upstream before observerOn not impact with it, but all of downstream is effected
 */
public class SubscribeObserverOn {

    public static void main(String[] args) throws InterruptedException {

        Observable.just("Pizza", "Pasta", "Fires", "Curry", "Chow mein")
                .subscribeOn(Schedulers.computation())
                .map( e -> e.toUpperCase())
                .doOnNext(e -> System.out.println(Thread.currentThread().getName()))
                .observeOn(Schedulers.newThread())
                .filter( e -> e.startsWith("P"))
                .doOnNext(e -> System.out.println(Thread.currentThread().getName()))
                .observeOn(Schedulers.io())
                .subscribe(e -> print(e));

        Thread.sleep(60000);

    }

    public static void print(String element){
        System.out.println(element + " Printed by " + Thread.currentThread().getName());
    }
}
