import java.util.LinkedList;
import java.util.List;

public class Board implements UIObserver, BoardObservable {

    private BoardObserver boardController;
    private Tile[][] board;
    private Player player;

    public Board(List<String> lines, char c, BoardObserver boardController){
        player = PlayersList.getInstance().getPlayer(c);
        board = new Tile[lines.size()][];
        int index = 0;
        for (String line: lines) {
            for (int i = 0; i < line.length(); i++) {
                board[index][i] = new Tile(line.charAt(i), index, i);
            }
        }
        addObserver(boardController);
    }

    @Override
    public void addObserver(BoardObserver o) {
        boardController = o;
    }

    @Override
    public void notifyObserverBoard(List<String> lines) {
        boardController.updateBoard(lines);
    }

    @Override
    public void notifyObserverStats(String stats) {
        boardController.updateStats(stats);
    }

    @Override
    public void notifyObserverCombatInfo(String combatInfo) {

    }

    @Override
    public void notifyObserverLevelUp(String levelUp) {

    }

    @Override
    public void update(char c) {
        if(c == 'w' | c == 'a' | c == 's' | c == 'd' | c == 'e' | c == 'q'){
            move(c);
        }
    }

    public void move(char c){

    }

    private List<String> toList(){
        List<String> lines = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String line = "";
            for (int j = 0; j < board[i].length; j++) {
                line += board[i][j].toString();
            }
            lines.add(line);
        }
        return lines;
    }
}
