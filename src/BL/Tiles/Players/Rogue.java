package BL.Tiles.Players;

import BL.ConsoleColors;
import BL.MathOperations;
import BL.Tiles.Enemy;
import BL.Tiles.Player;

public class Rogue extends Player {

    private final int cost;
    private int currentEnergy;

    public Rogue(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int cost) {
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);
        this.cost = cost;
        currentEnergy = 100;
        castName = "Fan of Knives";
    }

    public String toString(){
        return ConsoleColors.PURPLE + super.toString() + ConsoleColors.RESET;
    }

    @Override
    public String description() {
        return super.description() + "Cost: " + cost + ", Current Energy: " + currentEnergy;
    }

    public void levelUp(){
        super.levelUp();
        currentEnergy = 100;
        attackPoints += (3 * playerLevel);
        notifyObserverLevelUp("     " + 3 * playerLevel + " to the attack points");
    }

    @Override
    public void cast() {
        if(currentEnergy >= cost){
            notifyObserverCombatInfo(name + " uses " + castName);
            currentEnergy -= (cost + 10);
            for (Enemy enemy: enemyList) {
                if(MathOperations.getDistance(x,y,enemy.getX(),enemy.getY()) < 2){
                    notifyObserverCombatInfo(name + " attacks " + enemy.getName() + "\n" + description() + "\n" + enemy.description());
                    int defenceRoll = MathOperations.random(enemy.defensePoints);
                    if(attackPoints > defenceRoll) {
                        int damage = attackPoints - defenceRoll;
                        notifyObserverCombatInfo("attack points: " + attackPoints + ". defence roll: " + defenceRoll + ". damage taken: " + damage);
                        enemy.healthAmount -= damage;
                        if(enemy.dead()){
                            notifyObserverCombatInfo("the enemy has died. experience gained: " + enemy.experienceValue);
                            experience += enemy.experienceValue;
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
