import java.util.List;

public class UI implements BoardObserver, UIObservable {

    UIObserver boardController;

    public UI(List<String> lines){
        boardController = new BoardController(lines, this);
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
    public void update(List<String> lines) {

    }
}
