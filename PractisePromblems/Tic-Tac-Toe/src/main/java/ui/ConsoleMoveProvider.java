package ui;

import java.util.Scanner;

import models.Move;
import models.MoveProvider;
import models.Player;

public class ConsoleMoveProvider implements MoveProvider {
    private final Scanner scanner;

    public ConsoleMoveProvider(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Move getMove(Player player) {
        System.out.println("Enter row and col: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        return new Move(row, col, player);
    }
}
