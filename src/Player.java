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

    abstract public void cast();
}
