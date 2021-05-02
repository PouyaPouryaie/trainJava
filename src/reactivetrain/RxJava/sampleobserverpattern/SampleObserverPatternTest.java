package reactivetrain.RxJava.sampleobserverpattern;

public class SampleObserverPatternTest {


    public static void main(String[] args) {

        Subject<String> subject = new ConcreteSubject();
        Observer<String> observerA = new ConcreteObserverA();
        Observer<String> observerB = new ConcreteObserverB();

        subject.notifyObservers("No listener");

        subject.registerObserver(observerA);
        subject.notifyObservers("Message to obs A");

        subject.registerObserver(observerB);
        subject.notifyObservers("Message to obs A and obs B");

        subject.unregisterObserver(observerA);
        subject.notifyObservers("Message to obs B");

        subject.unregisterObserver(observerB);
        subject.notifyObservers("no Listener");
    }
}
