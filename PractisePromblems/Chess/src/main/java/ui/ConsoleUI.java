package main.java.ui;

import java.util.Scanner;
import main.java.dto.MoveIntent;
import main.java.models.*;
import main.java.pieces.*;
import main.java.rules.RuleEngine;

public class ConsoleUI {
    private final GameSession session;
    private final RuleEngine engine;
    private final Scanner scanner;

    public ConsoleUI(GameSession session, RuleEngine engine) {
        this.session = session;
        this.engine = engine;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        setupStandardBoard(session.getBoard());
        
        System.out.println("=== Java Chess Engine ===");
        System.out.println("Format: start end [promotion] (e.g., 'e2 e4' or 'e7 e8 q')");

        while (session.getState() == GameState.ACTIVE) {
            printBoard(session.getBoard());
            System.out.println(session.getCurrentTurn() + "'s turn.");
            System.out.print("Enter move: ");
            
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit") || input.equals("quit")) {
                System.out.println("Game aborted.");
                break;
            }

            try {
                MoveIntent intent = parseInput(input);
                boolean success = engine.processTurn(session, intent);
                
                if (!success) {
                    System.out.println("❌ Invalid move! Check rules, geometry, or King safety. Try again.");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Invalid input format. Please use algebraic format like 'e2 e4'.");
            }
        }

        if (session.getState() != GameState.ACTIVE) {
            printBoard(session.getBoard());
            System.out.println("🏆 Game Over! Result: " + session.getState());
        }
    }

    private MoveIntent parseInput(String input) {
        String[] parts = input.split(" ");
        int startX = parts[0].charAt(0) - 'a';
        int startY = parts[0].charAt(1) - '1';
        int endX = parts[1].charAt(0) - 'a';
        int endY = parts[1].charAt(1) - '1';

        PieceType promotion = null;
        if (parts.length > 2) {
            switch (parts[2]) {
                case "q": promotion = PieceType.QUEEN; break;
                case "r": promotion = PieceType.ROOK; break;
                case "b": promotion = PieceType.BISHOP; break;
                case "n": promotion = PieceType.KNIGHT; break;
            }
        }
        return new MoveIntent(startX, startY, endX, endY, promotion);
    }

    private void printBoard(Board board) {
        System.out.println("\n  a b c d e f g h");
        for (int y = 7; y >= 0; y--) { 
            System.out.print((y + 1) + " ");
            for (int x = 0; x < 8; x++) {
                Piece p = board.getSpot(x, y).getPiece();
                if (p == null) {
                    System.out.print(((x + y) % 2 == 0) ? "· " : "■ ");
                } else {
                    System.out.print(getPieceSymbol(p) + " ");
                }
            }
            System.out.println((y + 1));
        }
        System.out.println("  a b c d e f g h\n");
    }

    private char getPieceSymbol(Piece p) {
        char symbol = 'p';
        if (p instanceof King) symbol = 'k';
        else if (p instanceof Queen) symbol = 'q';
        else if (p instanceof Rook) symbol = 'r';
        else if (p instanceof Bishop) symbol = 'b';
        else if (p instanceof Knight) symbol = 'n';

        return p.getColor() == Color.WHITE ? Character.toUpperCase(symbol) : symbol;
    }

    private void setupStandardBoard(Board board) {
        board.getSpot(0, 0).setPiece(new Rook(Color.WHITE));
        board.getSpot(1, 0).setPiece(new Knight(Color.WHITE));
        board.getSpot(2, 0).setPiece(new Bishop(Color.WHITE));
        board.getSpot(3, 0).setPiece(new Queen(Color.WHITE));
        Piece whiteKing = new King(Color.WHITE);
        board.getSpot(4, 0).setPiece(whiteKing);
        board.updateKingSpot(Color.WHITE, board.getSpot(4, 0)); 
        board.getSpot(5, 0).setPiece(new Bishop(Color.WHITE));
        board.getSpot(6, 0).setPiece(new Knight(Color.WHITE));
        board.getSpot(7, 0).setPiece(new Rook(Color.WHITE));
        
        for (int i = 0; i < 8; i++) board.getSpot(i, 1).setPiece(new Pawn(Color.WHITE));

        board.getSpot(0, 7).setPiece(new Rook(Color.BLACK));
        board.getSpot(1, 7).setPiece(new Knight(Color.BLACK));
        board.getSpot(2, 7).setPiece(new Bishop(Color.BLACK));
        board.getSpot(3, 7).setPiece(new Queen(Color.BLACK));
        Piece blackKing = new King(Color.BLACK);
        board.getSpot(4, 7).setPiece(blackKing);
        board.updateKingSpot(Color.BLACK, board.getSpot(4, 7)); 
        board.getSpot(5, 7).setPiece(new Bishop(Color.BLACK));
        board.getSpot(6, 7).setPiece(new Knight(Color.BLACK));
        board.getSpot(7, 7).setPiece(new Rook(Color.BLACK));
        
        for (int i = 0; i < 8; i++) board.getSpot(i, 6).setPiece(new Pawn(Color.BLACK));
    }
}