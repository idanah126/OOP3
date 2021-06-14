package Tests;

import BL.Tiles.Empty;
import BL.Tiles.Tile;
import BL.Tiles.Wall;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TileTest {


    static Tile e;
    static Tile w;

    @BeforeAll
    static void setUp() {
        e = new Empty(2, 3);
        w = new Wall(3,4);
    }

    @Test
    void getTile() {
        assertEquals(e.getTile(), '.');
        assertEquals(w.getTile(), '#');

    }

    @Test
    void getX() {
        assertEquals(e.getX(), 2);
        assertEquals(w.getX(), 3);
    }

    @Test
    void getY() {
        assertEquals(e.getY(), 3);
        assertEquals(w.getY(), 4);
    }

    @Test
    void setX() {
        e.setX(4);
        w.setX(7);
    }

    @Test
    void setY() {
        e.setY(5);
        w.setY(8);
    }

    @Test
    void setChar() {
        e.setChar('q');
        w.setChar('g');
    }

}