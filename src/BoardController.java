import java.util.List;

public class BoardController implements UIObserver, UIObservable, BoardObserver, BoardObservable {

    private BoardObserver ui;
    private UIObserver board;

    public BoardController(List<String> lines, UI ui){
        board = new Board(lines, this);
        addObserver(ui);
        addObserver(board);
    }

    @Override
    public void addObserver(BoardObserver o) {
        ui = o;
    }

    @Override
    public void notifyObserver(List<String> lines) {
        ui.update(lines);
    }

    @Override
    public void update(List<String> lines) {
        notifyObserver(lines);
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
}
