public class Wall extends Tile {

    private int x;
    private int y;

    public Wall(int x, int y){
        super('#' , x, y);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public void visit(Player player) {}

    @Override
    public void visit(Enemy enemy) {}

    @Override
    public void visit(Empty empty) {}

    @Override
    public void visit(Wall wall) {}
}
