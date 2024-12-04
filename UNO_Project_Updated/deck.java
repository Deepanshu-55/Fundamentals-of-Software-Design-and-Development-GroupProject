// Manages the UNO deck, including initialization, shuffling, and drawing cards
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    private void initializeDeck() {
        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        String[] numberValues = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] actionValues = {"Skip", "Reverse", "Draw Two"};

        for (String color : colors) {
            for (String value : numberValues) {
                cards.add(new NumberCard(color, value));
                cards.add(new NumberCard(color, value)); // Add duplicate cards.
            }
            for (String value : actionValues) {
                cards.add(new ActionCard(color, value));
                cards.add(new ActionCard(color, value));
            }
        }

        // Add Wild cards
        for (int i = 0; i < 4; i++) {
            cards.add(new WildCard("Wild"));
            cards.add(new WildCard("Draw Four"));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("The deck is empty!");
        }
        return cards.remove(0);
    }

    public void addToDiscardPile(Card card) {
        // Add discarded card to discard pile (to be implemented)
        System.out.println("Card added to discard pile: " + card.getColor() + " " + card.getValue());
    }
}
