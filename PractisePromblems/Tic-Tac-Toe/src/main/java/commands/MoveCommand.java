package commands;

import engine.GameEngine;
import models.Move;

public class MoveCommand implements Command{
    private final GameEngine gameEngine;
    private final Move move;

    public MoveCommand(GameEngine gameEngine, Move move){
        this.gameEngine = gameEngine;
        this.move = move;
    }

    public void execute(){
        gameEngine.executeMove(move);
    }

    public void undo(){
        gameEngine.undoLastMove(move);
    }
}
