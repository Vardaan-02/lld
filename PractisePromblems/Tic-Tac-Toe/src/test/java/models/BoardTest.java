package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testOutOfBoundsMoveThrowsException() {
        Board board = new Board(3);
        Player dummy = new Player("X", PieceType.X) { @Override public Move makeMove(Board b) { return null; } };
        
        // Negative index
        assertThrows(IllegalArgumentException.class, () -> {
            board.applyMove(new Move(-1, 0, dummy));
        });

        // Out of bounds index
        assertThrows(IllegalArgumentException.class, () -> {
            board.applyMove(new Move(3, 3, dummy));
        });
    }

    @Test
    void testCellAlreadyOccupiedThrowsException() {
        Board board = new Board(3);
        Player p1 = new Player("X", PieceType.X) { @Override public Move makeMove(Board b) { return null; } };
        Player p2 = new Player("O", PieceType.O) { @Override public Move makeMove(Board b) { return null; } };
        
        board.applyMove(new Move(1, 1, p1));

        // P2 tries to play on the same cell
        assertThrows(IllegalStateException.class, () -> {
            board.applyMove(new Move(1, 1, p2));
        });
    }
}