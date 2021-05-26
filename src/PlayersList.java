public class PlayersList {

    private static final PlayersList p = new PlayersList();

    private PlayersList(){}

    public static PlayersList getInstance(){
        return p;
    }

    public Player getPlayer(char c){
        if(c == 's'){
            return new Warrior("Jon Snow", 300, 30, 4, 3);
        }
        else if(c == 'h'){
            return new Warrior("The Hound", 400, 20, 6, 5);
        }
        else if(c == 'm'){
            return new Mage("Melisandre", 100, 5, 1, 300, 30, 15, 5, 6);
        }
        else if(c == 't'){
            return new Mage("Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4);
        }
        else if(c == 'a'){
            return new Rogue("Arya Stark", 150, 40, 2, 20);
        }
        else if(c == 'b'){
            return new Rogue("Bronn", 250, 35, 3, 50);
        }
        else{
            throw new IllegalArgumentException("not legal char");
        }
    }
}
