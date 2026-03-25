package strategies.playing;

import models.Board;
import models.Cell;
import models.Move;
import models.PieceType;
import models.Player;

public class MinimaxBotStrategy implements BotPlayingStrategy {

    @Override
    public Move makeMove(Board board, Player botPlayer) {
        int bestScore = Integer.MIN_VALUE;
        Move bestMove = null;
        PieceType botPiece = botPlayer.getPiece();
        PieceType opponentPiece = (botPiece == PieceType.X) ? PieceType.O : PieceType.X;

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                Cell cell = board.getCell(i, j);
                if (cell.isEmpty()) {
                    cell.setPiece(botPiece);

                    int score = minimax(board, 0, false, botPiece, opponentPiece);

                    cell.clear();

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = new Move(i, j, botPlayer);
                    }
                }
            }
        }
        
        try { Thread.sleep(800); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        
        return bestMove;
    }

    private int minimax(Board board, int depth, boolean isMaximizing, PieceType botPiece, PieceType opponentPiece) {
        if (isWinner(board, botPiece)) return 10 - depth; 
        if (isWinner(board, opponentPiece)) return -10 + depth; 
        if (board.isFull()) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < board.getSize(); i++) {
                for (int j = 0; j < board.getSize(); j++) {
                    Cell cell = board.getCell(i, j);
                    if (cell.isEmpty()) {
                        cell.setPiece(botPiece); 
                        bestScore = Math.max(bestScore, minimax(board, depth + 1, false, botPiece, opponentPiece));
                        cell.clear();
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < board.getSize(); i++) {
                for (int j = 0; j < board.getSize(); j++) {
                    Cell cell = board.getCell(i, j);
                    if (cell.isEmpty()) {
                        cell.setPiece(opponentPiece);
                        bestScore = Math.min(bestScore, minimax(board, depth + 1, true, botPiece, opponentPiece));
                        cell.clear(); 
                    }
                }
            }
            return bestScore;
        }
    }

    private boolean isWinner(Board board, PieceType piece) {
        int size = board.getSize();
        
        for (int i = 0; i < size; i++) {
            boolean rowWin = true;
            boolean colWin = true;
            for (int j = 0; j < size; j++) {
                if (board.getCell(i, j).getPiece() != piece) rowWin = false;
                if (board.getCell(j, i).getPiece() != piece) colWin = false;
            }
            if (rowWin || colWin) return true;
        }
        
        boolean diagWin = true;
        boolean antiDiagWin = true;
        for (int i = 0; i < size; i++) {
            if (board.getCell(i, i).getPiece() != piece) diagWin = false;
            if (board.getCell(i, size - 1 - i).getPiece() != piece) antiDiagWin = false;
        }
        
        return diagWin || antiDiagWin;
    }
}