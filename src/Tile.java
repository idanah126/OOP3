public class Tile implements Visited, Visitor {

    protected char tile;
    protected int x;
    protected int y;

    public Tile(char tile, int x, int y){
        if(tile == '.'){
            new Empty(x, y);
        }
        else if(tile == '#'){
            new Wall(x, y);
        }
        this.tile = tile;
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return tile + "";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public void visit(Player player) {
        player.visit(this);
    }

    @Override
    public void visit(Enemy enemy) {
        enemy.visit(this);
    }

    @Override
    public void visit(Empty empty) {
        empty.visit(this);
    }

    @Override
    public void visit(Wall wall) {
        wall.visit(this);
    }

    @Override
    public void visit(Tile tile) {
        tile.visit(this);
    }
}
