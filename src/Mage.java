import java.util.List;

public class Mage extends Player {

    private int manaPool;
    private int currentMana;
    private int manaCost;
    private int spellPower;
    private int hitsCount;
    private int abilityRange;

    public Mage(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, List<Enemy> enemyList, int manaPool, int manaCost, int spellPower, int hitsCount, int abilityRange){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, enemyList);
        this.manaPool = manaPool;
        currentMana = manaPool / 4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;

    }

    @Override
    public void levelUp() {
        super.levelUp();
        manaPool += (25 * playerLevel);
        currentMana = Math.min(currentMana + (manaPool / 4), manaPool);
        spellPower += (10 * playerLevel);
    }

    @Override
    public int attack(Tile defender) {
        return 0;
    }

    @Override
    public void cast() {

    }
}
