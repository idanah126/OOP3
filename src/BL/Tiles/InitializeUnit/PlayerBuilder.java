package BL.Tiles.InitializeUnit;

import BL.Board;
import BL.Tiles.Enemy;

import java.util.List;

public interface PlayerBuilder {
    void initialize(Board board, List<Enemy> enemyList);
}
