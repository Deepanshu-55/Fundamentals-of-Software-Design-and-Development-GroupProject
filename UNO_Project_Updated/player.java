// Represents a player in the game, managing their hand and actions during gameplay
// Player.java
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private boolean declaredUno;
    private int score;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.declaredUno = false;
        this.score = 0;
    }

    public void drawCard(Card card) {
        hand.add(card);
    }

    public void playCard(Card card, Game game) {
        if (hand.contains(card)) {
            hand.remove(card);
            card.playEffect(game);
            if (hand.size() == 1) {
                declaredUno = false; // Reset UNO declaration
            }
        } else {
            throw new IllegalArgumentException("Player does not have this card!");
        }
    }

    public void declareUno() {
        if (hand.size() == 1) {
            declaredUno = true;
            System.out.println(name + " declares UNO!");
        } else {
            System.out.println(name + " cannot declare UNO right now.");
        }
    }

    public boolean hasDeclaredUno() {
        return declaredUno;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public boolean hasNoCards() {
        return hand.isEmpty();
    }

    public void addScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }
}
