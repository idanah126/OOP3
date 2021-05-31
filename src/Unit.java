abstract public class Unit extends Tile implements Visitor, Visited {

    protected String name;
    protected int healthPool;
    protected int healthAmount;
    protected int attackPoints;
    protected int defensePoints;

    public Unit(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints) {
        super(tile, x, y);
        this.name = name;
        this.healthPool = healthPool;
        healthAmount = healthPool;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
    }

    public String getName(){ return name + ""; }

    public  String description() {
        return this.name + "'s description:" +
                "Health pool: " + this.healthPool + ", " +
                "Health amount: " + this.healthAmount + ", " +
                "Attack points: " + this.attackPoints + ", " +
                "Defense points: " + this.defensePoints + ",";
    }

    public void updateHealth(int addedHealth){
        if(healthAmount + addedHealth >= healthPool){
            healthAmount = healthPool;
        }
        else{
            healthAmount += addedHealth;
        }
    }

    public boolean dead(){
        return healthAmount <= 0;
    }

    public abstract void accept(Visitor visitor);

    public abstract void visit(Player player);

    public abstract void visit(Enemy enemy);

    public void visit(Empty empty){

    }

    public void visit(Wall wall){}


    public void attack(Unit defender){
        int attackRoll = MathOperations.random(attackPoints);
        int defenceRoll = MathOperations.random(defender.defensePoints);
        if(attackRoll > defenceRoll){
            defender.healthAmount -= (attackRoll - defenceRoll);
            if(defender.dead()){
                x = defender.x;
                y = defender.y;
            }
        }
    }

}