public class Monster extends Enemy {

    protected int visionRange;

    public Monster(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int experienceValue, int visionRange) {
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, experienceValue);
        this.visionRange = visionRange;
    }

    @Override
    public String description() {
        String description = super.description() + "Vision range: " + this.visionRange;
        return description;
    }

    @Override
    public int attack(Tile defender) {
        return 0;
    }


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