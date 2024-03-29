package BL.Tiles.Players;

import BL.ConsoleColors;
import BL.MathOperations;
import BL.Tiles.Enemy;
import BL.Tiles.Player;

public class Mage extends Player {

    private int manaPool;
    private int currentMana;
    private final int manaCost;
    private int spellPower;
    private final int hitsCount;
    private final int abilityRange;

    public Mage(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int manaPool, int manaCost, int spellPower, int hitsCount, int abilityRange){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);
        this.manaPool = manaPool;
        currentMana = manaPool / 4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;
        castName = "Blizzard";
    }

    public String toString(){
        return ConsoleColors.RED + super.toString() + ConsoleColors.RESET;
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
        notifyObserverLevelUp("     " + 25 * playerLevel + " to the mana pool, " + 10 * playerLevel + " to the spell power");
    }

    @Override
    public void cast() {
        if(currentMana >= manaCost){
            notifyObserverCombatInfo(name + " uses " + castName);
            currentMana -= (manaCost + playerLevel);
            int hits = 0;
            for (Enemy enemy: enemyList) {
                if(MathOperations.getDistance(x,y,enemy.getX(),enemy.getY()) < abilityRange && hits < hitsCount){
                    notifyObserverCombatInfo(name + " attacks " + enemy.getName() + "\n" + description() + "\n" + enemy.description());
                    int defenceRoll = MathOperations.random(enemy.defensePoints);
                    if(spellPower > defenceRoll) {
                        int damage = spellPower - defenceRoll;
                        notifyObserverCombatInfo("spell power: " + spellPower + ". defence roll: " + defenceRoll + ". damage taken: " + damage);
                        enemy.healthAmount -= damage;
                        if (enemy.dead()) {
                            notifyObserverCombatInfo("the enemy has died. experience gained: " + enemy.experienceValue);
                            experience += enemy.experienceValue;
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
