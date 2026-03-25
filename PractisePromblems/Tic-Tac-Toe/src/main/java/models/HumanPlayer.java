package models;

public class HumanPlayer extends Player {
    private final MoveProvider moveProvider;

    public HumanPlayer(String name, PieceType piece, MoveProvider moveProvider) {
        super(name, piece);
        this.moveProvider = moveProvider;
    }

    @Override
    public Move makeMove(Board board) {
        return moveProvider.getMove(this);
    }
}
