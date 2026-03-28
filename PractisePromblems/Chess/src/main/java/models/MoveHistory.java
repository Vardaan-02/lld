package main.java.models;

import main.java.commands.MoveCommand;
import java.util.Stack;

public class MoveHistory {
    private final Stack<MoveCommand> history;

    public MoveHistory() {
        this.history = new Stack<>();
    }

    public void push(MoveCommand command) {
        history.push(command);
    }

    public MoveCommand pop() {
        if (history.isEmpty()) {
            return null;
        }
        return history.pop();
    }

    public MoveCommand peekLastMove() {
        if (history.isEmpty()) {
            return null;
        }
        return history.peek();
    }
}