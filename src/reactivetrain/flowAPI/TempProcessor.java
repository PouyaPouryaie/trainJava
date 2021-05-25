package reactivetrain.flowAPI;

import java.util.concurrent.Flow.*;

public class TempProcessor implements Processor<TempInfo, TempInfo> {

    private Subscriber<? super TempInfo> subscriber;

    @Override
    public void subscribe(Subscriber<? super TempInfo> subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscriber.onSubscribe(subscription);
    }

    @Override
    public void onNext(TempInfo item) {
        this.subscriber.onNext(new TempInfo(item.getTown(), (item.getTemp() - 32) * 5 / 9));
    }

    @Override
    public void onError(Throwable throwable) {
        this.subscriber.onError(throwable);
    }

    @Override
    public void onComplete() {
        this.subscriber.onComplete();
    }
}
