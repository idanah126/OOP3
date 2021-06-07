package BL.Tiles;

import BL.Board;
import BL.VisitorPattern.*;

public abstract class Enemy extends Unit {

    public int experienceValue; //The amount of experience gained by defeating this enemy.
    protected Player player;

    public Enemy(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int experienceValue){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);
        this.experienceValue = experienceValue;
    }

    public void initialize(Player player){
        this.player = player;
    }

    public  String description() {
        return super.description() + " Experience value: " + experienceValue + ", ";
    }

    public void accept(Visitor v){
        v.visit(this);
    }

    public void visit(Enemy enemy){}

    public void visit(Player player){
        if(!player.dead()) {
            attack(player);
        }
    }

    public abstract void enemyTurn(Player player, Board board);

    @Override
    public void notifyObserverLevelUp(String levelUp) {}

    @Override
    public void notifyObserverStats(String stats) {}
}