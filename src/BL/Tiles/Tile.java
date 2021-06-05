package BL.Tiles;
import BL.VisitorPattern.*;

public abstract class Tile implements Visited, Visitor {

    protected char c;
    protected int x;
    protected int y;

    public Tile(char c, int x, int y){
        this.c = c;
        this.x = x;
        this.y = y;
    }

    public char getTile() {return c;}

    public int getX() {return x;}

    public int getY() {return y;}

    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

    public void setChar(char c) {this.c = c;}

    public String toString(){
        return c + "";
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
        tile.accept(this);
    }
}
