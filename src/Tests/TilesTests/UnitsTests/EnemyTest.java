package Tests.TilesTests.UnitsTests;

import BL.Tiles.*;
import BL.Tiles.Enemies.Monster;
import BL.Tiles.Enemies.Trap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EnemyTest {

    static Enemy e1;
    static Enemy e2;

    @BeforeAll
    static void setUp() {
        e1 = new Trap('e',2, 3,"testTrap",5,5,5,5,5,5);
        e2 = new Monster('w', 2,3,"testMonster",3,4,2,1,5);
    }

    @Test
    void visit() {
        e1.visit(e2);
        e2.visit(e1);
    }

}