import java.util.List;

public class Rogue extends Player {

    private int cost;
    private int currentEnergy;

    public Rogue(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, List<Enemy> enemyList, int cost) {
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, enemyList);
        this.cost = cost;
        currentEnergy = 100;
    }

    public void levelUp(){
        super.levelUp();
        currentEnergy = 100;
        attackPoints += (3 * playerLevel);
    }

    @Override
    public int attack(Tile defender) {
        return 0;
    }

    @Override
    public void cast() {

    }
}
