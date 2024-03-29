package BL.ObserverPattern;

public interface UIObservable {
    void addObserver(UIObserver o);
    void notifyObserver(char c);
}
