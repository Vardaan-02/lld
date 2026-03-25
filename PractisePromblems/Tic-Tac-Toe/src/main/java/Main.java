import commands.CommandHistory;
import engine.GameEngine;
import factories.PlayerFactory;
import models.MoveProvider;
import models.PieceType;
import models.Player;
import strategies.playing.BotPlayingStrategy;
import strategies.playing.MinimaxBotStrategy;
import strategies.winning.O1WinningStrategy; 
import strategies.winning.WinningStrategy;
import ui.ConsoleMoveProvider;
import ui.GameController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("   TIC-TAC-TOE: MINIMAX ENGINE       ");
        System.out.println("=====================================\n");

        int dimension = 3;

        Scanner scanner = new Scanner(System.in);
        MoveProvider consoleProvider = new ConsoleMoveProvider(scanner);

        BotPlayingStrategy minimax = new MinimaxBotStrategy();

        List<Player> players = new ArrayList<>();
        players.add(PlayerFactory.createHumanPlayer("Vardaan (X)", PieceType.X, consoleProvider));
        players.add(PlayerFactory.createBotPlayer("Engine (O)", PieceType.O, minimax));

        WinningStrategy strategy = new O1WinningStrategy(dimension);

        GameEngine engine = new GameEngine(dimension, players, strategy);

        CommandHistory history = new CommandHistory();

        GameController controller = new GameController(engine, history);

        controller.startGame();

        scanner.close();
    }
}