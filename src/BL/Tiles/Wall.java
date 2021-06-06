package BL.Tiles;

import BL.VisitorPattern.*;

public class Wall extends Tile {

    public Wall(int x, int y){
        super('#' , x, y);
    }

    public String toString(){
        return super.toString();
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
