package Tests.TilesTests;

import BL.Tiles.Empty;
import BL.Tiles.Players.Warrior;
import BL.Tiles.Wall;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class WallTest {

    static Empty e;
    static Warrior warrior;
    static Wall w1;
    static Wall w2;

    @BeforeAll
    static void setUp() {
        e = new Empty(2, 3);
        warrior = new Warrior('w', 2,3,"test",3,4,2,1);
        w1 = new Wall(2,3);
        w2 = new Wall(6,1);
    }

    @Test
    void accept() {
        w1.accept(e);
        w1.accept(warrior);
        w1.accept(w2);
    }

    @Test
    void visit() {
        w1.visit(e);
        w2.visit(e);
    }

    @Test
    void testVisit() {
        w1.visit(warrior);
        w2.visit(warrior);
    }

    @Test
    void testVisit1() {
        w1.visit(w2);
    }

}