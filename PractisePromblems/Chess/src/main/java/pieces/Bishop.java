package main.java.pieces;

import main.java.models.Board;
import main.java.models.Cell;
import main.java.models.Color;

public class Bishop extends Piece {
    public Bishop(Color color) { super(color); }

    @Override
    public boolean isValidPath(Board board, Cell start, Cell end) {
        int diffX = Math.abs(start.getX() - end.getX());
        int diffY = Math.abs(start.getY() - end.getY());

        if (diffX != diffY) {
            return false;
        }

        return !isPathBlocked(board, start, end) && !isFriendlyFire(end);
    }
}