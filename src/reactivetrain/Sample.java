package reactivetrain;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
this sample show the basic concept of reactive
 reactive programming == functionalProgramming + async OR sync + backpressure + three channels of communication
 */

public class Sample {

    public static void main(String[] args) {

        Flowable.<Integer>create(emitter -> emit(emitter), BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.io(), true, 2) //for async
                .filter(data -> data % 2 == 0)
                .map(data -> data * 2)
                .subscribe(Sample::process,
                        err -> System.out.println("Error: " + err),
                        () -> System.out.println("Done"));

        System.out.println("let move forward");
    }

    private static void process(Integer data) {
        System.out.println(data);
        sleep(1000);
    }

    private static void emit(FlowableEmitter<Integer> emitter) {

        System.out.println("starting ... ");
        int count = 0;

        while (++count < 10){
            System.out.println("emitting... " + count);
            emitter.onNext(count);
            sleep(500);
        }

        emitter.onComplete();
    }

    private static boolean sleep(int duration){
        try {
            Thread.sleep(duration);
            return true;
        } catch (InterruptedException e) {
           return false;
        }
    }
}
