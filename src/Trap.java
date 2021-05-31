public class Trap extends Enemy {

    protected int visibilityTime;
    protected int invisibilityTime;
    protected int ticksCount;
    protected boolean visible;

    public Trap(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int experienceValue, int visibilityTime, int invisibilityTime)
    {
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, experienceValue);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        ticksCount = 0;
        visible = true;
    }

    @Override
    public int attack(Tile defender) {
        return 1;
    }

    @Override
    public String description() {
        String description = super.description() + "Visibility time: " + this.visibilityTime + ", " +
                "Invisibility time: " + this.invisibilityTime + ", " +
                "Ticks Count: " + this.ticksCount + ", " +
                "Visible: " + this.visible + "," ;
        return description;
    }

//    public boolean visibleState(){
//        visible = ticksCount < visibilityTime;
//        if(invisibilityTime == (visibilityTime + invisibilityTime))
//            invisibilityTime=0;
//        else
//            invisibilityTime++;
//        if (range(trap, player) < 2)
//            this.attack(Player);
//    }

    public void setTicksCount(int ticksCount) {this.ticksCount=ticksCount;}

    @Override
    public void accept(Visitor v) {

    }

    @Override
    public void visit(Player player) {

    }

    @Override
    public void visit(Enemy enemy) {

    }

    @Override
    public void visit(Empty empty) {

    }

    @Override
    public void visit(Wall wall) {

    }
}