import java.util.LinkedList;
import java.util.List;

public class Board implements UIObserver, BoardObservable, UnitObserver {

    private boolean active;
    private boolean lost;
    private BoardObserver boardController;
    private List<Tile> board;
    private Player player;
    private List<Monster> monsterList;
    private List<Trap> trapList;
    private List<Enemy> enemyList;
    private final int numOfRows;
    private final int numOfColumns;

    public Board(List<String> lines, char c, BoardObserver boardController){
        lost = false;
        active = true;
        numOfRows = lines.size();
        numOfColumns = lines.get(0).length();
        enemyList = new LinkedList<>();
        trapList = new LinkedList<>();
        monsterList = new LinkedList<>();
        board = new LinkedList<>();
        int index = 0;
        for (String line: lines) {
            for (int i = 0; i < numOfColumns; i++) {
                if(line.charAt(i) == '.'){
                    board.add(new Empty(index, i));
                }
                else if(line.charAt(i) == '#'){
                    board.add(new Wall(index, i));
                }
                else if(line.charAt(i) == '@'){
                    player = UnitList.getPlayer(c, index, i, enemyList, this);
                    board.add(player);
                }
                else if(line.charAt(i) == 'B' | line.charAt(i) == 'Q' | line.charAt(i) == 'D'){
                    Trap trap = UnitList.getTrap(line.charAt(i), index, i, player, this);
                    trapList.add(trap);
                    enemyList.add(trap);
                    board.add(trap);
                }
                else{
                    Monster monster = UnitList.getMonster(line.charAt(i), index, i, player, this);
                    monsterList.add(monster);
                    enemyList.add(monster);
                    board.add(monster);
                }
            }
            index += 1;
        }
        addObserver(boardController);
    }

    @Override
    public void addObserver(BoardObserver o) {
        boardController = o;
    }

    @Override
    public void notifyObserverBoard(List<String> lines) {
        boardController.updateBoard(lines);
    }

    @Override
    public void notifyObserverStats(String stats) {
        boardController.updateStats(stats);
    }

    @Override
    public void notifyObserverCombatInfo(String combatInfo) {
        boardController.updateCombatInfo(combatInfo);
    }

    @Override
    public void notifyObserverLevelUp(String levelUp) {
        boardController.updateLevelUp(levelUp);
    }


    @Override
    public void update(char c) {
        if(c == 'w' | c == 'a' | c == 's' | c == 'd' | c == 'e' | c == 'q'){
            turn(c);
        }
    }

    @Override
    public boolean isActive() {
        return active;
    }

    public double range(Tile tile1,Tile tile2){
        double range = Math.sqrt((tile1.getX()-tile2.getX())*(tile1.getX()-tile2.getX()) + (tile1.getY()-tile2.getY())*(tile1.getY()-tile2.getY()));
        return range;
    }

    public void combat(Tile tile1,Tile tile22){

    }

//    public void moveMonster(Monster m) {
//        double dx;
//        double dy;
//        if (this.range(m, player) < this.visionRange()) {
//            dx = m.getX() - player.getX();
//            dy = m.getX() - player.getX();
//            if (Math.abs(dx) > Math.abs(dy)) {
//                if (dx > 0) {
//                    //monster move left
//                    if (board[m.getX() - 1][m.getY()].getTile() != ('#')) //if it is a block
//                    {
//                        Tile tileTmp = board[m.getX() - 1][m.getY()];
//                        board[m.getX() - 1][m.getY()] = m;
//                        board[m.getX()][m.getY()] = tileTmp;
//                        m.setY(m.getX() - 1);
//                    }
//                } else {
//                    //monster move right
//                    if (board[m.getX() - 1][m.getY()].getTile() != ('#')) //if it is a block
//                    {
//                        Tile tileTmp = board[m.getX() + 1][m.getY()];
//                        board[m.getX() + 1][m.getY()] = m;
//                        board[m.getX()][m.getY()] = tileTmp;
//                        m.setY(m.getX() + 1);
//                    }
//                }
//            } else {
//                if (dy > 0) {
//                    //monster move up
//                    if (board[m.getX()][m.getY() - 1].getTile() != ('#')) //if it is a block
//                    {
//                        Tile tileTmp = board[m.getX()][m.getY() - 1];
//                        board[m.getX()][m.getY() - 1] = m;
//                        board[m.getX()][m.getY()] = tileTmp;
//                        m.setY(m.getY() - 1);
//                    }
//                } else {
//                    //monster move down
//                    if (board[m.getX()][m.getY() + 1].getTile() != ('#')) //if it is a block
//                    {
//                        Tile tileTmp = board[m.getX()][m.getY() + 1];
//                        board[m.getX()][m.getY() + 1] = m;
//                        board[m.getX()][m.getY()] = tileTmp;
//                        m.setY(m.getY() + 1);
//                    }
//                }
//            }
//        }
//        else{
//            this.moveRandomlyMonster(m);
//        }
//    }

        public void moveRandomlyMonster(Monster m) {
            throw new IllegalArgumentException();
        }

        private double visionRange() {
            throw new IllegalArgumentException();
        }

        public void turn(char c){
            player.playerTurn(c);
            for (Enemy enemy: enemyList) {
                enemy.enemyTurn();
            }
            updateBoard();
            notifyObserverBoard(toListOfString(to2dArray()));
            player.notifyObserverStats(player.description());
        }

        public void updateBoard(){
            int index = -1;
            int deadIndex = -1;
            for (Enemy enemy: enemyList) {
                index += 1;
                if(enemy.dead()){
                    board.remove(enemy);
                    board.add(new Empty(enemy.getX(), enemy.getY()));
                    deadIndex = index;
                }
            }
            if(deadIndex != -1){
                enemyList.remove(deadIndex);
            }
            if(enemyList.isEmpty()){
                active = false;
            }
            if(player.dead()){
                player.setDead();
                lost = true;
            }
        }

        public Tile getTile(int x, int y){
            for (Tile tile: board) {
                if(tile.getX() == x && tile.getY() == y){
                    return tile;
                }
            }
            return null;
        }

        private char[][] to2dArray(){
            char[][] boardChar = new char[numOfRows][numOfColumns];
            for (Tile tile: board) {
                boardChar[tile.getX()][tile.getY()] = tile.getTile();
            }
            return boardChar;
        }

        public List<String> toListOfString(char[][] board){
            List<String> lines = new LinkedList<>();
            for (int i = 0; i < numOfRows; i++) {
                String s = "";
                for (int j = 0; j < numOfColumns; j++) {
                    s += board[i][j];
                }
                lines.add(s);
            }
            return lines;
        }

    @Override
    public void updateStats(String stats) {
        notifyObserverStats(stats);
    }

    @Override
    public void updateCombatInfo(String combatInfo) {
        notifyObserverCombatInfo(combatInfo);
    }

    @Override
    public void updateLevelUp(String levelUp) {
        notifyObserverLevelUp(levelUp);
    }
}