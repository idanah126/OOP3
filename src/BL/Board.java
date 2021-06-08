package BL;

import BL.ObserverPattern.BoardObservable;
import BL.ObserverPattern.BoardObserver;
import BL.ObserverPattern.UIObserver;
import BL.ObserverPattern.UnitObserver;
import BL.Tiles.*;
import BL.Tiles.Enemies.Monster;
import BL.Tiles.Enemies.Trap;

import java.util.LinkedList;
import java.util.List;

public class Board implements UIObserver, BoardObservable, UnitObserver {

    private boolean active;
    private boolean lost;
    private BoardObserver boardController;
    private final List<Tile> board;
    private Player player;
    private final List<Enemy> enemyList;
    private final int numOfRows;
    private final int numOfColumns;

    public Board(List<String> lines, Player player, BoardObserver boardController){
        lost = false;
        active = true;
        numOfRows = lines.size();
        numOfColumns = lines.get(0).length();
        enemyList = new LinkedList<>();
        board = new LinkedList<>();

        // Find the player before all other tiles.
        for (int i = 0; i < lines.size(); i++) {
            int y = lines.get(i).indexOf('@');
            if (y != -1) {
                this.player = player;
                player.setX(i);
                player.setY(y);
            }
        }

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
                    board.add(player);
                }
                else if(line.charAt(i) == 'B' | line.charAt(i) == 'Q' | line.charAt(i) == 'D'){
                    Trap trap = UnitList.getTrap(line.charAt(i), index, i);
                    trap.initialize(this, player);
                    enemyList.add(trap);
                    board.add(trap);
                }
                else{
                    Monster monster = UnitList.getMonster(line.charAt(i), index, i);
                    monster.initialize(this, player);
                    enemyList.add(monster);
                    board.add(monster);
                }
            }
            index += 1;
        }
        player.initialize(this, enemyList);
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

    @Override
    public boolean hasLost() {
        return lost;
    }

    public void turn(char c){
        player.playerTurn(c);
        for (Enemy enemy: enemyList) {
            enemy.enemyTurn();
        }
        updateBoard();
        notifyObserverBoard(toListOfString(to2dArray()));
        if(player.dead()){
            notifyObserverCombatInfo("the player is dead");
        }
        else {
            notifyObserverStats(player.description());
        }
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

    private String[][] to2dArray(){
        String[][] boardChar = new String[numOfRows][numOfColumns];
        for (Tile tile: board) {
            boardChar[tile.getX()][tile.getY()] = tile.toString();
        }
        return boardChar;
    }

    public List<String> toListOfString(String[][] board){
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