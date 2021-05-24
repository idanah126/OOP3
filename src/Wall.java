public class Wall extends Tile {

    public Wall(){
        tile = '#';
    }

    @Override
    public void attack(Tile defender) {
        throw new IllegalArgumentException("wall tile");
    }
}
