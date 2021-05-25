import java.util.List;

public interface BoardObserver {
    void updateBoard(List<String> lines);
    void updateStats(String stats);
    void updateCombatInfo(String combatInfo);
    void updateLevelUp(String levelUp);
}
