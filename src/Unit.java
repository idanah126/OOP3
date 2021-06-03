abstract public class Unit extends Tile implements Visitor, Visited, UnitObservable {

    protected Board board;
    protected String name;
    protected int healthPool;
    protected int healthAmount;
    protected int attackPoints;
    protected int defensePoints;

    public Unit(Board board, char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints) {
        super(tile, x, y);
        this.name = name;
        this.healthPool = healthPool;
        healthAmount = healthPool;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        addObserver(board);
    }

    public String getName(){ return name + ""; }

    public  String description() {
        return this.name + "'s description: " +
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
        int emptyX = empty.getX();
        int emptyY = empty.getY();
        empty.setX(x);
        empty.setY(y);
        setX(emptyX);
        setY(emptyY);
    }

    public void visit(Wall wall){}


    public void attack(Unit defender){
        notifyObserverCombatInfo(name + " attacks " + defender.getName() + "\n" + description() + "\n" + defender.description());
        int attackRoll = MathOperations.random(attackPoints);
        int defenceRoll = MathOperations.random(defender.defensePoints);
        int damage = 0;
        if(attackRoll > defenceRoll){
            damage = attackRoll - defenceRoll;
            defender.healthAmount -= damage;
        }
        String dead = "no";
        if(defender.dead()){
            dead = "yes";
        }
        notifyObserverCombatInfo("attack roll: " + attackRoll + ". defence roll: " + defenceRoll + ". damage taken: " + damage + ". did the defender die?: " + dead);
    }

    @Override
    public void addObserver(Board b) {
        board = b;
    }

    @Override
    public void notifyObserverCombatInfo(String combatInfo) {
        board.updateCombatInfo(combatInfo);
    }
}