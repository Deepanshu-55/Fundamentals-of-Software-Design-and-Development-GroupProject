// NumberCard.java
public class NumberCard extends Card {
    public NumberCard(String color, String value) {
        super(color, value);
    }

    @Override
    public void playEffect(Game game) {
        // No special effect for number cards.
        System.out.println("Played a " + color + " " + value + " card.");
    }
}
