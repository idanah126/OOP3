import java.util.List;

public interface BoardObserver {
    void update(List<String> lines);
}
