public abstract class Tile implements Visited, Visitor {

    protected char tile;
    protected int x;
    protected int y;

    public Tile(char tile, int x, int y){
        this.tile = tile;
        this.x = x;
        this.y = y;
    }

    public char getTile() {return tile;}

    public int getX() {return x;}

    public int getY() {return y;}

    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

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
