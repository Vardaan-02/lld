package strategies.winning;

import models.Board;
import models.Move;

public interface WinningStrategy {
    public boolean checkWin(Board board, Move lastMove);
    public void undoMove(Board board, Move lastMove);
}
