import java.util.List;

public class Rogue extends Player {

    private int cost;
    private int currentEnergy;

    public Rogue(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, List<Enemy> enemyList, int cost) {
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, enemyList);
        this.cost = cost;
        currentEnergy = 100;
        castName = "Fan of Knives";
    }

    public void levelUp(){
        super.levelUp();
        currentEnergy = 100;
        attackPoints += (3 * playerLevel);
    }

    @Override
    public void cast() {
        if(currentEnergy >= cost){
            currentEnergy -= cost;
            for (Enemy enemy: enemyList) {
                if(MathOperations.getDistance(x,y,enemy.getX(),enemy.getY()) < 2){
                    int defenceRoll = MathOperations.random(enemy.defensePoints);
                    if(attackPoints > defenceRoll) {
                        enemy.healthAmount -= attackPoints;
                        if (enemy.dead()) {
                            enemyList.remove(enemy);
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
