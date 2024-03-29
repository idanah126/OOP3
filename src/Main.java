import BL.ConsoleColors;
import BL.Tiles.Player;
import BL.UnitList;
import PL.UI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File directory = new File(args[0]);
        int fileCount = directory.list().length;
        String lvl = "/level";
        String txt = ".txt";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your character");
        System.out.println(ConsoleColors.BLUE + "Warriors:");
        System.out.println("j for Jon Snow, h for The Hound");
        System.out.println(ConsoleColors.RED + "Mages:");
        System.out.println("m for Melisandre, t for Thoros of Myr");
        System.out.println(ConsoleColors.PURPLE + "Rogues:");
        System.out.println("a for Arya Stark, b for Bronn");
        System.out.println(ConsoleColors.CYAN_BOLD + "Hunters:");
        System.out.println("y for Ygritte" + ConsoleColors.RESET);
        String choosePlayer = scanner.nextLine();
        while(choosePlayer.length() != 1 | (choosePlayer.charAt(0) != 'j' & choosePlayer.charAt(0) != 'h' & choosePlayer.charAt(0) != 'm' & choosePlayer.charAt(0) != 't' & choosePlayer.charAt(0) != 'a' & choosePlayer.charAt(0) != 'b' & choosePlayer.charAt(0) != 'y')){
            choosePlayer = scanner.nextLine();
        }
        char character = choosePlayer.charAt(0);
        Player player = UnitList.getPlayer(character, 0, 0);
        boolean hasLost = false;
        for (int i = 1; i <= fileCount && !hasLost; i++) {
            List<String> stringBoard = readAllLines(args[0] + lvl + i + txt);
            UI ui = new UI(stringBoard, player);
            System.out.println("Level " + i);
            System.out.println("Press q to start");
            while(ui.isActive() & !ui.hasLost()){
                String play = scanner.nextLine();
                if(play.length() == 1) {
                    char move = play.charAt(0);
                    ui.notifyObserver(move);
                }
            }
            hasLost = ui.hasLost();
        }
    }

    public static List<String> readAllLines(String path){
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(path));
        }catch (IOException e){
            System.out.println(e.getMessage() + "\n" + e.getStackTrace());
        }
        return lines;
    }
}
