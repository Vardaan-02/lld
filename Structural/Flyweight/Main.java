package Structural.Flyweight;

import Structural.Flyweight.docs.Document;
import Structural.Flyweight.docs.text.TextStyleFactory;

public class Main {
    public static void main(String[] args) {

        Document doc = new Document();

        doc.addCharacter('H', 0, 0, "Arial", 12, "Black", false, false);
        doc.addCharacter('e', 10, 0, "Arial", 12, "Black", false, false);
        doc.addCharacter('l', 20, 0, "Arial", 12, "Black", false, false);
        doc.addCharacter('l', 30, 0, "Arial", 12, "Black", false, false);
        doc.addCharacter('o', 40, 0, "Arial", 12, "Black", false, false);

        doc.addCharacter('!', 50, 0, "Arial", 12, "Red", true, false);

        doc.render();

        System.out.println("Total styles created: " + TextStyleFactory.totalStylesCreated());
    }
}
