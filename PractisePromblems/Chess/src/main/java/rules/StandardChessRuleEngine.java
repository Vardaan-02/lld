package main.java.rules;

import main.java.commands.MoveCommand;
import main.java.dto.MoveIntent;
import main.java.factories.MoveFactory;
import main.java.models.*;
import main.java.pieces.*;

public class StandardChessRuleEngine implements RuleEngine {
    private final MoveFactory moveFactory;

    public StandardChessRuleEngine(MoveFactory factory) {
        this.moveFactory = factory;
    }

    @Override
    public boolean processTurn(GameSession session, MoveIntent intent) {
        if (session.getState() != GameState.ACTIVE) {
            return false; 
        }

        Board board = session.getBoard();
        Color currentPlayer = session.getCurrentTurn();

        Cell startCell = board.getSpot(intent.getStartX(), intent.getStartY());
        if (startCell.isEmpty() || startCell.getPiece().getColor() != currentPlayer) {
            return false;
        }

        MoveCommand command = moveFactory.createCommand(board, intent, session.getHistory());
        if (command == null) {
            return false;
        }

        if (leavesKingInCheck(board, command, currentPlayer)) {
            return false; 
        }

        command.execute(board);
        session.getHistory().push(command);
        
        session.switchTurn();
        Color nextPlayer = session.getCurrentTurn();

        boolean isNextPlayerInCheck = isKingInCheck(board, nextPlayer);
        boolean nextPlayerHasMoves = hasAnyLegalMoves(session, nextPlayer);

        if (!nextPlayerHasMoves) {
            if (isNextPlayerInCheck) {
                GameState winState = (currentPlayer == Color.WHITE) ? GameState.WHITE_WIN : GameState.BLACK_WIN;
                session.setState(winState);
            } else {
                session.setState(GameState.DRAW);
            }
        }

        return true;
    }

    private boolean leavesKingInCheck(Board board, MoveCommand command, Color playerColor) {
        boolean inCheck = false;
        try {
            command.execute(board); 
            inCheck = isKingInCheck(board, playerColor); 
        } finally {
            command.undo(board);
        }
        return inCheck;
    }

    private boolean isKingInCheck(Board board, Color color) {
        Cell kingSpot = board.getKingSpot(color);
        if (kingSpot == null) return false;

        int kx = kingSpot.getX();
        int ky = kingSpot.getY();

        int[][] knightMoves = { {2,1}, {1,2}, {-1,2}, {-2,1}, {-2,-1}, {-1,-2}, {1,-2}, {2,-1} };
        for (int[] m : knightMoves) {
            if (isEnemyPiece(board, color, kx + m[0], ky + m[1], Knight.class)) return true;
        }

        int pawnDir = (color == Color.WHITE) ? 1 : -1;
        if (isEnemyPiece(board, color, kx - 1, ky + pawnDir, Pawn.class)) return true;
        if (isEnemyPiece(board, color, kx + 1, ky + pawnDir, Pawn.class)) return true;

        int[][] straightDirs = { {0,1}, {1,0}, {0,-1}, {-1,0} };
        if (scanRays(board, color, kx, ky, straightDirs, Rook.class, Queen.class)) return true;

        int[][] diagonalDirs = { {1,1}, {1,-1}, {-1,1}, {-1,-1} };
        if (scanRays(board, color, kx, ky, diagonalDirs, Bishop.class, Queen.class)) return true;

        return false;
    }

    private boolean scanRays(Board board, Color myColor, int startX, int startY, int[][] directions, Class<?>... threatTypes) {
        for (int[] dir : directions) {
            int x = startX + dir[0];
            int y = startY + dir[1];

            while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
                Piece piece = board.getSpot(x, y).getPiece();
                if (piece != null) {
                    if (piece.getColor() == myColor) {
                        break; 
                    }
                    for (Class<?> threat : threatTypes) {
                        if (threat.isInstance(piece)) return true;
                    }
                    break; 
                }
                x += dir[0];
                y += dir[1];
            }
        }
        return false;
    }

    private boolean hasAnyLegalMoves(GameSession session, Color playerColor) {
        Board board = session.getBoard();

        for (int startX = 0; startX < 8; startX++) {
            for (int startY = 0; startY < 8; startY++) {
                Cell startCell = board.getSpot(startX, startY);
                
                if (!startCell.isEmpty() && startCell.getPiece().getColor() == playerColor) {
                    
                    for (int endX = 0; endX < 8; endX++) {
                        for (int endY = 0; endY < 8; endY++) {
                            if (startX == endX && startY == endY) continue;

                            MoveIntent testIntent = new MoveIntent(startX, startY, endX, endY, PieceType.QUEEN);
                            MoveCommand testCommand = moveFactory.createCommand(board, testIntent, session.getHistory());
                            
                            if (testCommand != null && !leavesKingInCheck(board, testCommand, playerColor)) {
                                return true; 
                            }
                        }
                    }
                }
            }
        }
        return false; 
    }

    private boolean isEnemyPiece(Board board, Color myColor, int x, int y, Class<?> pieceType) {
        if (x < 0 || x > 7 || y < 0 || y > 7) return false;
        Piece piece = board.getSpot(x, y).getPiece();
        return piece != null && piece.getColor() != myColor && pieceType.isInstance(piece);
    }
}