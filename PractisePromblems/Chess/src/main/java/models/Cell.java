package main.java.models;

import main.java.pieces.Piece;

public class Cell {
    private final int x;
    private final int y;
    private Piece piece;

    public Cell(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    
    public Piece getPiece() { return piece; }
    public void setPiece(Piece piece) { this.piece = piece; }
    
    public boolean isEmpty() { return this.piece == null; }
} 