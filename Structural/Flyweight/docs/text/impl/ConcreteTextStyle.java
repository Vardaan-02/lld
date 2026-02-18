package Structural.Flyweight.docs.text.impl;

import Structural.Flyweight.docs.text.TextStyle;

public class ConcreteTextStyle implements TextStyle{
    private String font;
    private int size;
    private String color;
    private Boolean italic;
    private Boolean bold;
    
    public ConcreteTextStyle(String font, int size, String color, Boolean italic, Boolean bold){
        this.font = font;
        this.size = size;
        this.color = color;
        this.italic = italic;
        this.bold = bold;
    }

    public void render(int x, int y, char ch){
        System.out.println(
                "Rendering '" + ch + "' at (" + x + "," + y + ") " +
                "font=" + font +
                ", size=" + size +
                ", color=" + color +
                ", bold=" + bold +
                ", italic=" + italic
        );
    }
}
