package engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import models.Move;
import models.PieceType;
import models.Board;
import models.Player;
import strategies.winning.O1WinningStrategy;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {
    private GameEngine engine;
    private Player p1;
    private Player p2;

    @BeforeEach
    void setUp() {
        p1 = new Player("P1", PieceType.X) { @Override public Move makeMove(Board b) { return null; } };
        p2 = new Player("P2", PieceType.O) { @Override public Move makeMove(Board b) { return null; } };
        
        engine = new GameEngine(3, Arrays.asList(p1, p2), new O1WinningStrategy(3));
    }

    @Test
    void testInitialState() {
        assertEquals(GameState.IN_PROGRESS, engine.getGameState());
        assertEquals(p1, engine.getCurrentPlayer());
        assertNull(engine.getWinner());
    }

    @Test
    void testGameCompletesAndLocks() {
        // P1 plays (0,0), P2 plays (1,0)
        engine.executeMove(new Move(0, 0, p1));
        engine.executeMove(new Move(1, 0, p2));
        
        // P1 plays (0,1), P2 plays (1,1)
        engine.executeMove(new Move(0, 1, p1));
        engine.executeMove(new Move(1, 1, p2));
        
        // P1 plays (0,2) - WIN!
        engine.executeMove(new Move(0, 2, p1));

        assertEquals(GameState.COMPLETE, engine.getGameState());
        assertEquals(p1, engine.getWinner());

        // Verify the guard clause works: playing after a win throws an exception
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            engine.executeMove(new Move(2, 2, p2));
        });
        assertTrue(exception.getMessage().contains("Game is already over"));
    }

    @Test
    void testUndoRevertsWinStateAndPlayerTurn() {
        // Simulate a win for P1
        engine.executeMove(new Move(0, 0, p1));
        engine.executeMove(new Move(1, 0, p2));
        engine.executeMove(new Move(0, 1, p1));
        engine.executeMove(new Move(1, 1, p2));
        Move winningMove = new Move(0, 2, p1);
        engine.executeMove(winningMove);

        // State is COMPLETE. Now undo it.
        engine.undoLastMove(winningMove);

        assertEquals(GameState.IN_PROGRESS, engine.getGameState(), "State should revert to IN_PROGRESS");
        assertNull(engine.getWinner(), "Winner should be cleared");
        assertEquals(p1, engine.getCurrentPlayer(), "Turn should revert back to P1");
        assertTrue(engine.getBoard().getCell(0, 2).isEmpty(), "Winning cell should be cleared");
    }
}