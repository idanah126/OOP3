public abstract class Player extends Unit {

    protected int experience;
    protected int playerLevel;

    public void levelUp(){
        experience -= (50 * playerLevel);
        playerLevel += 1;
//        healthPool += (10 * playerLevel);
//        currentHealth = healthPool;
//        attackPoints += (4 * playerLevel);
//        defencePoints += playerLevel;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public void visit(Player p) {
    }

    @Override
    public void visit(Wall wall) {
    }

    @Override
    public void visit(Empty empty) {
    }

    @Override
    public void visit(Enemy enemy) {
//        combat(enemy);
    }

    abstract public void cast();
}
