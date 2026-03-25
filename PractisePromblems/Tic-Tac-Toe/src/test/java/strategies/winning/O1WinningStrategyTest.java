package strategies.winning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import models.Board;
import models.Move;
import models.PieceType;
import models.Player;

import static org.junit.jupiter.api.Assertions.*;

class O1WinningStrategyTest {
    private O1WinningStrategy strategy;
    private Board board;
    private Player playerX;

    @BeforeEach
    void setUp() {
        strategy = new O1WinningStrategy(3);
        board = new Board(3);
        playerX = new Player("X", PieceType.X) { @Override public Move makeMove(Board b) { return null; } };
        // playerO = new Player("O", PieceType.O) { @Override public Move makeMove(Board b) { return null; } };
    }

    @Test
    void testPlayerXWinsOnMainDiagonal() {
        Move m1 = new Move(0, 0, playerX);
        Move m2 = new Move(1, 1, playerX);
        Move m3 = new Move(2, 2, playerX);

        assertFalse(strategy.checkWin(board, m1), "Game should not be won yet");
        assertFalse(strategy.checkWin(board, m2), "Game should not be won yet");
        assertTrue(strategy.checkWin(board, m3), "Player X should win on the main diagonal!");
    }

    @Test
    void testUndoMoveRevertsMathematicalState() {
        Move m1 = new Move(0, 0, playerX);
        strategy.checkWin(board, m1);
        
        // Undo the move
        strategy.undoMove(board, m1); // Should add +1 back, making it 0
        
        Move m2 = new Move(0, 1, playerX);
        Move m3 = new Move(0, 2, playerX);
        
        strategy.checkWin(board, m2);
        boolean isWin = strategy.checkWin(board, m3);
        
        // If undo failed, row 0 would sum to -3 and trigger a false win here
        assertFalse(isWin, "Undo failed to reset the state! False win detected.");
    }
}