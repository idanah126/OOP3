public class Warrior extends Player {

    private int abilityCoolDown;
    private int remainingCoolDown;

    public Warrior(int abilityCoolDown){
        this.abilityCoolDown = abilityCoolDown;
        remainingCoolDown = 0;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        remainingCoolDown = 0;
        healthPool += (5 * playerLevel);
        attackPoints += (2 * playerLevel);
        defencePoints += playerLevel;
    }

    @Override
    public void attack(Tile defender) {

    }

    @Override
    public void cast() {
        
    }
}
