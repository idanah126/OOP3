package BL.Tiles.Enemies;

import BL.ConsoleColors;
import BL.MathOperations;
import BL.Tiles.Enemy;
import BL.Tiles.Mover;
import BL.VisitorPattern.Visitor;

public class Monster extends Enemy implements Mover {

    protected int visionRange;

    public Monster(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int experienceValue, int visionRange) {
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, experienceValue);
        this.visionRange = visionRange;
    }

    public String toString(){
        return ConsoleColors.GREEN + super.toString() + ConsoleColors.RESET;
    }

    @Override
    public String description() {
        return super.description() + "Vision range: " + visionRange;
    }
    @Override
    public void enemyTurn() {
        moveMonster();
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public void moveMonster(){
        if (MathOperations.getDistance(x, y, player.getX(), player.getY()) < visionRange) {
            var dx = x - player.getX();
            var dy = y - player.getY();
            if (Math.abs(dx) > Math.abs(dy)) {
                if (dx > 0) {
                    moveUp();
                } else {
                    moveDown();
                }
            }
            else {
                if (dy > 0) {
                    moveLeft();
                }
                else {
                    moveRight();
                }
            }
        }
        else {
            moveMonsterRandom();
        }
    }

    protected void moveMonsterRandom(){
        int num = MathOperations.random(3);
        if(num == 1)
            moveLeft();
        else if (num == 2)
            moveRight();
        else if (num == 3)
            moveDown();
        else
            moveUp();
    }

    @Override
    public void moveUp() {
        visit(board.getTile(x - 1, y));
    }

    @Override
    public void moveDown() {
        visit(board.getTile(x + 1, y));
    }

    @Override
    public void moveLeft() {
        visit(board.getTile(x, y - 1));
    }

    @Override
    public void moveRight() {
        visit(board.getTile(x, y + 1));
    }


}