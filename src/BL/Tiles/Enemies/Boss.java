package BL.Tiles.Enemies;

import BL.Board;
import BL.MathOperations;
import BL.Tiles.Enemy;
import BL.Tiles.HeroicUnit;
import BL.Tiles.Mover;
import BL.Tiles.Player;

public class Boss extends Enemy implements Mover, HeroicUnit {

    private final int visionRange;
    private final int abilityFrequency;
    private int combatTicks;

    public Boss(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int experienceValue, int visionRange, int abilityFrequency){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, experienceValue);
        this.visionRange = visionRange;
        this.abilityFrequency = abilityFrequency;
        combatTicks = 0;
    }

    @Override
    public void cast() {

    }

    @Override
    public void enemyTurn(Player player, Board board) {
        moveBoss(player, board);
    }

    private void moveBoss(Player player, Board board){
        if (MathOperations.getDistance(x,y,player.getX(),player.getY()) < this.visionRange) {
            if(combatTicks == abilityFrequency){
                combatTicks = 0;
                cast();
            }
            else {
                combatTicks += 1;
                var dx = x - player.getX();
                var dy = y - player.getY();
                if (Math.abs(dx) > Math.abs(dy)) {
                    if (dx > 0) {
                        moveUp(board);
                    }
                    else {
                        moveDown((board));
                    }
                }
                else {
                    if (dy > 0) {
                        moveLeft(board);
                    } else {
                        moveRight(board);
                    }
                }
            }
        }
        else {
            combatTicks = 0;
            moveBossRandom(board);
        }
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

    private void moveBossRandom(Board board){
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

}
