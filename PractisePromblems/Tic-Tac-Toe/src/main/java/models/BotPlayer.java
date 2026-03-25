package models;

import strategies.playing.BotPlayingStrategy;

public class BotPlayer extends Player {
    private final BotPlayingStrategy playingStrategy;

    public BotPlayer(String name, PieceType piece, BotPlayingStrategy playingStrategy) {
        super(name, piece);
        this.playingStrategy = playingStrategy;
    }

    public Move makeMove(Board board) {
        return playingStrategy.makeMove(board, this);
    }
}