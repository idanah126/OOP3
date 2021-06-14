package Tests.TilesTests;

import BL.Tiles.Empty;
import BL.Tiles.Enemies.Monster;
import BL.Tiles.Players.Warrior;
import BL.Tiles.Tile;
import BL.Tiles.Unit;
import BL.Tiles.Wall;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    static Unit u1;
    static Tile w;
    static Tile e;
    static Unit u2;

    @BeforeAll
    static void setUp() {
        u1 = new Warrior('q', 0,0, "test",3,3,3,3);
        w = new Wall(0,0);
        e = new Empty(0,0);
        u2 = new Monster('w',0,0,"test2",3,3,3,3,3);
    }

    @Test
    void getName() {
        assertEquals(u1.getName(), "test");
        assertEquals(u2.getName(), "test2");
    }

    @Test
    void updateHealth() {
        u1.updateHealth(5);
        u2.updateHealth(7);
        assertEquals(u1.healthAmount, 3);
        assertEquals(u2.healthAmount, 3);
    }

    @Test
    void dead() {
        assertFalse(u1.dead());
        assertFalse(u2.dead());

    }

    @Test
    void visit() {
        u1.visit(w);
        u2.visit(w);
    }

    @Test
    void testVisit() {
        u1.visit(e);
        u2.visit(e);
    }

}