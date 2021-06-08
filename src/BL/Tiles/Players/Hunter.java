package BL.Tiles.Players;

import BL.ConsoleColors;
import BL.MathOperations;
import BL.Tiles.Enemy;
import BL.Tiles.Player;

public class Hunter extends Player {

    private final int range;
    private int arrowsCount;
    private int ticksCount;

    public Hunter(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int range) {
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);
        this.range = range;
        arrowsCount = 10;
        ticksCount = 0;
        castName = "Shoot";
    }

    public String toString(){
        return ConsoleColors.CYAN_BOLD + super.toString() + ConsoleColors.RESET;
    }

    @Override
    public String description() {
        return super.description() + "Range: " + range
                + ", Arrow count: " + arrowsCount
                + ", Ticks count: " + ticksCount;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        arrowsCount += (10 * playerLevel);
        attackPoints += (2 * playerLevel);
        defensePoints += playerLevel;
        notifyObserverLevelUp("     " + 10 * playerLevel + " to the arrows count, " + 2 * playerLevel + " to the attack points, " + playerLevel + " to the defence points");
    }

    @Override
    public void cast() {
        if(arrowsCount != 0) {
            arrowsCount -= 1;
            notifyObserverCombatInfo(name + " uses " + castName);
            int closestEnemyDistance = range + 1;
            Enemy closestEnemy = null;
            for (Enemy enemy : enemyList) {
                int distance = (int) MathOperations.getDistance(x, y, enemy.getX(), enemy.getY());
                if(distance < closestEnemyDistance){
                    closestEnemyDistance = distance;
                    closestEnemy = enemy;
                }
            }
            if(closestEnemyDistance < range + 1){
                assert closestEnemy != null;
                notifyObserverCombatInfo(name + " attacks " + closestEnemy.getName() + "\n" + description() + "\n" + closestEnemy.description());
                int defenseRoll = MathOperations.random(closestEnemy.defensePoints);
                if(attackPoints > defenseRoll){
                    int damage = attackPoints - defenseRoll;
                    notifyObserverCombatInfo("Attack points: " + attackPoints + ". Defence roll: " + defenseRoll + ". damage taken: " + damage);
                    closestEnemy.healthAmount -= damage;
                    if (closestEnemy.dead()) {
                        notifyObserverCombatInfo("the enemy has died. experience gained: " + closestEnemy.experienceValue);
                        experience += closestEnemy.experienceValue;
                    }
                }
            }
        }
    }

    @Override
    public void turnUpdate() {
        super.turnUpdate();
        if(ticksCount == 10){
            arrowsCount += playerLevel;
            ticksCount = 0;
        }
        else{
            ticksCount += 1;
        }
    }
}
