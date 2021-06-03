public class Monster extends Enemy implements Mover{

    protected int visionRange;

    public Monster(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int experienceValue, Player player, int visionRange) {
        super(tile, x, y, name, healthPool, attackPoints, defensePoints, experienceValue, player);
        this.visionRange = visionRange;
    }

    @Override
    public String description() {
        return super.description() + "Vision range: " + visionRange;
    }

    @Override
    public void enemyTurn(Board board) {
        moveMonster(board);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public void visit(Enemy enemy) {

    }

    @Override
    public void visit(Empty empty) {
        int emptyX = empty.getX();
        int emptyY = empty.getY();
        empty.setX(x);
        empty.setY(y);
        x = emptyX;
        y = emptyY;
    }

    @Override
    public void visit(Wall wall) {

    }

    public void moveMonster(Board board){

    }

    @Override
    public void moveUp(Board board) {

    }

    @Override
    public void moveDown(Board board) {

    }

    @Override
    public void moveLeft(Board board) {

    }

    @Override
    public void moveRight(Board board) {

    }
}