import java.util.List;

public abstract class Player extends Unit {

    protected int experience;
    protected int playerLevel;
    protected List<Enemy> enemyList;
    protected String castName;

    public Player(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, List<Enemy> enemyList) {
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);
        experience = 0;
        playerLevel = 1;
        this.enemyList = enemyList;
    }

    public void levelUp(){
        experience -= (50 * playerLevel);
        playerLevel += 1;
        healthPool += (10 * playerLevel);
        healthAmount = healthPool;
        attackPoints += (4 * playerLevel);
        defensePoints += playerLevel;
    }

    public abstract void turnUpdate();

    public String description() {
        return super.description() + "Experience value: " + experience + ", ";
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
    }

    abstract public void cast();
}
