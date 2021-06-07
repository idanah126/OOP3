package BL.Tiles.Enemies;

import BL.Board;
import BL.ConsoleColors;
import BL.MathOperations;
import BL.Tiles.Enemy;
import BL.Tiles.Mover;
import BL.Tiles.Player;
import BL.Tiles.Wall;
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
    public void enemyTurn( Player player, Board board) {
        moveMonster(player, board);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public void visit(Enemy enemy) { }

    @Override
    public void visit(Wall wall) { }

    public void moveMonster(Player player, Board board){
        if (MathOperations.getDistance(x,y,player.getX(),player.getY()) < this.visionRange) {
            var dx = x - player.getX();
            var dy = y - player.getY();
            if (Math.abs(dx) > Math.abs(dy)) {
                if (dx > 0) {
                    moveUp(board);
                } else {
                    moveDown((board));
                }
            }
            else {
                if (dy > 0) {
                    moveLeft(board);
                }
                else {
                    moveRight(board);
                }
            }
        }
        else {
            moveMonsterRandom(board);
        }
    }

    private void moveMonsterRandom(Board board){
        int num = MathOperations.random(3);
        if(num == 1)
            moveLeft(board);
        else if (num == 2)
            moveRight(board);
        else if (num == 3)
            moveDown(board);
        else
            moveUp(board);
    }

    @Override
    public void moveUp(Board board) {
        visit(board.getTile(x - 1, y));
    }

    @Override
    public void moveDown(Board board) {
        visit(board.getTile(x + 1, y));
    }

    @Override
    public void moveLeft(Board board) {
        visit(board.getTile(x, y - 1));
    }

    @Override
    public void moveRight(Board board) {
        visit(board.getTile(x, y + 1));
    }


}