public class Wall extends Tile {

    int x;
    int y;

    public Wall(int x, int y){
        super('#' , x, y);
        this.x = x;
        this.y = y;
    }

    @Override
    public void accept(Visitor v) {

    }

    @Override
    public void visit(Player player) {

    }

    @Override
    public void visit(Enemy enemy) {

    }

    @Override
    public void visit(Empty empty) {

    }

    @Override
    public void visit(Wall wall) {

    }
}
