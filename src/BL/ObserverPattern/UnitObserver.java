package BL.ObserverPattern;

public interface UnitObserver {
    void updateStats(String stats);
    void updateCombatInfo(String combatInfo);
    void updateLevelUp(String levelUp);
}
