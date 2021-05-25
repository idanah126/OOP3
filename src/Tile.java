public class Tile implements Visited, Visitor {

    protected char tile;
    protected int x;
    protected int y;

    public Tile(char tile, int x, int y){
        this.tile = tile;
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return tile + "";
    }
}
