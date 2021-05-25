import java.util.Random;

public class MathOperations {

    private static final MathOperations d = new MathOperations();

    private MathOperations(){}

    public static MathOperations getInstance(){
        return d;
    }

    public double getDistance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
    }

    public int random(int max){
        Random random = new Random();
        return random.nextInt(max);
    }
}
