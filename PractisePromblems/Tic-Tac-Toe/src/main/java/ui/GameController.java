package ui;

import commands.CommandHistory;
import commands.MoveCommand;
import engine.GameEngine;
import engine.GameState;
import models.Board;
import models.Cell;
import models.Move;
import models.Player;

import java.util.Scanner;

public class GameController {
    private final GameEngine gameEngine;
    private final CommandHistory commandHistory;
    private final Scanner scanner;

    public GameController(GameEngine gameEngine, CommandHistory commandHistory) {
        this.gameEngine = gameEngine;
        this.commandHistory = commandHistory;
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to Tic-Tac-Toe!");

        while (gameEngine.getGameState() == GameState.IN_PROGRESS) {
            renderBoard();
            handleUserInput();
        }

        renderBoard();
        
        if (gameEngine.getGameState() == GameState.COMPLETE) {
            System.out.println("Game Over! The winner is: " + gameEngine.getWinner().getName());
        } else if (gameEngine.getGameState() == GameState.DRAW) {
            System.out.println("Game Over! It's a draw.");
        }
    }

    private void handleUserInput() {
        Player currentPlayer = gameEngine.getCurrentPlayer();

        try {
            System.out.print("Do you want to undo the last move? (y/n): ");
            String undoChoice = scanner.next();
            
            if (undoChoice.equalsIgnoreCase("y")) {
                commandHistory.pop();
                return;
            }
            
            System.out.println(currentPlayer.getName() + "'s turn.");

            Move move = currentPlayer.makeMove(gameEngine.getBoard());

            MoveCommand command = new MoveCommand(gameEngine, move);
            commandHistory.push(command);

        } catch (Exception e) {
            System.out.println("\n[ERROR] " + e.getMessage());
            System.out.println("Please try again.\n");
        }
    }

    private void renderBoard() {
        Board board = gameEngine.getBoard();
        int size = board.getSize();

        System.out.println("\n--- Current Board ---");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = board.getCell(i, j);
                
                char symbol = cell.isEmpty() ? '-' : cell.getPiece().name().charAt(0);
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------\n");
    }
}