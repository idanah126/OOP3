import java.util.LinkedList;
import java.util.List;

public class Board implements UIObserver, BoardObservable {

    private BoardObserver boardController;
    private List<Tile> tileList;
    private Player player;
    private List<Monster> monsterList;
    private List<Trap> trapList;
    private List<Enemy> enemyList;
    private int number_of_rows;
    private int number_of_columns;

    public Board(List<String> lines, char c, BoardObserver boardController){
        enemyList = new LinkedList<>();
        trapList = new LinkedList<>();
        monsterList = new LinkedList<>();
        board = new Tile[lines.size()][];
        int index = 0;
        int playerX = 0;
        int playerY = 0;
        for (String line: lines) {
            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == '.'){
                    board[index][i] = new Empty(index, i);
                }
                else if(line.charAt(i) == '#'){
                    board[index][i] = new Wall(index, i);
                }
                else if(line.charAt(i) == '@'){
                    playerX = index;
                    playerY = i;
                }
                else if(line.charAt(i) == 'B' | line.charAt(i) == 'Q' | line.charAt(i) == 'D'){
                    Trap trap = UnitList.getTrap(line.charAt(i), index, i);
                    trapList.add(trap);
                    enemyList.add(trap);
                    board[index][i] = trap;
                }
                else{
                    Monster monster = UnitList.getMonster(line.charAt(i), index, i);
                    monsterList.add(monster);
                    enemyList.add(monster);
                    board[index][i] = monster;
                }
            }
        }
        player = UnitList.getPlayer(c, playerX, playerY, enemyList);
        board[playerX][playerY] = player;
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

    }

    @Override
    public void notifyObserverLevelUp(String levelUp) {

    }

    @Override
    public void update(char c) {
        if(c == 'w' | c == 'a' | c == 's' | c == 'd' | c == 'e' | c == 'q'){
            move(c);
        }
    }

    public double range(Tile tile1,Tile tile2){
        double range = Math.sqrt((tile1.getX()-tile2.getX())*(tile1.getX()-tile2.getX()) + (tile1.getY()-tile2.getY())*(tile1.getY()-tile2.getY()));
        return range;
    }

    public void combat(Tile tile1,Tile tile22){

    }

    public void moveMonster(Monster m) {
        double dx;
        double dy;
        if (this.range(m, player) < this.visionRange()) {
            dx = m.getX() - player.getX();
            dy = m.getX() - player.getX();
            if (Math.abs(dx) > Math.abs(dy)) {
                if (dx > 0) {
                    //monster move left
                    if (board[m.getX() - 1][m.getY()].getTile() != ('#')) //if it is a block
                    {
                        Tile tileTmp = board[m.getX() - 1][m.getY()];
                        board[m.getX() - 1][m.getY()] = m;
                        board[m.getX()][m.getY()] = tileTmp;
                        m.setY(m.getX() - 1);
                    }
                } else {
                    //monster move right
                    if (board[m.getX() - 1][m.getY()].getTile() != ('#')) //if it is a block
                    {
                        Tile tileTmp = board[m.getX() + 1][m.getY()];
                        board[m.getX() + 1][m.getY()] = m;
                        board[m.getX()][m.getY()] = tileTmp;
                        m.setY(m.getX() + 1);
                    }
                }
            } else {
                if (dy > 0) {
                    //monster move up
                    if (board[m.getX()][m.getY() - 1].getTile() != ('#')) //if it is a block
                    {
                        Tile tileTmp = board[m.getX()][m.getY() - 1];
                        board[m.getX()][m.getY() - 1] = m;
                        board[m.getX()][m.getY()] = tileTmp;
                        m.setY(m.getY() - 1);
                    }
                } else {
                    //monster move down
                    if (board[m.getX()][m.getY() + 1].getTile() != ('#')) //if it is a block
                    {
                        Tile tileTmp = board[m.getX()][m.getY() + 1];
                        board[m.getX()][m.getY() + 1] = m;
                        board[m.getX()][m.getY()] = tileTmp;
                        m.setY(m.getY() + 1);
                    }
                }
            }
        }
        else{
            this.moveRandomlyMonster(m);
        }
    }

        public void moveRandomlyMonster(Monster m) {
            throw new IllegalArgumentException();
        }


        private double visionRange() {
            throw new IllegalArgumentException();
        }

        public void movePlayer(){
            throw new IllegalArgumentException();
        }

        public void move(char c){

        }

        public String toString(){
            String boardString = "";
            for (int i = 0 ; i < this.number_of_rows ; i++)
            {
                for (int j = 0 ; j < this.number_of_columns ; j++){
                    boardString+= board[i][j].toString();}
                boardString+= "\n";
            }
            return boardString;
        }

        private List<String> toList(){
            List<String> lines = new LinkedList<>();
            for (Tile[] tiles : board) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < tiles.length; j++) {
                    line.append(tiles[j].toString());
                }
                lines.add(line.toString());
            }
            return lines;
        }
    }