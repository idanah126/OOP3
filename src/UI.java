import java.util.List;

public class UI implements BoardObserver, UIObservable {

    UIObserver boardController;

    public UI(List<String> lines, char c){
        boardController = new BoardController(lines, char c, this);
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
}
