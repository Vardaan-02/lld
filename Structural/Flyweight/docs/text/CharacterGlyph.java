package Structural.Flyweight.docs.text;

public class CharacterGlyph {
    private final char character;
    private final int x;
    private final int y;
    private final TextStyle style;

    public CharacterGlyph(char character, int x, int y, TextStyle style) {
        this.character = character;
        this.x = x;
        this.y = y;
        this.style = style;
    }

    public void draw() {
        style.render(x, y, character);
    }
}
