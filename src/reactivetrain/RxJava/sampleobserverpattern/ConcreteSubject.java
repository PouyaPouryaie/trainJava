package reactivetrain.RxJava.sampleobserverpattern;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcreteSubject implements Subject<String>{

    private final Set<Observer<String>> observers = new CopyOnWriteArraySet<>();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public void registerObserver(Observer<String> observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer<String> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        notifyObserver(event);
    }

    private void notifyObserver(String event) {
        observers.forEach(
                observer -> executorService.submit(
                        () -> observer.observe(event)));
    }
}
