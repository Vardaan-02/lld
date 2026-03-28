package main.java.models;

public class GameSession {
    private final Board board;
    private final MoveHistory history;
    private Color currentTurn;
    private GameState state;

    public GameSession() {
        this.board = new Board();
        this.history = new MoveHistory();
        this.currentTurn = Color.WHITE;
        this.state = GameState.ACTIVE;
    }

    public Board getBoard() { return board; }
    public MoveHistory getHistory() { return history; }
    
    public Color getCurrentTurn() { return currentTurn; }
    public void switchTurn() {
        this.currentTurn = (this.currentTurn == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    public GameState getState() { return state; }
    public void setState(GameState state) { this.state = state; }
}