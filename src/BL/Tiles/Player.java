package BL.Tiles;

import java.util.List;

import BL.Board;
import BL.Tiles.InitializeUnit.PlayerBuilder;
import BL.VisitorPattern.*;

public abstract class Player extends Unit implements Mover, HeroicUnit, PlayerBuilder {

    protected int experience;
    protected int playerLevel;
    protected List<Enemy> enemyList;
    protected String castName;

    public Player(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints) {
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);
        experience = 0;
        playerLevel = 1;
    }

    public void initialize(Board board, List<Enemy> enemyList) {
        super.initialize(board);
        this.enemyList = enemyList;
    }

    public void setDead(){
        c = 'X';
    }

    public void levelUp(){
        experience -= (50 * playerLevel);
        playerLevel += 1;
        healthPool += (10 * playerLevel);
        healthAmount = healthPool;
        attackPoints += (4 * playerLevel);
        defensePoints += playerLevel;
        notifyObserverLevelUp("level up!, new level: " + playerLevel + "\n" + "gained: " + 10 * playerLevel + " to the health pool, " + 4 * playerLevel + " to the attack points, " + playerLevel + " to the defence points");
    }

    public void turnUpdate(){
        if(experience >= 50 * playerLevel){
            levelUp();
        }
    }

    public String description() {
        return super.description() + " Level: " + playerLevel + ", Experience value: " + experience + "\n" +  "      Special Ability: " + castName + ", ";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public void visit(Player p) {}

    @Override
    public void visit(Enemy enemy) {
        attack(enemy);
        if(enemy.dead()){
            experience += enemy.experienceValue;
            notifyObserverCombatInfo( "experience gained: " + enemy.experienceValue);
            int enemyX = enemy.getX();
            int enemyY = enemy.getY();
            enemy.setX(x);
            enemy.setY(y);
            setX(enemyX);
            setY(enemyY);
        }
    }

    public abstract void cast();

    public void playerTurn(char c){
        if(c == 'e'){
            cast();
        }
        movePlayer(c);
        turnUpdate();
    }

    public void movePlayer(char c){
        if(c == 'w'){
            moveUp();
        }
        else if(c == 'a'){
            moveLeft();
        }
        else if(c == 's'){
            moveDown();
        }
        else if(c == 'd'){
            moveRight();
        }
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

    @Override
    public boolean dead() {
        return super.dead();
    }

    @Override
    public void notifyObserverLevelUp(String levelUp) {
        board.updateLevelUp(levelUp);
    }

    @Override
    public void notifyObserverStats(String stats) {
        board.updateStats(stats);
    }
}
