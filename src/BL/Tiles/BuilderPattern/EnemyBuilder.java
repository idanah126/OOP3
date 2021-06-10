package BL.Tiles.BuilderPattern;

import BL.Board;
import BL.Tiles.Player;

public interface EnemyBuilder {
    void initialize(Board board, Player player);
}
