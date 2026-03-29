package main.java.io;

import java.io.IOException;
import java.util.function.Consumer;

import main.java.entity.Direction;

public class ConsoleInputHandler implements InputHandler {

    private Thread inputThread;
    private volatile boolean isListening;

    @Override
    public void startListening(Consumer<Direction> onInput) {
        isListening = true;

        inputThread = new Thread(() -> {
            try {
                while (isListening) {
                    int rawInput = System.in.read(); 
                    char key = Character.toLowerCase((char) rawInput);

                    Direction newDir = switch (key) {
                        case 'w' -> Direction.UP;
                        case 's' -> Direction.DOWN;
                        case 'a' -> Direction.LEFT;
                        case 'd' -> Direction.RIGHT;
                        default -> null;
                    };

                    if (newDir != null) {
                        onInput.accept(newDir);
                    }
                }
            } catch (IOException e) {
                if (isListening) {
                    System.err.println("Input stream interrupted.");
                }
            }
        });

        inputThread.setDaemon(true);
        inputThread.start();
    }

    @Override
    public void stopListening() {
        isListening = false;
        if (inputThread != null) {
            inputThread.interrupt();
        }
    }
}