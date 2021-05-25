abstract public class Player extends Unit {

    protected int experience;
    protected int playerLevel;

    public void levelUp(){
        experience -= (50 * playerLevel);
        playerLevel += 1;
        healthPool += (10 * playerLevel);
        currentHealth = healthPool;
        attackPoints += (4 * playerLevel);
        defencePoints += playerLevel;
    }

    @Override
    public boolean accept(Visitor v) {
        return v.visit(this);
    }

    @Override
    public boolean visit(Player p) {
        return false;
    }

    @Override
    public boolean visit(Trap t) {
        return true;
    }

    @Override
    public boolean visit(Monster m) {
        return true;
    }

    abstract public void cast();
}
