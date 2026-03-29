package main.java;

import main.java.config.GameConfig;
import main.java.engine.GameEngine;
import main.java.entity.Point;
import main.java.entity.Snake;
import main.java.io.ConsoleInputHandler;
import main.java.io.ConsoleRenderer;
import main.java.state.GameState;

public class Main {
    public static void main(String[] args) {
        GameConfig config = new GameConfig(20, 15, 150L);

        Point startPosition = new Point(config.width() / 2, config.height() / 2);
        Snake snake = new Snake(startPosition);

        GameState state = new GameState(config, snake);

        ConsoleInputHandler inputHandler = new ConsoleInputHandler();
        ConsoleRenderer renderer = new ConsoleRenderer();

        GameEngine engine = new GameEngine(state, inputHandler, renderer);

        System.out.println("Starting Snake Game... Press WASD to move.");
        engine.run();
    }
}