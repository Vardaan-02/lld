package models;

public class Cell {
    private final int row;
    private final int col;
    private PieceType piece;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.piece = PieceType.EMPTY;
    }

    public void setPiece(PieceType piece){
        if (this.piece == PieceType.EMPTY) this.piece = piece;
        else throw new IllegalStateException("Cell at (" + row + ", " + col + ") is already occupied.");;
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    public PieceType getPiece(){
        return this.piece;
    }

    public boolean isEmpty(){
        return this.piece == PieceType.EMPTY;
    }

    public void clear() {
        this.piece = PieceType.EMPTY;
    }
}
