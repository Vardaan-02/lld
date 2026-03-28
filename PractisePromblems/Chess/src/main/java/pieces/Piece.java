package main.java.pieces;

import main.java.models.Board;
import main.java.models.Cell;
import main.java.models.Color;

public abstract class Piece {
    private final Color color;
    private boolean hasMoved;

    public Piece(Color color) {
        this.color = color;
        this.hasMoved = false; 
    }

    public Color getColor() { return color; }
    
    public boolean getHasMoved() { return hasMoved; }
    public void setHasMoved(boolean hasMoved) { this.hasMoved = hasMoved; }

    public abstract boolean isValidPath(Board board, Cell start, Cell end);

    protected boolean isFriendlyFire(Cell end) {
        Piece target = end.getPiece();
        return target != null && target.getColor() == this.color;
    }

    protected boolean isPathBlocked(Board board, Cell start, Cell end) {
        int xDirection = Integer.compare(end.getX(), start.getX());
        int yDirection = Integer.compare(end.getY(), start.getY());

        int currentX = start.getX() + xDirection;
        int currentY = start.getY() + yDirection;

        while (currentX != end.getX() || currentY != end.getY()) {
            if (!board.getSpot(currentX, currentY).isEmpty()) {
                return true; 
            }
            currentX += xDirection;
            currentY += yDirection;
        }
        return false; 
    }
}