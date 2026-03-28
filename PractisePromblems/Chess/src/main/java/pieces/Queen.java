package main.java.pieces;

import main.java.models.Board;
import main.java.models.Cell;
import main.java.models.Color;

public class Queen extends Piece {
    public Queen(Color color) { super(color); }

    @Override
    public boolean isValidPath(Board board, Cell start, Cell end) {
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        boolean isStraight = (startX == endX || startY == endY);
        boolean isDiagonal = (Math.abs(startX - endX) == Math.abs(startY - endY));

        if (!isStraight && !isDiagonal) {
            return false;
        }

        return !isPathBlocked(board, start, end) && !isFriendlyFire(end);
    }
}