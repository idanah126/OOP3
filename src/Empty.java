public class Empty extends Tile {

    public Empty(){
        tile = '.';
    }

    @Override
    public void attack(Tile defender) {
        throw new IllegalArgumentException("empty tile");
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
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
