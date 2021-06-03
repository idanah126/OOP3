import java.util.List;

public class Mage extends Player {

    private int manaPool;
    private int currentMana;
    private final int manaCost;
    private int spellPower;
    private final int hitsCount;
    private final int abilityRange;

    public Mage(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, List<Enemy> enemyList, int manaPool, int manaCost, int spellPower, int hitsCount, int abilityRange){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, enemyList);
        this.manaPool = manaPool;
        currentMana = manaPool / 4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;
        castName = "Blizzard";
    }

    @Override
    public String description() {
        return super.description() + "Mana pool: " + manaPool
                + ", Current mana: " + currentMana
                + ", Mana cost: " + manaCost
                + ", Spell power: " + spellPower
                + ", Hits count: " + hitsCount
                + ", Ability range: " + abilityRange;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        manaPool += (25 * playerLevel);
        currentMana = Math.min(currentMana + (manaPool / 4), manaPool);
        spellPower += (10 * playerLevel);
    }

    @Override
    public void cast() {
        if(currentMana >= manaCost){
            currentMana -= manaCost;
            int hits = 0;
            for (Enemy enemy: enemyList) {
                if(MathOperations.getDistance(x,y,enemy.getX(),enemy.getY()) < abilityRange && hits < hitsCount){
                    int defenceRoll = MathOperations.random(enemy.defensePoints);
                    if(spellPower > defenceRoll) {
                        enemy.healthAmount -= spellPower;
                        if (enemy.dead()) {
                            enemyList.remove(enemy);
                        }
                    }
                    hits += 1;
                }
            }
        }
    }

    @Override
    public void turnUpdate() {
        super.turnUpdate();
        currentMana = Math.min(manaPool, currentMana + playerLevel);
    }
}
