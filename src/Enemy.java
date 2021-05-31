public abstract class Enemy extends Unit {

    protected int experienceValue; //The amount of experience gained by defeating this enemy.

    public Enemy(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int experienceValue){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);
        this.experienceValue = experienceValue;
    }

    public  String description() {
        return super.description() + "Experience value: " + experienceValue + ", ";
    }

    public void accept(Visitor v){
        v.visit(this);
    }

    public void visit(Enemy enemy){}

    public void visit(Player player){
        attack(player);
    }
}