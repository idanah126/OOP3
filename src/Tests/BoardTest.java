package Tests;


import BL.Board;
import BL.Tiles.Player;
import BL.UnitList;
import PL.BoardController;
import PL.UI;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

class BoardTest {

    static List<String> lst;
    static Player p;
    static UI ui;
    static BoardController bc;
    static Board b;

    @BeforeAll
    static void setUp() {
        lst = new LinkedList<>();
        lst.add("#####");
        lst.add("#@..#");
        lst.add("#..k#");
        lst.add("#.Q.#");
        lst.add("#####");
        p = UnitList.getPlayer('j', 0, 0);
        ui = new UI(lst, p);
        bc = new BoardController(lst, p, ui);
        b = new Board(lst, p, bc);
    }

    @Test
    void addObserver() {
        b.addObserver(bc);
    }

    @Test
    void notifyObserverBoard() {
        b.notifyObserverBoard(lst);
    }

    @Test
    void notifyObserverStats() {
        b.notifyObserverStats("check notify stats");
    }

    @Test
    void notifyObserverCombatInfo() {
        b.notifyObserverStats("check notify combat");

    }

    @Test
    void notifyObserverLevelUp() {
        b.notifyObserverStats("check notify level up");

    }

    @Test
    void update() {
        b.update('d');
    }

    @Test
    void isActive() {
        assertTrue(b.isActive());
    }

    @Test
    void hasLost() {
        assertFalse(b.hasLost());
    }

    @Test
    void turn() {
        b.turn('s');
    }

    @Test
    void updateBoard() {
        b.updateBoard();
    }

    @Test
    void getTile() {
        assertEquals(b.getTile(0,0).getTile(), '#');
    }

    @Test
    void toListOfString() {
        b.toListOfString(new String[][]{{"#","#","#","#","#"},{"#",".","@",".","#"},{"#","Q","k",".","#"},{"#",".",".",".","#"},{"#","#","#","#","#"}});
    }

    @Test
    void updateStats() {
        b.updateStats("check update stats");
    }

    @Test
    void updateCombatInfo() {
        b.updateCombatInfo("check update combat");
    }

    @Test
    void updateLevelUp() {
        b.updateLevelUp("check update level up");
    }
}