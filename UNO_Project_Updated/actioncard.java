// Represents cards like Skip, Reverse, and Draw Two, which have special effects during gameplay
public class ActionCard extends Card {
    public ActionCard(String color, String value) {
        super(color, value);
    }

    @Override
    public void playEffect(Game game) {
        switch (value) {
            case "Skip":
                System.out.println("Next player is skipped!");
                game.skipNextPlayer();
                break;
            case "Reverse":
                System.out.println("Play direction is reversed!");
                game.reverseDirection();
                break;
            case "Draw Two":
                System.out.println("Next player draws two cards!");
                game.drawCards(2);
                break;
            default:
                throw new IllegalArgumentException("Invalid Action Card");
        }
    }
}
