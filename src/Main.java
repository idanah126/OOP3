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
        System.out.println("Warriors:");
        System.out.println("j for Jon Snow, h for The Hound");
        System.out.println("Mages:");
        System.out.println("m for Melisandre, t for Thoros of Myr");
        System.out.println("Rogues:");
        System.out.println("a for Arya Stark, b for Bronn");
        char character = scanner.nextLine().charAt(0);
        for (int i = 1; i <= fileCount; i++) {
            List<String> stringBoard = readAllLines(args[0] + lvl + i + txt);
            UI ui = new UI(stringBoard, character);
            ui.updateBoard(stringBoard);
            while(ui.isActive()){
                String play = scanner.nextLine();
                if(play.length() == 1) {
                    char move = play.charAt(0);
                    ui.notifyObserver(move);
                }
            }
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
