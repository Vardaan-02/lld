package main.java.commands;

import main.java.models.Board;

public interface MoveCommand {
    void execute(Board board);
    void undo(Board board);
}