package main.java.commands;

import main.java.models.Board;
import main.java.models.Cell;
import main.java.pieces.King;
import main.java.pieces.Piece;

public class NormalMove implements MoveCommand {
    private final Cell start;
    private final Cell end;
    private final Piece pieceMoved;
    private final Piece pieceCaptured;
    private final boolean wasFirstMove;

    public NormalMove(Cell start, Cell end) {
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
        this.pieceCaptured = end.getPiece();
        this.wasFirstMove = !this.pieceMoved.getHasMoved();
    }

    public Cell getStart() { return start; }
    public Cell getEnd() { return end; }
    public Piece getPieceMoved() { return pieceMoved; }
    public Piece getPieceCaptured() { return pieceCaptured; }

    @Override
    public void execute(Board board) {
        board.getSpot(start.getX(), start.getY()).setPiece(null);
        board.getSpot(end.getX(), end.getY()).setPiece(pieceMoved);

        pieceMoved.setHasMoved(true);

        if (pieceMoved instanceof King) {
            board.updateKingSpot(pieceMoved.getColor(), board.getSpot(end.getX(), end.getY()));
        }
    }

    @Override
    public void undo(Board board) {
        board.getSpot(start.getX(), start.getY()).setPiece(pieceMoved);
        board.getSpot(end.getX(), end.getY()).setPiece(pieceCaptured);

        if (wasFirstMove) {
            pieceMoved.setHasMoved(false);
        }

        if (pieceMoved instanceof King) {
            board.updateKingSpot(pieceMoved.getColor(), board.getSpot(start.getX(), start.getY()));
        }
    }
}