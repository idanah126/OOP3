package Tests.TilesTests;

import BL.Tiles.Empty;
import BL.Tiles.Players.Warrior;
import BL.Tiles.Wall;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EmptyTest {

    static Empty e1;
    static Warrior w;
    static Wall wall;
    static Empty e2;

    @BeforeAll
    static void setUp() {
        e1 = new Empty(2, 3);
        w = new Warrior('w', 2,3,"test",3,4,2,1);
        wall = new Wall(2,3);
        e2 = new Empty(6,5);
    }


    @Test
    void accept() {
        e1.accept(w);
        e1.accept(wall);
        e1.accept(e2);

    }

    @Test
    void visit() {
        e1.visit(w);
    }

    @Test
    void testVisit() {
        e1.visit(wall);
    }

    @Test
    void testVisit1() {
        e1.visit(e2);
    }

}