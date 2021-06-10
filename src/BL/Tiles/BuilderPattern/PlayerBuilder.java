package BL.Tiles.BuilderPattern;

import BL.Board;
import BL.Tiles.Enemy;

import java.util.List;

public interface PlayerBuilder {
    void initialize(Board board, List<Enemy> enemyList);
}
