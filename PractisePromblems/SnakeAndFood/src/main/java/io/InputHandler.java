package main.java.io;

import java.util.function.Consumer;
import main.java.entity.Direction;

public interface InputHandler {
    void startListening(Consumer<Direction> onInput);

    void stopListening();
}