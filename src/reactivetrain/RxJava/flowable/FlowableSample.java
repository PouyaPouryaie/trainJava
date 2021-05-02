package reactivetrain.RxJava.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;

public class FlowableSample {

    public static void main(String[] args) {

        Flowable.range(1, 10000)
                .map(e -> {
                    System.out.println("publish data is: " + e + " ThreadName: " + Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<Integer>() {

                    Subscription subscription;
                    AtomicInteger count = new AtomicInteger(0);

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        System.out.println("subscribe for 20 items");
                        this.subscription.request(20);
                    }

                    @Override
                    public void onNext(Integer integer) {

                        if(count.getAndIncrement() % 20 == 0){
                            System.out.println("subscriber need 20 item again");
                            this.subscription.request(20);
                        }

                        System.out.println("subscriber data is: " + integer);

                        sleep(100);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("mission done");
                    }
                });

        sleep(100000);
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
