public class Wall extends Tile {

    public Wall(){
        tile = '#';
    }

    @Override
    public void attack(Tile defender) {
        throw new IllegalArgumentException("wall tile");
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
