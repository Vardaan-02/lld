package main.java.commands;

import main.java.models.Board;
import main.java.models.Cell;
import main.java.pieces.Piece;

public class EnPassantMove implements MoveCommand {
    private final Cell start;
    private final Cell end;
    private final Cell captureCell; 
    private final Piece pieceMoved;
    private final Piece pieceCaptured;
    private final boolean wasFirstMove;

    public EnPassantMove(Cell start, Cell end, Cell captureCell) {
        this.start = start;
        this.end = end;
        this.captureCell = captureCell;
        
        this.pieceMoved = start.getPiece();
        this.pieceCaptured = captureCell.getPiece();
        this.wasFirstMove = !this.pieceMoved.getHasMoved();
    }

    @Override
    public void execute(Board board) {
        board.getSpot(start.getX(), start.getY()).setPiece(null);
        board.getSpot(end.getX(), end.getY()).setPiece(pieceMoved);
        pieceMoved.setHasMoved(true);

        board.getSpot(captureCell.getX(), captureCell.getY()).setPiece(null);
    }

    @Override
    public void undo(Board board) {
        if (wasFirstMove) {
            pieceMoved.setHasMoved(false);
        }

        board.getSpot(start.getX(), start.getY()).setPiece(pieceMoved);
        board.getSpot(end.getX(), end.getY()).setPiece(null);

        board.getSpot(captureCell.getX(), captureCell.getY()).setPiece(pieceCaptured);
    }
}