package main.java.persistence;

import main.java.state.GameStateMemento;

public interface PersistenceManager {
    void saveGame(GameStateMemento memento, String filepath);
    GameStateMemento loadGame(String filepath);
    void saveHighScore(int score, String playerName);
}