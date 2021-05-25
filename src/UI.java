public class UI implements Observer {

    private Board board;
    public UI(){
        board.addObserver(this);
    }

    @Override
    public void update(int i1, int i2) {

    }
}
