package BL.Tiles.Enemies;

import BL.Board;
import BL.Tiles.Enemy;
import BL.Tiles.Mover;
import BL.Tiles.Player;
import BL.Tiles.Wall;

public class Monster extends Enemy implements Mover {

    protected int visionRange;

    public Monster(Board board, char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int experienceValue, Player player, int visionRange) {
        super(board, tile, x, y, name, healthPool, attackPoints, defensePoints, experienceValue, player);
        this.visionRange = visionRange;
    }

    @Override
    public String description() {
        return super.description() + "Vision range: " + visionRange;
    }

    @Override
    public void enemyTurn() {
        moveMonster(board);
    }

    @Override
    public void visit(Enemy enemy) {

    }

    @Override
    public void visit(Wall wall) {

    }

    public void moveMonster(Board board){

    }

    @Override
    public void moveUp(Board board) {

    }

    @Override
    public void moveDown(Board board) {

    }

    @Override
    public void moveLeft(Board board) {

    }

    @Override
    public void moveRight(Board board) {

    }
}