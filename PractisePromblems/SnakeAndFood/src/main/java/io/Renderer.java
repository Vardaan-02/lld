package main.java.io;

import main.java.state.GameState;

public interface Renderer {
    void render(GameState state);

    void showGameOver(int score);
}