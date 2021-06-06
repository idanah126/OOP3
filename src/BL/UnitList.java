package BL;

import BL.Tiles.*;
import BL.Tiles.Enemies.Monster;
import BL.Tiles.Enemies.Trap;
import BL.Tiles.Players.Mage;
import BL.Tiles.Players.Rogue;
import BL.Tiles.Players.Warrior;

public class UnitList {

    public static Player getPlayer(char c, int x, int y) {
        if (c == 'j') {
            return new Warrior('@', x, y, ConsoleColors.BLUE + "Jon Snow" + ConsoleColors.RESET, 300, 30, 4, 3);
        }
        else if (c == 'h') {
            return new Warrior('@', x, y, ConsoleColors.BLUE + "The Hound" + ConsoleColors.RESET, 400, 20, 6, 5);
        }
        else if (c == 'm') {
            return new Mage('@', x, y, ConsoleColors.RED + "Melisandre" + ConsoleColors.RESET, 100, 5, 1, 300, 30, 15, 5, 6);
        }
        else if (c == 't') {
            return new Mage('@', x, y, ConsoleColors.RED + "Thoros of Myr" + ConsoleColors.RESET, 250, 25, 4, 150, 20, 20, 3, 4);
        }
        else if (c == 'a') {
            return new Rogue('@', x, y, ConsoleColors.PURPLE + "Arya Stark" + ConsoleColors.RESET, 150, 40, 2, 20);
        }
        else if (c == 'b') {
            return new Rogue('@', x, y, ConsoleColors.PURPLE + "Bronn" + ConsoleColors.RESET, 250, 35, 3, 50);
        }
        else {
            throw new IllegalArgumentException("not legal char");
        }
    }

    public static Trap getTrap(char c, int x, int y){
        if(c == 'B'){
            return new Trap('B', x, y, ConsoleColors.YELLOW + "Bonus Trap" + ConsoleColors.RESET, 1, 1, 1, 250, 1,  5);
        }
        else if(c == 'Q'){
            return new Trap('Q', x, y, ConsoleColors.YELLOW + "Queen's Trap" + ConsoleColors.RESET, 250, 50, 10, 100, 3, 7);
        }
        else if(c == 'D'){
            return new Trap('D', x, y, ConsoleColors.YELLOW + "Death Trap" + ConsoleColors.RESET, 500, 100, 20, 250, 1, 10);
        }
        else{
            throw new IllegalArgumentException("not legal char");
        }
    }

    public static Monster getMonster(char c, int x, int y){
        if (c == 's') {
            return new Monster('s', x, y, ConsoleColors.GREEN + "Lannister Solider" + ConsoleColors.RESET, 80, 8, 3, 25, 3);
        }
        else if (c == 'k') {
            return new Monster('k', x, y, ConsoleColors.GREEN + "Lannister Knight" + ConsoleColors.RESET, 200, 14, 8, 50, 4);
        }
        else if (c == 'q') {
            return new Monster('q', x, y, ConsoleColors.GREEN + "Queen's Guard" + ConsoleColors.RESET, 400, 20, 15, 100, 5);
        }
        else if (c == 'z') {
            return new Monster('z', x, y, ConsoleColors.GREEN + "Wright" + ConsoleColors.RESET, 600, 30, 15, 100, 3);
        }
        else if (c == 'b') {
            return new Monster('b', x, y, ConsoleColors.GREEN + "Bear-Wright" + ConsoleColors.RESET, 1000, 75, 30, 250, 4);
        }
        else if (c == 'g') {
            return new Monster('g', x, y, ConsoleColors.GREEN + "Giant-Wright" + ConsoleColors.RESET, 1500, 100, 40, 500, 5);
        }
        else if (c == 'w') {
            return new Monster('w', x, y, ConsoleColors.GREEN + "White Walker" + ConsoleColors.RESET, 2000, 150, 50, 1000, 6);
        }
        else if (c == 'M') {
            return new Monster('M', x, y, ConsoleColors.GREEN + "The Mountain" + ConsoleColors.RESET, 1000, 60, 25, 500, 6);
        }
        else if (c == 'C') {
            return new Monster('C', x, y, ConsoleColors.GREEN + "Queen Cersei" + ConsoleColors.RESET, 100, 10, 10, 1000, 1);
        }
        else if (c == 'K') {
            return new Monster('K', x, y, ConsoleColors.GREEN + "Knight's King" + ConsoleColors.RESET, 5000, 300, 150, 5000, 8);
        }
        else {
            throw new IllegalArgumentException("not legal char");
        }
    }

}
