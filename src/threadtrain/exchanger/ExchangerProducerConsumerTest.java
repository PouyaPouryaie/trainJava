package threadtrain.exchanger;

import java.util.ArrayList;
import java.util.concurrent.Exchanger;

public class ExchangerProducerConsumerTest {

    public static void main(String[] args){

        Exchanger<ArrayList<Integer>> exchanger = new Exchanger<>();

        ExchangerProducer producer = new ExchangerProducer(exchanger, 5);
        ExchangerConsumer consumer = new ExchangerConsumer(exchanger);

        producer.start();
        consumer.start();


    }
}
