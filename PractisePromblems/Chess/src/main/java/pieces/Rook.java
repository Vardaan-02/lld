package main.java.pieces;

import main.java.models.Board;
import main.java.models.Cell;
import main.java.models.Color;

public class Rook extends Piece {
    public Rook(Color color) { super(color); }

    @Override
    public boolean isValidPath(Board board, Cell start, Cell end) { 
        if (start.getX() != end.getX() && start.getY() != end.getY()) {
            return false;
        }

        return !isPathBlocked(board, start, end) && !isFriendlyFire(end);
    }
}