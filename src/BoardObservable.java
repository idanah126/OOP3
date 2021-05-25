import java.util.List;

public interface BoardObservable {
    void addObserver(BoardObserver o);
    void notifyObserverBoard(List<String> lines);
    void notifyObserverStats(String stats);
    void notifyObserverCombatInfo(String combatInfo);
    void notifyObserverLevelUp(String levelUp);
}
