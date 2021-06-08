package BL.Tiles.Enemies;

import BL.ConsoleColors;
import BL.MathOperations;
import BL.Tiles.HeroicUnit;

public class Boss extends Monster implements HeroicUnit {

    private final int abilityFrequency;
    private int combatTicks;
    private final String castName;

    public Boss(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int experienceValue, int visionRange, int abilityFrequency){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, experienceValue, visionRange);
        this.abilityFrequency = abilityFrequency;
        combatTicks = 0;
        castName = "Shoot";
    }

    public String toString(){
        return ConsoleColors.GREEN_BOLD + super.toString() + ConsoleColors.RESET;
    }

    @Override
    public String description() {
        return super.description() + ", Ability frequency: " + abilityFrequency
                + ", Combat ticks: " + combatTicks
                + ", Special ability: " + castName;
    }

    @Override
    public void cast() {
        notifyObserverCombatInfo(name + " uses " + castName);
        notifyObserverCombatInfo(name + " attacks " + player.getName() + "\n" + description() + "\n" + player.description());
        int defenseRoll = MathOperations.random(player.defensePoints);
        if(attackPoints > defenseRoll){
            int damage = attackPoints - defenseRoll;
            notifyObserverCombatInfo("Attack points: " + attackPoints + ". Defence roll: " + defenseRoll + ". damage taken: " + damage);
            player.healthAmount -= damage;
            if(player.dead()){
                notifyObserverCombatInfo("The player died");
            }
        }
    }

    @Override
    public void moveMonster(){
        if (MathOperations.getDistance(x, y, player.getX(), player.getY()) < visionRange) {
            if(combatTicks == abilityFrequency){
                combatTicks = 0;
                cast();
            }
            else {
                combatTicks += 1;
                var dx = x - player.getX();
                var dy = y - player.getY();
                if (Math.abs(dx) > Math.abs(dy)) {
                    if (dx > 0) {
                        moveUp();
                    }
                    else {
                        moveDown();
                    }
                }
                else {
                    if (dy > 0) {
                        moveLeft();
                    } else {
                        moveRight();
                    }
                }
            }
        }
        else {
            combatTicks = 0;
            moveMonsterRandom();
        }
    }

}
