package reactivetrain.flowAPI;

import java.util.concurrent.Flow.*;

public class MainApp {

    public static void main(String[] args) {
        getTemperatures("New York").subscribe(new TempSubscriber());
    }

    private static Publisher<TempInfo> getTemperatures(String town){

        return subscriber -> {
            TempProcessor tempProcessor = new TempProcessor();
            tempProcessor.subscribe(subscriber);
            tempProcessor.onSubscribe(new TempSubscription(tempProcessor, town));
        };

        // without use processor
        /*return subscriber -> {
            subscriber.onSubscribe(new TempSubscription(subscriber, town));
        };*/
    }
}
