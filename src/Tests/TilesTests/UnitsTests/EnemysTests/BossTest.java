package Tests.TilesTests.UnitsTests.EnemysTests;

import BL.ConsoleColors;
import BL.Tiles.Enemies.Boss;
import BL.Tiles.Enemies.Monster;
import BL.Tiles.Enemies.Trap;
import BL.Tiles.Enemy;
import BL.UnitList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BossTest {

    static Boss b1;
    static Boss b2;
    static Boss b3;

    @BeforeAll
    static void setUp() {
        b1 = new Boss('M', 5, 3, "The Mountain", 1000, 60, 25, 500, 6, 5);
        b2 = new Boss('K', 2, 5, "Knight's King", 5000, 300, 150, 5000, 8, 5);
        b3 = new Boss('C', 4, 6, "Queen Cersei", 100, 10, 10, 1000, 1, 5);
    }

    @Test
    void testToString() {
        String s1= b1.toString();
        assertEquals(s1,ConsoleColors.GREEN_BOLD + ConsoleColors.GREEN +  'M' + ConsoleColors.RESET + ConsoleColors.RESET);

        String s2= b2.toString();
        assertEquals(s2,ConsoleColors.GREEN_BOLD + ConsoleColors.GREEN +  'K' + ConsoleColors.RESET + ConsoleColors.RESET);

        String s3= b3.toString();
        assertEquals(s3,ConsoleColors.GREEN_BOLD + ConsoleColors.GREEN +  'C' + ConsoleColors.RESET + ConsoleColors.RESET);
    }

    @Test
    void description() {
        String d1= "The Mountain's description: Health pool: 1000, Health amount: 1000, Attack points: 60, Defense points: 25, Experience value: 500, Vision range: 6, Ability frequency: 5, Combat ticks: 0, Special ability: Shoot";
        assertEquals(b1.description(),d1);
        String d2="Knight's King's description: Health pool: 5000, Health amount: 5000, Attack points: 300, Defense points: 150, Experience value: 5000, Vision range: 8, Ability frequency: 5, Combat ticks: 0, Special ability: Shoot";
        assertEquals(b2.description(),d2);
        String d3="Queen Cersei's description: Health pool: 100, Health amount: 100, Attack points: 10, Defense points: 10, Experience value: 1000, Vision range: 1, Ability frequency: 5, Combat ticks: 0, Special ability: Shoot";
        assertEquals(b3.description(),d3);

    }

}