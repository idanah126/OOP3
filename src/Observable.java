public interface Observable {
    void addObserver(Observer o);
    void notifyObserver(int i1, int i2);
}
