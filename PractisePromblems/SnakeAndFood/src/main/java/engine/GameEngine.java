package main.java.engine;

import java.util.ArrayList;
import java.util.List;

import main.java.consumable.Apple;
import main.java.consumable.Consumable;
import main.java.consumable.ConsumableFactory;
import main.java.entity.Direction;
import main.java.entity.Point;
import main.java.io.InputHandler;
import main.java.io.Renderer;
import main.java.state.GameState;

public class GameEngine implements Runnable {

    private final GameState state;
    private final InputHandler inputHandler;
    private final Renderer renderer;

    private volatile Direction currentDirection;
    private volatile boolean isRunning;

    public GameEngine(GameState state, InputHandler inputHandler, Renderer renderer) {
        this.state = state;
        this.inputHandler = inputHandler;
        this.renderer = renderer;
        this.currentDirection = Direction.RIGHT;
        this.isRunning = false;
    }

    public void onInputReceived(Direction newDirection) {
        if (!this.currentDirection.isOpposite(newDirection)) {
            this.currentDirection = newDirection;
        }
    }

    public void stop() {
        this.isRunning = false;
    }

    @Override
    public void run() {
        this.isRunning = true;
        
        inputHandler.startListening(this::onInputReceived);

        while (isRunning && !state.isGameOver()) {
            long startTime = System.currentTimeMillis();

            tick();
            render();

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = state.getCurrentTickDelay() - elapsedTime;

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Game loop interrupted. Exiting.");
                    break;
                }
            }
        }

        inputHandler.stopListening();
        if (state.isGameOver()) {
            renderer.showGameOver(state.getScore());
        }
    }

    private void tick() {
        Point head = state.getSnake().getHead();
        Point newHead = currentDirection.applyTo(head);

        if (state.isOutOfBounds(newHead) || state.getSnake().checkSelfCollision(newHead)) {
            state.setGameOver(true);
            return;
        }

        Consumable item = state.consumeItemAt(newHead);
        boolean shouldGrow = false;

        if (item != null) {
            item.applyEffect(state.getSnake(), state);
            if (item instanceof Apple) {
                shouldGrow = true;
            }
        }

        state.getSnake().move(newHead, shouldGrow);

        if (state.getActiveItems().isEmpty()) {
            spawnNewItem();
        }
    }

    private void render() {
        renderer.render(state);
    }

    private void spawnNewItem() {
        List<Point> emptyCells = new ArrayList<>();
        
        for (int y = 0; y < state.getConfig().height(); y++) {
            for (int x = 0; x < state.getConfig().width(); x++) {
                Point p = new Point(x, y);
                if (!state.getSnake().checkSelfCollision(p) && !state.getActiveItems().containsKey(p)) {
                    emptyCells.add(p);
                }
            }
        }

        ConsumableFactory.SpawnResult result = ConsumableFactory.spawnRandomConsumable(emptyCells);
        if (result != null) {
            state.addItem(result.location(), result.item());
        }
    }
}