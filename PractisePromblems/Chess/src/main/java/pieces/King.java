package main.java.pieces;

import main.java.models.Board;
import main.java.models.Cell;
import main.java.models.Color;

public class King extends Piece {
    public King(Color color) { super(color); }

    @Override
    public boolean isValidPath(Board board, Cell start, Cell end) {
        int diffX = Math.abs(start.getX() - end.getX());
        int diffY = Math.abs(start.getY() - end.getY());
        
        if (diffX > 1 || diffY > 1) {
            return false;
        }

        return !isFriendlyFire(end);
    }
}