package Tests.TilesTests.UnitsTests.PlayersTests;

import BL.ConsoleColors;
import BL.Tiles.Players.Mage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MageTest {

    static Mage m1;
    static Mage m2;
    static Mage m3;

    @BeforeAll
    static void setUp() {
        m1 = new Mage('@', 5, 4, "Melisandre", 100, 5, 1, 300, 30, 15, 5, 6);
        m2 = new Mage('@', 3, 2, "Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4);
    }

    @Test
    void testToString() {
        String s1 = m1.toString();
        assertEquals(s1, ConsoleColors.RED + '@' + ConsoleColors.RESET);

        String s2 = m2.toString();
        assertEquals(s2, ConsoleColors.RED + '@' + ConsoleColors.RESET);

    }

    @Test
    void description() {
        String d1 = "Melisandre's description: Health pool: 100, Health amount: 100, Attack points: 5, Defense points: 1, Level: 1, Experience value: 0\n" +
                "      Special Ability: Blizzard, Mana pool: 300, Current mana: 75, Mana cost: 30, Spell power: 15, Hits count: 5, Ability range: 6";
        assertEquals(m1.description(), d1);
        String d2 = "Thoros of Myr's description: Health pool: 250, Health amount: 250, Attack points: 25, Defense points: 4, Level: 1, Experience value: 0\n" +
                "      Special Ability: Blizzard, Mana pool: 150, Current mana: 37, Mana cost: 20, Spell power: 20, Hits count: 3, Ability range: 4";
        assertEquals(m2.description(), d2);
    }
}