package Structural.Flyweight.docs.text;

import java.util.concurrent.ConcurrentHashMap;

import Structural.Flyweight.docs.text.impl.ConcreteTextStyle;

public class TextStyleFactory {
    private static final ConcurrentHashMap<String, TextStyle> cache = new ConcurrentHashMap<>();

    public static TextStyle getStyle(String font, int size, String color, Boolean italic, Boolean bold){
        String key = font + "|" + size + "|" + color + "|" + italic + "|" + bold;

        return cache.computeIfAbsent(key, k -> new ConcreteTextStyle(font, size, color, bold, italic));
    }

    public static int totalStylesCreated() {
        return cache.size();
    }
}
