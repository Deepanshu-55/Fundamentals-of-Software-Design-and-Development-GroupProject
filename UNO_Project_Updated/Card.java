public Card(String color, String value) {
    this.color = color;
    this.value = value;
}

public String getColor() {
    return color;
}

public String getValue() {
    return value;
}
    // Abstract method to define the effect of playing this card
public abstract void playEffect(Game game);