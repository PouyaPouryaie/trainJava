package threadtrain;

public class ProducerConsumerTest {

    public static void main(String[] args){

        Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        producer.setDaemon(true);
        Consumer consumer = new Consumer(buffer);
        consumer.setDaemon(true);

        producer.start();
        consumer.start();

        try {
            Thread.sleep(4000); // sleep for 2 seconds
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
