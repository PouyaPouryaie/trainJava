package reactivetrain.RxJava.multicast;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/**
 * use for cache data and if subscribe new once, so send all previous data
 */
public class Replying {

    public static void main(String[] args) throws InterruptedException {

/*        @NonNull ConnectableObservable<Long> reply = Observable.interval(1, TimeUnit.SECONDS)
                .replay(3);  //number of data cache
          reply.connect();
                */

        @NonNull Observable<Long> autoConnectReply = Observable.interval(1, TimeUnit.SECONDS)
                .replay( 5,3, TimeUnit.SECONDS).autoConnect();

        @NonNull Disposable subDisposable = autoConnectReply.map(e -> "reply data1 " + e).subscribe(System.out::println);

        Thread.sleep(5000);

        subDisposable.dispose();

        autoConnectReply.map(e -> "reply data2 " + e).subscribe(System.out::println);

        Thread.sleep(5000);

    }
}
