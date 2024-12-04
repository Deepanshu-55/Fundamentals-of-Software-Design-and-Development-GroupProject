// WildCard.java
// Represents wild cards, including the Wild card and the Wild Draw Four card
public class WildCard extends Card {
    public WildCard(String value) {
        super("Wild", value);
    }

    @Override
    public void playEffect(Game game) {
        switch (value) {
            case "Wild":
                System.out.println("Wild card played! Choose a new color.");
                game.chooseNewColor();
                break;
            case "Draw Four":
                System.out.println("Wild Draw Four card played! Next player draws four cards and a new color is chosen.");
                game.drawCards(4);
                game.chooseNewColor();
                break;
            default:
                throw new IllegalArgumentException("Invalid Wild Card");
        }
    }
}
