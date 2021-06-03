import java.util.List;

public class Warrior extends Player {

    private final int abilityCoolDown;
    private int remainingCoolDown;

    public Warrior(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, List<Enemy> enemyList, int abilityCoolDown){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, enemyList);
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
        attackPoints += (2 * playerLevel);
        defensePoints += playerLevel;
    }

    @Override
    public void cast() {
        if(remainingCoolDown == 0) {
            for (Enemy enemy : enemyList) {
                if (MathOperations.getDistance(x, y, enemy.getX(), enemy.getY()) < 3) {
                    enemy.healthAmount -= (healthPool * 0.1);
                    if(enemy.dead()){
                        enemyList.remove(enemy);
                    }
                    updateHealth(10 * defensePoints);
                    break;
                }
            }
            remainingCoolDown = abilityCoolDown;
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
