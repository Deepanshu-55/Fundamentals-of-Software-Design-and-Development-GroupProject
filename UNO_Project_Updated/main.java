import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(Arrays.asList("Alice", "Bob", "Charlie", "Diana"));
        while (!game.isGameOver()) {
            game.playTurn();
        }
    }
}
