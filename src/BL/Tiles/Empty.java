package BL.Tiles;

import BL.ConsoleColors;
import BL.VisitorPattern.*;

public class Empty extends Tile {

    public Empty(int x, int y){
        super('.' , x, y);
    }

    public String toString(){
        return ConsoleColors.BLACK + super.toString() + ConsoleColors.RESET;
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
