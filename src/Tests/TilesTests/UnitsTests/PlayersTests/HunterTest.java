package Tests.TilesTests.UnitsTests.PlayersTests;

import BL.ConsoleColors;
import BL.Tiles.Players.Hunter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HunterTest {

    static Hunter h1;

    @BeforeAll
    static void setUp() {
        h1 = new Hunter('@', 2, 3, "Ygritte" , 220, 30, 2, 6);
    }

    @Test
    void testToString() {
        String s1= h1.toString();
        assertEquals(s1, ConsoleColors.CYAN_BOLD + '@' + ConsoleColors.RESET);
    }

    @Test
    void description() {
        String d1= "Ygritte's description: Health pool: 220, Health amount: 220, Attack points: 30, Defense points: 2, Level: 1, Experience value: 0\n" +
                "      Special Ability: Shoot, Range: 6, Arrow count: 10, Ticks count: 0";
        assertEquals(h1.description(),d1);
    }



}