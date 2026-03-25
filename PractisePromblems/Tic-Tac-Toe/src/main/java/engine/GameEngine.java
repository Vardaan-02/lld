package engine;

import java.util.List;

import models.Board;
import models.Move;
import models.Player;
import strategies.winning.WinningStrategy;

public class GameEngine{
    private final Board board;
    private final List<Player> players;
    private int currentPlayerIndex;
    private GameState state;
    private final WinningStrategy winningStrategy;
    private Player winner;

    public GameEngine(int dimenstion, List<Player> players, WinningStrategy strategy){
        board = new Board(dimenstion);
        this.players = players;
        this.winningStrategy = strategy;

        this.state = GameState.IN_PROGRESS;
        this.currentPlayerIndex = 0;
    }

    public void executeMove(Move move){
        if (state != GameState.IN_PROGRESS) {
            throw new IllegalStateException("Game is already over. No more moves allowed.");
        }

        board.applyMove(move);

        if (winningStrategy.checkWin(board, move)) {
            state = GameState.COMPLETE;
            winner = move.getPlayer();
            return; 
        }

        if (board.isFull()) {
            state = GameState.DRAW;
            return;
        }

        toggleToNextPlayer();
    }

    public void undoLastMove(Move move){
        board.revertMove(move);
        winningStrategy.undoMove(board, move);

        boolean shouldToggleBack = (this.state == GameState.IN_PROGRESS);

        state = GameState.IN_PROGRESS;
        winner = null;

        if (shouldToggleBack) {
            toggleToPrevPlayer();
        }
    }

    public Player getCurrentPlayer(){
        return this.players.get(currentPlayerIndex);
    }

    public GameState getGameState(){
        return this.state;
    }

    public Player getWinner(){
        if (state == GameState.COMPLETE) return winner;
        else return null;
    }

    public Board getBoard() {
        return this.board;
    }

    private void toggleToNextPlayer(){
        this.currentPlayerIndex++;
        this.currentPlayerIndex %= players.size();
    }

    private void toggleToPrevPlayer(){
        this.currentPlayerIndex = currentPlayerIndex - 1 + players.size();
        this.currentPlayerIndex %= players.size();
    }
}