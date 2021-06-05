package BL.Tiles.Enemies;

import BL.Board;
import BL.MathOperations;
import BL.Tiles.Empty;
import BL.Tiles.Enemy;
import BL.Tiles.Player;
import BL.Tiles.Wall;

public class Trap extends Enemy {

    protected int visibilityTime;
    protected int invisibilityTime;
    protected int ticksCount;
    protected boolean visible;
    protected char originalChar;

    public Trap(Board board, char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int experienceValue, Player player, int visibilityTime, int invisibilityTime)
    {
        super(board, tile, x, y, name, healthPool, attackPoints, defensePoints, experienceValue, player);
        this.originalChar = tile;
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        ticksCount = 0;
        visible = true;
    }

    public void setVisibility(boolean newValue) {
        this.visible = newValue;
        if (this.visible) {
            this.setChar(this.originalChar);
        } else {
            this.setChar('.');
        }
    }

    @Override
    public String description() {
        return super.description() + "Visibility time: " + visibilityTime + ", " +
                "Invisibility time: " + invisibilityTime + ", " +
                "Ticks Count: " + ticksCount + ", " +
                "Visible: " + visible;
    }

    public void visibleState() {
        this.setVisibility(ticksCount < visibilityTime);
        if(ticksCount == (visibilityTime + invisibilityTime))
            ticksCount=0;
        else
            ticksCount++;
        if (MathOperations.getDistance(x,y,player.getX(),player.getY()) < 2)
            this.attack(player);
    }

    public void setTicksCount(int ticksCount) {this.ticksCount=ticksCount;}

    @Override
    public void enemyTurn() {
        visibleState();
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