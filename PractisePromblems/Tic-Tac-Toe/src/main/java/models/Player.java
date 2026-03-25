package models;

public abstract class Player {
    private final String name;
    private final PieceType piece;

    public Player(String name, PieceType piece){
        this.name = name;
        this.piece = piece;
    }

    public String getName(){
        return this.name;
    }

    public PieceType getPiece(){
        return this.piece;
    }

    public abstract Move makeMove(Board board);
}
