package PL;

import BL.Board;
import BL.ObserverPattern.BoardObservable;
import BL.ObserverPattern.BoardObserver;
import BL.ObserverPattern.UIObservable;
import BL.ObserverPattern.UIObserver;
import BL.Tiles.Player;

import java.util.List;

public class BoardController implements UIObserver, UIObservable, BoardObserver, BoardObservable {

    private BoardObserver ui;
    private UIObserver board;

    public BoardController(List<String> lines, Player player, UI ui){
        board = new Board(lines, player, this);
        addObserver(ui);
        addObserver(board);
    }

    @Override
    public void addObserver(BoardObserver o) {
        ui = o;
    }

    @Override
    public void notifyObserverBoard(List<String> lines) {
        ui.updateBoard(lines);
    }

    @Override
    public void notifyObserverStats(String stats) {
        ui.updateStats(stats);
    }

    @Override
    public void notifyObserverCombatInfo(String combatInfo) {
        ui.updateCombatInfo(combatInfo);
    }

    @Override
    public void notifyObserverLevelUp(String levelUp) {
        ui.updateLevelUp(levelUp);
    }

    @Override
    public void addObserver(UIObserver o) {
        board = o;
    }

    @Override
    public void notifyObserver(char c) {
        board.update(c);
    }

    @Override
    public void update(char c) {
        notifyObserver(c);
    }

    @Override
    public void updateBoard(List<String> lines) {
        notifyObserverBoard(lines);
    }

    @Override
    public void updateStats(String stats) {
        notifyObserverStats(stats);
    }

    @Override
    public void updateCombatInfo(String combatInfo) {
        notifyObserverCombatInfo(combatInfo);
    }

    @Override
    public void updateLevelUp(String levelUp) {
        notifyObserverLevelUp(levelUp);
    }

    @Override
    public boolean isActive() {
        return board.isActive();
    }

    @Override
    public boolean hasLost() {
        return board.hasLost();
    }
}
