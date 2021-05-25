import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("welcome!");
        List<String> board = readAllLines("levels_dir/level1.txt");
        for (String s: board
             ) {
            System.out.println(s);
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
