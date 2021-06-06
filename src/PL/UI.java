package PL;

import BL.ObserverPattern.BoardObserver;
import BL.ObserverPattern.UIObservable;
import BL.ObserverPattern.UIObserver;
import BL.Tiles.Player;

import java.util.List;

public class UI implements BoardObserver, UIObservable {

    UIObserver boardController;

    public UI(List<String> lines, Player player){
        boardController = new BoardController(lines, player, this);
        addObserver(boardController);
    }

    @Override
    public void addObserver(UIObserver o) {
        boardController = o;
    }

    @Override
    public void notifyObserver(char c) {
        boardController.update(c);
    }

    @Override
    public void updateBoard(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    @Override
    public void updateStats(String stats) {
        System.out.println(stats);
    }

    @Override
    public void updateCombatInfo(String combatInfo) {
        System.out.println(combatInfo);
    }

    @Override
    public void updateLevelUp(String levelUp) {
        System.out.println(levelUp);
    }

    @Override
    public boolean isActive() {
        return boardController.isActive();
    }

    @Override
    public boolean hasLost() {
        return boardController.hasLost();
    }
}
