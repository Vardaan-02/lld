package main.java.state;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import main.java.config.GameConfig;
import main.java.consumable.Consumable;
import main.java.consumable.ConsumableFactory;
import main.java.entity.Point;
import main.java.entity.Snake;

public class GameState {
    private final GameConfig config;
    private final Snake snake;
    private final Map<Point, Consumable> activeItems;
    
    private int score;
    private long currentTickDelay;
    private boolean isGameOver;

    public GameState(GameConfig config, Snake snake) {
        this.config = config;
        this.snake = snake;
        this.activeItems = new HashMap<>();
        this.score = 0;
        this.currentTickDelay = config.initialTickDelay();
        this.isGameOver = false;
    }

    public int getScore() { return score; }
    public boolean isGameOver() { return isGameOver; }
    public GameConfig getConfig() { return config; }
    public Snake getSnake() { return snake; }
    public Map<Point, Consumable> getActiveItems() { return activeItems; }
    public long getCurrentTickDelay() { return currentTickDelay; }

    public void addScore(int points) { this.score += points; }
    public void decreaseTickDelay(long amount) { 
        this.currentTickDelay = Math.max(50L, this.currentTickDelay - amount); 
    }
    public void setGameOver(boolean gameOver) { this.isGameOver = gameOver; }
    public void addItem(Point p, Consumable item) { activeItems.put(p, item); }
    public Consumable consumeItemAt(Point p) { return activeItems.remove(p); }

    public boolean isOutOfBounds(Point p) {
        return p.x() < 0 || p.x() >= config.width() || p.y() < 0 || p.y() >= config.height();
    }

    public GameStateMemento createMemento() {
        List<Point> serializedBody = snake.getBodyList();
        Map<Point, String> serializedItems = new HashMap<>();
        for (Map.Entry<Point, Consumable> entry : activeItems.entrySet()) {
            serializedItems.put(entry.getKey(), entry.getValue().getClass().getSimpleName());
        }
        return new GameStateMemento(serializedBody, serializedItems, this.score, this.currentTickDelay);
    }

    public void restore(GameStateMemento memento) {
        this.score = memento.score();
        this.currentTickDelay = memento.currentTickDelay();
        this.snake.rebuildFromList(memento.snakeBody());
        this.activeItems.clear();
        for (Map.Entry<Point, String> entry : memento.activeItems().entrySet()) {
            Consumable item = ConsumableFactory.createFromName(entry.getValue());
            if (item != null) this.activeItems.put(entry.getKey(), item);
        }
    }
}