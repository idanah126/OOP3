import java.util.List;

public class Rogue extends Player {

    private final int cost;
    private int currentEnergy;

    public Rogue(Board board, char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, List<Enemy> enemyList, int cost) {
        super(board, tile, x, y, name, healthPool, attackPoints, defensePoints, enemyList);
        this.cost = cost;
        currentEnergy = 100;
        castName = "Fan of Knives";
    }

    @Override
    public String description() {
        return super.description() + "Cost: " + cost + ", Current Energy: " + currentEnergy;
    }

    public void levelUp(){
        super.levelUp();
        currentEnergy = 100;
        attackPoints += (3 * playerLevel);
        notifyObserverLevelUp("     " + 3 * playerLevel + " to the attack points");
    }

    @Override
    public void cast() {
        if(currentEnergy >= cost){
            notifyObserverCombatInfo(name + " uses " + castName);
            currentEnergy -= (cost + 10);
            for (Enemy enemy: enemyList) {
                if(MathOperations.getDistance(x,y,enemy.getX(),enemy.getY()) < 2){
                    notifyObserverCombatInfo(name + " attacks " + enemy.name + "\n" + description() + "\n" + enemy.description());
                    int defenceRoll = MathOperations.random(enemy.defensePoints);
                    if(attackPoints > defenceRoll) {
                        notifyObserverCombatInfo("attack points: " + attackPoints + ". defence roll: " + defenceRoll + ". damage taken: " + attackPoints);
                        enemy.healthAmount -= attackPoints;
                        if(enemy.dead()){
                            notifyObserverCombatInfo("the enemy has died. experience gained: " + enemy.experienceValue);
                            experience += enemy.experienceValue;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void turnUpdate() {
        super.turnUpdate();
        currentEnergy = Math.min(currentEnergy + 10, 100);
    }

}
