package reactivetrain.observerdesignpattern;

public interface SubjectLibrary {

    void subscribeObserver(Observer observer);

    void unSubscribeObserver(Observer observer);

    void notifyObserver();
}
