package Tests.TilesTests.UnitsTests.EnemysTests;

import BL.ConsoleColors;
import BL.Tiles.Enemies.Monster;
import BL.UnitList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonsterTest {

    static Monster m1;
    static Monster m2;
    static Monster m3;

    @BeforeAll
    static void setUp() {
        m1 = new Monster('s', 5, 6,"Lannister Solider", 80, 8, 3, 25, 3);
        m2 = new Monster('k', 8, 11,"Lannister Knight", 200, 14, 8, 50, 4);
        m3 = new Monster('q', 3, 2,"Queen's Guard", 400, 20, 15, 100, 5);
    }

    @Test
    void testToString() {
        String s1= m1.toString();
        assertEquals(s1,ConsoleColors.GREEN + 's' + ConsoleColors.RESET);

        String s2= m2.toString();
        assertEquals(s2,ConsoleColors.GREEN + 'k' + ConsoleColors.RESET);

        String s3= m3.toString();
        assertEquals(s3,ConsoleColors.GREEN + 'q' + ConsoleColors.RESET);
    }

    @Test
    void description() {
        String d1= "Lannister Solider's description: Health pool: 80, Health amount: 80, Attack points: 8, Defense points: 3, Experience value: 25, Vision range: 3";
        assertEquals(m1.description(),d1);
        String d2="Lannister Knight's description: Health pool: 200, Health amount: 200, Attack points: 14, Defense points: 8, Experience value: 50, Vision range: 4";
        assertEquals(m2.description(),d2);
        String d3="Queen's Guard's description: Health pool: 400, Health amount: 400, Attack points: 20, Defense points: 15, Experience value: 100, Vision range: 5";
        assertEquals(m3.description(),d3);

    }

}