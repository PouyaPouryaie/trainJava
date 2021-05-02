package reactivetrain.RxJava.sampleobserverpattern;

public interface Observer<T> {

    void observe(T event);
}
