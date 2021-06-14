package Tests.TilesTests.UnitsTests.EnemysTests;

import BL.ConsoleColors;
import BL.Tiles.Enemies.Trap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrapTest {

    static Trap t1;
    static Trap t2;
    static Trap t3;

    @BeforeAll
    static void setUp() {
        t1 = new Trap('B', 8, 7, "Bonus Trap", 1, 1, 1, 250, 1,  5);
        t2 = new Trap('Q', 5, 2,  "Queen's Trap" , 250, 50, 10, 100, 3, 7);
        t3 = new Trap('D', 4, 5,  "Death Trap", 500, 100, 20, 250, 1, 10);
    }

    @Test
    void testToString() {
        String s1= t1.toString();
        assertEquals(s1,ConsoleColors.YELLOW + 'B' + ConsoleColors.RESET);

        String s2= t2.toString();
        assertEquals(s2,ConsoleColors.YELLOW + 'Q' + ConsoleColors.RESET);

        String s3= t3.toString();
        assertEquals(s3,ConsoleColors.YELLOW + 'D' + ConsoleColors.RESET);
    }

    @Test
    void description() {
        String d1= "Bonus Trap's description: Health pool: 1, Health amount: 1, Attack points: 1, Defense points: 1, Experience value: 250, Visibility time: 1, Invisibility time: 5, Ticks Count: 0, Visible: true";
        assertEquals(t1.description(),d1);
        String d2="Queen's Trap's description: Health pool: 250, Health amount: 250, Attack points: 50, Defense points: 10, Experience value: 100, Visibility time: 3, Invisibility time: 7, Ticks Count: 0, Visible: true";
        assertEquals(t2.description(),d2);
        String d3="Death Trap's description: Health pool: 500, Health amount: 500, Attack points: 100, Defense points: 20, Experience value: 250, Visibility time: 1, Invisibility time: 10, Ticks Count: 0, Visible: true";
        assertEquals(t3.description(),d3);

    }
}