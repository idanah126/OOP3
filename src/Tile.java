abstract public class Tile {

    protected char tile;
    protected int x;
    protected int y;

    public String toString(){
        return tile + "";
    }

    abstract public void attack(Tile defender);
}
