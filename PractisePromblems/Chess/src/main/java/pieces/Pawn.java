package main.java.pieces;

import main.java.models.Board;
import main.java.models.Cell;
import main.java.models.Color;

public class Pawn extends Piece {
    public Pawn(Color color) { super(color); }

    @Override
    public boolean isValidPath(Board board, Cell start, Cell end) {
        int diffX = end.getX() - start.getX();
        int diffY = end.getY() - start.getY();

        int direction = (this.getColor() == Color.WHITE) ? 1 : -1;

        if (diffX == 0 && diffY == direction) {
            return end.isEmpty();
        }

        if (diffX == 0 && diffY == 2 * direction && !this.getHasMoved()) {
            Cell intermediateCell = board.getSpot(start.getX(), start.getY() + direction);
            return intermediateCell.isEmpty() && end.isEmpty();
        }

        if (Math.abs(diffX) == 1 && diffY == direction) {
            return !end.isEmpty() && end.getPiece().getColor() != this.getColor();
        }

        return false;
    }
}