// Manages the entire game flow, including turns, rules, and player actions
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private Deck deck;
    private Card currentCard;
    private int currentPlayerIndex;
    private int direction; // 1 for clockwise, -1 for counterclockwise
    private List<Card> discardPile;

    public Game(List<String> playerNames) {
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        deck = new Deck();
        dealInitialCards();
        currentCard = deck.drawCard();
        currentPlayerIndex = 0;
        direction = 1;
        discardPile = new ArrayList<>();
    }

    private void dealInitialCards() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck.drawCard());
            }
        }
    }

    public void playTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println(currentPlayer.getName() + "'s turn.");
        System.out.println("Current card: " + currentCard.getColor() + " " + currentCard.getValue());

        // Example turn logic (for demonstration, we just play the first valid card)
        for (Card card : currentPlayer.getHand()) {
            if (isValidMove(card)) {
                currentPlayer.playCard(card, this);
                currentCard = card;
                discardPile.add(card);
                deck.addToDiscardPile(card);
                if (currentPlayer.getHand().size() == 1 && !currentPlayer.hasDeclaredUno()) {
                    System.out.println(currentPlayer.getName() + " forgot to declare UNO! Drawing two penalty cards.");
                    currentPlayer.drawCard(deck.drawCard());
                    currentPlayer.drawCard(deck.drawCard());
                }
                if (currentPlayer.hasNoCards()) {
                    calculateScore(currentPlayer);
                    System.out.println(currentPlayer.getName() + " wins this round with score: " + currentPlayer.getScore());
                }
                break;
            }
        }
        nextPlayer();
    }

    public boolean isValidMove(Card card) {
        return card.getColor().equals(currentCard.getColor()) ||
               card.getValue().equals(currentCard.getValue()) ||
               card.getColor().equals("Wild");
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + direction + players.size()) % players.size();
    }

    public void reverseDirection() {
        direction *= -1;
    }

    public void skipNextPlayer() {
        nextPlayer();
    }

    public void drawCards(int count) {
        Player nextPlayer = players.get((currentPlayerIndex + direction + players.size()) % players.size());
        for (int i = 0; i < count; i++) {
            nextPlayer.drawCard(deck.drawCard());
        }
    }

    public void chooseNewColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a new color (Red, Blue, Green, Yellow): ");
        String newColor = scanner.nextLine();
        currentCard = new WildCard(newColor);
    }

    public void calculateScore(Player winner) {
        int totalScore = 0;
        for (Player player : players) {
            if (!player.equals(winner)) {
                for (Card card : player.getHand()) {
                    totalScore += getCardPoints(card);
                }
            }
        }
        winner.addScore(totalScore);
    }

    private int getCardPoints(Card card) {
        switch (card.getValue()) {
            case "Draw Two":
            case "Reverse":
            case "Skip":
                return 20;
            case "Wild":
            case "Draw Four":
                return 50;
            default:
                return Integer.parseInt(card.getValue());
        }
    }

    public boolean isGameOver() {
        for (Player player : players) {
            if (player.hasNoCards()) {
                System.out.println(player.getName() + " wins the game!");
                return true;
            }
        }
        return false;
    }
}
