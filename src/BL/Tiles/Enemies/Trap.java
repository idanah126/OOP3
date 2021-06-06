package BL.Tiles.Enemies;

import BL.Board;
import BL.ConsoleColors;
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

    public Trap(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int experienceValue, int visibilityTime, int invisibilityTime)
    {
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, experienceValue);
        this.originalChar = tile;
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        ticksCount = 0;
        visible = true;
    }

    public String toString(){
        if(visible) {
            return ConsoleColors.YELLOW + super.toString() + ConsoleColors.RESET;
        }
        else{
            return ConsoleColors.BLACK + super.toString() + ConsoleColors.RESET;
        }
    }

    private void setVisibility(boolean newValue) {
        visible = newValue;
        if (visible) {
            setChar(originalChar);
        } else {
            setChar('.');
        }
    }

    @Override
    public String description() {
        return super.description() + "Visibility time: " + visibilityTime + ", " +
                "Invisibility time: " + invisibilityTime + ", " +
                "Ticks Count: " + ticksCount + ", " +
                "Visible: " + visible;
    }

    public void visibleState(Player player) {
        setVisibility(ticksCount < visibilityTime);
        if(ticksCount == (visibilityTime + invisibilityTime))
            ticksCount=0;
        else
            ticksCount++;
        if (MathOperations.getDistance(x,y,player.getX(),player.getY()) < 2)
            attack(player);
    }

    public void setTicksCount(int ticksCount) {this.ticksCount=ticksCount;}

    @Override
    public void enemyTurn(Player player, Board board) {
        visibleState(player);
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