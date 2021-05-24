public class Empty extends Tile {

    public Empty(){
        tile = '.';
    }

    @Override
    public void attack(Tile defender) {
        throw new IllegalArgumentException("empty tile");
    }
}
