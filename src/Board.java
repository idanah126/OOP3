public class Board implements Observable {

    private Observer observer;

    @Override
    public void addObserver(Observer o) {
        observer = o;
    }

    @Override
    public void notifyObserver(int i1, int i2) {
        observer.update(i1, i2);
    }
}
