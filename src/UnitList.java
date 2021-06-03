import java.util.List;

public class UnitList {

    public static Player getPlayer(char c, int x, int y, List<Enemy> enemyList, Board board) {
        if (c == 'j') {
            return new Warrior(board, '@', x, y, "Jon Snow", 300, 30, 4, enemyList, 3);
        }
        else if (c == 'h') {
            return new Warrior(board, '@', x, y, "The Hound", 400, 20, 6, enemyList, 5);
        }
        else if (c == 'm') {
            return new Mage(board, '@', x, y, "Melisandre", 100, 5, 1, enemyList, 300, 30, 15, 5, 6);
        }
        else if (c == 't') {
            return new Mage(board, '@', x, y, "Thoros of Myr", 250, 25, 4, enemyList, 150, 20, 20, 3, 4);
        }
        else if (c == 'a') {
            return new Rogue(board, '@', x, y, "Arya Stark", 150, 40, 2, enemyList, 20);
        }
        else if (c == 'b') {
            return new Rogue(board, '@', x, y, "Bronn", 250, 35, 3, enemyList, 50);
        }
        else {
            throw new IllegalArgumentException("not legal char");
        }
    }

    public static Trap getTrap(char c, int x, int y, Player player, Board board){
        if(c == 'B'){
            return new Trap(board, 'B', x, y, "Bonus Trap", 1, 1, 1, 250, player, 1,  5);
        }
        else if(c == 'Q'){
            return new Trap(board, 'Q', x, y, "Queen's Trap", 250, 50, 10, 100, player, 3, 7);
        }
        else if(c == 'D'){
            return new Trap(board, 'D', x, y, "Death Trap", 500, 100, 20, 250, player, 1, 10);
        }
        else{
            throw new IllegalArgumentException("not legal char");
        }
    }

    public static Monster getMonster(char c, int x, int y, Player player, Board board){
        if (c == 's') {
            return new Monster(board, 's', x, y, "Lannister Solider", 80, 8, 3, 25, player, 3);
        }
        else if (c == 'k') {
            return new Monster(board, 'k', x, y, "Lannister Knight", 200, 14, 8, 50, player, 4);
        }
        else if (c == 'q') {
            return new Monster(board, 'q', x, y, "Queen's Guard", 400, 20, 15, 100, player, 5);
        }
        else if (c == 'z') {
            return new Monster(board, 'z', x, y, "Wright", 600, 30, 15, 100, player, 3);
        }
        else if (c == 'b') {
            return new Monster(board, 'b', x, y, "Bear-Wright", 1000, 75, 30, 250, player, 4);
        }
        else if (c == 'g') {
            return new Monster(board, 'g', x, y, "Giant-Wright", 1500, 100, 40, 500, player, 5);
        }
        else if (c == 'w') {
            return new Monster(board, 'w', x, y, "White Walker", 2000, 150, 50, 1000, player, 6);
        }
        else if (c == 'M') {
            return new Monster(board, 'M', x, y, "The Mountain", 1000, 60, 25, 500, player, 6);
        }
        else if (c == 'C') {
            return new Monster(board, 'C', x, y, "Queen Cersei", 100, 10, 10, 1000, player, 1);
        }
        else if (c == 'K') {
            return new Monster(board, 'K', x, y, "Knight's King", 5000, 300, 150, 5000, player, 8);
        }
        else {
            throw new IllegalArgumentException("not legal char");
        }
    }

}
