package main.java.commands;

import main.java.models.Board;

public class CastlingMove implements MoveCommand {
    private final NormalMove kingMove;
    private final NormalMove rookMove;

    public CastlingMove(NormalMove kingMove, NormalMove rookMove) {
        this.kingMove = kingMove;
        this.rookMove = rookMove;
    }

    public NormalMove getKingMove() { return kingMove; }
    public NormalMove getRookMove() { return rookMove; }

    @Override
    public void execute(Board board) {
        kingMove.execute(board);
        rookMove.execute(board);
    }

    @Override
    public void undo(Board board) {
        rookMove.undo(board);
        kingMove.undo(board);
    }
}