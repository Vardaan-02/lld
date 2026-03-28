package main.java;

import main.java.factories.MoveFactory;
import main.java.models.GameSession;
import main.java.rules.StandardChessRuleEngine;
import main.java.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        GameSession session = new GameSession();
        MoveFactory factory = new MoveFactory();
        StandardChessRuleEngine engine = new StandardChessRuleEngine(factory);

        ConsoleUI ui = new ConsoleUI(session, engine);
        ui.start();
    }
}