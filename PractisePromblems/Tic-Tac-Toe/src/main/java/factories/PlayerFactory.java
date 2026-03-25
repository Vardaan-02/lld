package factories;

import models.BotPlayer;
import models.HumanPlayer;
import models.MoveProvider;
import models.PieceType;
import models.Player;
import strategies.playing.BotPlayingStrategy;

public class PlayerFactory {
    private PlayerFactory() {}

    public static Player createHumanPlayer(String name, PieceType piece, MoveProvider provider) {
        return new HumanPlayer(name, piece, provider);
    }

    public static Player createBotPlayer(String name, PieceType piece, BotPlayingStrategy strategy) {
        return new BotPlayer(name, piece, strategy);
    }
}