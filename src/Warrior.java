import java.util.List;

public class Warrior extends Player {

    private int abilityCoolDown;
    private int remainingCoolDown;

    public Warrior(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, List<Enemy> enemyList, int abilityCoolDown){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, enemyList);
        this.abilityCoolDown = abilityCoolDown;
        remainingCoolDown = 0;
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
    public int attack(Tile defender) {
        return 0;
    }

    @Override
    public void cast() {
        for (Enemy enemy: enemyList) {
            if(MathOperations.getDistance(x, y, enemy.getX(), enemy.getY()) < 3){
                
            }
        }
    }
}
