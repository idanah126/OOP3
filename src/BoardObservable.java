import java.util.List;

public interface BoardObservable {
    void addObserver(BoardObserver o);
    void notifyObserver(List<String> lines);
}
