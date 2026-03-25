package strategies.winning;

import models.Board;
import models.Move;
import models.PieceType;

public class O1WinningStrategy implements WinningStrategy{
    private final int[] rowCount;
    private final int[] colCount;
    private int diagCount;
    private int antiDiagCount;

    public O1WinningStrategy(int size){
        rowCount = new int[size];
        colCount = new int[size];
    }

    public boolean checkWin(Board board, Move lastMove){
        int row = lastMove.getRow();
        int col = lastMove.getCol();
        int size = board.getSize();

        int value = lastMove.getPlayer().getPiece() == PieceType.O ? 1 : -1;

        rowCount[row] += value;
        colCount[col] += value;

        if (row == col) diagCount += value;
        if (row + col == size - 1) antiDiagCount += value;

        return (Math.abs(rowCount[row]) == size) || (Math.abs(colCount[col]) == size) || (Math.abs(diagCount) == size) || (Math.abs(antiDiagCount) == size);
    }

    public void undoMove(Board board, Move lastMove) {
        int row = lastMove.getRow();
        int col = lastMove.getCol();
        int size = board.getSize();
        
        int value = lastMove.getPlayer().getPiece() == PieceType.O ? 1 : -1;

        rowCount[row] -= value;
        colCount[col] -= value;

        if (row == col) diagCount -= value;
        if (row + col == size - 1) antiDiagCount -= value;
    }
}
