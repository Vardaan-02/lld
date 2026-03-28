package main.java.commands;

import main.java.models.Board;
import main.java.models.Cell;
import main.java.pieces.Piece;

public class PromotionMove implements MoveCommand {
    private final NormalMove pawnMove;
    private final Piece promotedPiece;

    public PromotionMove(NormalMove pawnMove, Piece promotedPiece) {
        this.pawnMove = pawnMove;
        this.promotedPiece = promotedPiece;
    }

    public NormalMove getNormalMove() { return pawnMove; }
    public Piece getPromotedPiece() { return promotedPiece; }

    @Override
    public void execute(Board board) {
        pawnMove.execute(board);

        Cell endCell = pawnMove.getEnd();
        board.getSpot(endCell.getX(), endCell.getY()).setPiece(promotedPiece);
    }

    @Override
    public void undo(Board board) {
        pawnMove.undo(board);
    }
}