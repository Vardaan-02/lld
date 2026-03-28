package main.java.factories;

import main.java.commands.*;
import main.java.dto.MoveIntent;
import main.java.models.*;
import main.java.pieces.*;

public class MoveFactory {

    public MoveCommand createCommand(Board board, MoveIntent intent, MoveHistory history) {
        Cell start = board.getSpot(intent.getStartX(), intent.getStartY());
        Cell end = board.getSpot(intent.getEndX(), intent.getEndY());
        Piece pieceMoved = start.getPiece();

        if (pieceMoved == null) return null;

        if (pieceMoved instanceof King && Math.abs(start.getX() - end.getX()) == 2) {
            return createCastlingCommand(board, start, end, pieceMoved);
        }

        if (pieceMoved instanceof Pawn && start.getX() != end.getX() && end.isEmpty()) {
            return createEnPassantCommand(board, start, end, pieceMoved, history);
        }

        if (!pieceMoved.isValidPath(board, start, end)) {
            return null; 
        }

        if (pieceMoved instanceof Pawn && (end.getY() == 0 || end.getY() == 7)) {
            if (intent.getPromotionChoice() == null) return null; 
            return createPromotionCommand(start, end, pieceMoved.getColor(), intent.getPromotionChoice());
        }

        return new NormalMove(start, end);
    }

    private MoveCommand createCastlingCommand(Board board, Cell kingStart, Cell kingEnd, Piece king) {
        if (king.getHasMoved() || kingStart.getY() != kingEnd.getY()) return null;

        int y = kingStart.getY();
        boolean isKingside = kingEnd.getX() > kingStart.getX();
        
        int rookStartX = isKingside ? 7 : 0;
        int rookEndX = isKingside ? 5 : 3; 
        
        Cell rookStart = board.getSpot(rookStartX, y);
        Cell rookEnd = board.getSpot(rookEndX, y);
        Piece rook = rookStart.getPiece();

        if (!(rook instanceof Rook) || rook.getHasMoved()) return null;

        int minX = Math.min(kingStart.getX(), rookStartX);
        int maxX = Math.max(kingStart.getX(), rookStartX);
        for (int x = minX + 1; x < maxX; x++) {
            if (!board.getSpot(x, y).isEmpty()) return null;
        }

        return new CastlingMove(new NormalMove(kingStart, kingEnd), new NormalMove(rookStart, rookEnd));
    }

    private MoveCommand createEnPassantCommand(Board board, Cell start, Cell end, Piece pawn, MoveHistory history) {
        MoveCommand lastCommand = history.peekLastMove();
        if (!(lastCommand instanceof NormalMove)) return null;

        NormalMove lastMove = (NormalMove) lastCommand;
        Piece lastPiece = lastMove.getPieceMoved();

        if (!(lastPiece instanceof Pawn)) return null;
        if (Math.abs(lastMove.getStart().getY() - lastMove.getEnd().getY()) != 2) return null;

        if (lastMove.getEnd().getX() != end.getX() || lastMove.getEnd().getY() != start.getY()) return null;

        Cell captureCell = board.getSpot(end.getX(), start.getY());
        return new EnPassantMove(start, end, captureCell);
    }

    private MoveCommand createPromotionCommand(Cell start, Cell end, Color color, PieceType choice) {
        Piece newPiece;
        switch (choice) {
            case QUEEN: newPiece = new Queen(color); break;
            case ROOK: newPiece = new Rook(color); break;
            case BISHOP: newPiece = new Bishop(color); break;
            case KNIGHT: newPiece = new Knight(color); break;
            default: return null;
        }
        return new PromotionMove(new NormalMove(start, end), newPiece);
    }
}