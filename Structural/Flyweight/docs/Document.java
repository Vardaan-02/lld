package Structural.Flyweight.docs;

import java.util.ArrayList;
import java.util.List;

import Structural.Flyweight.docs.text.CharacterGlyph;
import Structural.Flyweight.docs.text.TextStyle;
import Structural.Flyweight.docs.text.TextStyleFactory;

public class Document {
    private final List<CharacterGlyph> characters = new ArrayList<>();

    public void addCharacter(char c, int x, int y, String font, int size,String color, boolean bold, boolean italic) {

        TextStyle style = TextStyleFactory.getStyle(font, size, color, bold, italic);

        characters.add(new CharacterGlyph(c, x, y, style));
    }

    public void render() {
        for (CharacterGlyph g : characters) {
            g.draw();
        }
    }
}
