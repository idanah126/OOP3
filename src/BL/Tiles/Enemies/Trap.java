package BL.Tiles.Enemies;

import BL.Board;
import BL.Tiles.Empty;
import BL.Tiles.Enemy;
import BL.Tiles.Player;
import BL.Tiles.Wall;

public class Trap extends Enemy {

    protected int visibilityTime;
    protected int invisibilityTime;
    protected int ticksCount;
    protected boolean visible;

    public Trap(Board board, char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int experienceValue, Player player, int visibilityTime, int invisibilityTime)
    {
        super(board, tile, x, y, name, healthPool, attackPoints, defensePoints, experienceValue, player);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        ticksCount = 0;
        visible = true;
    }

    @Override
    public String description() {
        return super.description() + "Visibility time: " + visibilityTime + ", " +
                "Invisibility time: " + invisibilityTime + ", " +
                "Ticks Count: " + ticksCount + ", " +
                "Visible: " + visible;
    }

//    public boolean visibleState(){
//        visible = ticksCount < visibilityTime;
//        if(invisibilityTime == (visibilityTime + invisibilityTime))
//            invisibilityTime=0;
//        else
//            invisibilityTime++;
//        if (range(trap, player) < 2)
//            this.attack(BL.Tiles.Player);
//    }

    public void setTicksCount(int ticksCount) {this.ticksCount=ticksCount;}

    @Override
    public void enemyTurn() {

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