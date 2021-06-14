package Tests.TilesTests.UnitsTests.PlayersTests;

import BL.ConsoleColors;
import BL.Tiles.Players.Rogue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RogueTest {

    static Rogue r1;
    static Rogue r2;
    static Rogue r3;

    @BeforeAll
    static void setUp() {
        r1 = new Rogue('@', 3, 4, "Arya Stark", 150, 40, 2, 20);
        r2 = new Rogue('@', 1, 5, "Bronn", 250, 35, 3, 50);
    }

    @Test
    void testToString() {
        String s1 = r1.toString();
        assertEquals(s1, ConsoleColors.PURPLE + '@' + ConsoleColors.RESET);

        String s2 = r2.toString();
        assertEquals(s2, ConsoleColors.PURPLE + '@' + ConsoleColors.RESET);

    }

    @Test
    void description() {
        String d1 = "Arya Stark's description: Health pool: 150, Health amount: 150, Attack points: 40, Defense points: 2, Level: 1, Experience value: 0\n" +
                "      Special Ability: Fan of Knives, Cost: 20, Current Energy: 100";
        assertEquals(r1.description(), d1);
        String d2 = "Bronn's description: Health pool: 250, Health amount: 250, Attack points: 35, Defense points: 3, Level: 1, Experience value: 0\n" +
                "      Special Ability: Fan of Knives, Cost: 50, Current Energy: 100";
        assertEquals(r2.description(), d2);
    }
}