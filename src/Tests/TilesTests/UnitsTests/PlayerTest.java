package Tests.TilesTests.UnitsTests;

import BL.Tiles.*;
import BL.Tiles.Players.Rogue;
import BL.Tiles.Players.Warrior;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    static Player p1;
    static Player p2;


    @BeforeAll
    static void setUp() {
        p1 = new Rogue('s',2, 3,"6",6,6,6,6);
        p2 = new Warrior('w', 2,3,"test",3,4,2,1);
    }

    @Test
    void setDead() {
        p1.setDead();
        assertEquals(p1.getTile(), 'X');
    }

    @Test
    void accept() {
        p1.accept(p2);
        p2.accept(p1);
    }

    @Test
    void visit() {
        p1.visit(p2);
    }

    @Test
    void dead() {
        assertFalse(p1.dead());
        assertFalse(p2.dead());
    }

}