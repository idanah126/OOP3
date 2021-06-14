package Tests.TilesTests.UnitsTests.PlayersTests;

import BL.ConsoleColors;
import BL.Tiles.Players.Warrior;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WarriorTest {

    static Warrior w1;
    static Warrior w2;

    @BeforeAll
    static void setUp() {
        w1 = new Warrior('@', 3, 6, "Jon Snow", 300, 30, 4, 3);
        w2 = new Warrior('@', 2, 5, "The Hound", 400, 20, 6, 5);
    }

    @Test
    void testToString() {
        String s1 = w1.toString();
        assertEquals(s1, ConsoleColors.BLUE + '@' + ConsoleColors.RESET);

        String s2 = w2.toString();
        assertEquals(s2, ConsoleColors.BLUE + '@' + ConsoleColors.RESET);

    }

    @Test
    void description() {
        String d1 = "Jon Snow's description: Health pool: 300, Health amount: 300, Attack points: 30, Defense points: 4, Level: 1, Experience value: 0\n" +
                "      Special Ability: Avenger's Shield, Ability coolDown: 3, Remaining coolDown: 0";
        assertEquals(w1.description(), d1);
        String d2 = "The Hound's description: Health pool: 400, Health amount: 400, Attack points: 20, Defense points: 6, Level: 1, Experience value: 0\n" +
                "      Special Ability: Avenger's Shield, Ability coolDown: 5, Remaining coolDown: 0";
        assertEquals(w2.description(), d2);
    }
}