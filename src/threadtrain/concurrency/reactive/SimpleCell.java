package threadtrain.concurrency.reactive;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.function.Consumer;

public class SimpleCell implements Publisher<Integer>, Subscriber<Integer> {

    private int value = 0;
    private String name;
    private List<Subscriber<? super Integer>> subscribers = new ArrayList<>();


    public SimpleCell(String name){this.name = name;}

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        subscribers.add(subscriber);
    }

    public void subscribe(Consumer<? super Integer> consumer){
        subscribers.add(new Subscriber<>() {
            @Override
            public void onSubscribe(Subscription subscription) {

            }

            @Override
            public void onNext(Integer item) {
                consumer.accept(item);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onNext(Integer newValue) {
        value = newValue;
        System.out.println(name + ": " + value);
        notifyAllSubscribers();
    }

    private void notifyAllSubscribers(){
        subscribers.forEach(subscriber -> subscriber.onNext(value));
    }

    @Override
    public void onSubscribe(Subscription subscription) {

    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {

    }
}
