import java.util.List;

public class Warrior extends Player {

    private final int abilityCoolDown;
    private int remainingCoolDown;

    public Warrior(Board board, char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, List<Enemy> enemyList, int abilityCoolDown){
        super(board, tile, x, y, name, healthPool, attackPoints, defensePoints, enemyList);
        this.abilityCoolDown = abilityCoolDown;
        remainingCoolDown = 0;
        castName = "Avenger's Shield";
    }

    @Override
    public String description() {
        return super.description() + "Ability coolDown: " + abilityCoolDown + ", Remaining coolDown: " + remainingCoolDown;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        remainingCoolDown = 0;
        healthPool += (5 * playerLevel);
        healthAmount = healthPool;
        attackPoints += (2 * playerLevel);
        defensePoints += playerLevel;
        notifyObserverLevelUp("     " + 5 * playerLevel + " to the health pool, " + 2 * playerLevel + " to the attack points, " + playerLevel + " to the defence points");
    }

    @Override
    public void cast() {
        if(remainingCoolDown == 0) {
            notifyObserverCombatInfo(name + " uses " + castName);
            for (Enemy enemy : enemyList) {
                if (MathOperations.getDistance(x, y, enemy.getX(), enemy.getY()) < 3) {
                    notifyObserverCombatInfo(name + " attacks " + enemy.name + "\n" + description() + "\n" + enemy.description());
                    int lifeLost = (int) (healthPool * 0.1);
                    enemy.healthAmount -= lifeLost;
                    if(enemy.dead()){
                        notifyObserverCombatInfo("the enemy has died. experience gained: " + enemy.experienceValue);
                        experience += enemy.experienceValue;
                    }
                    updateHealth(10 * defensePoints);
                    break;
                }
            }
            remainingCoolDown = abilityCoolDown + 1;
        }
    }

    @Override
    public void turnUpdate() {
        super.turnUpdate();
        if (remainingCoolDown != 0){
            remainingCoolDown -= 1;
        }
    }
}
