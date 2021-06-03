public interface UnitObservable {
    void addObserver(Board b);
    void notifyObserverStats(String stats);
    void notifyObserverCombatInfo(String combatInfo);
    void notifyObserverLevelUp(String levelUp);
}
