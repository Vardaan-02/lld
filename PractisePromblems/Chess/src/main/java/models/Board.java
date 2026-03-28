package main.java.models;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final Cell[][] board;
    private final Map<Color, Cell> kingSpots;

    public Board() {
        this.board = new Cell[8][8];
        this.kingSpots = new HashMap<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell(i, j, null);
            }
        }
    }

    public Cell getSpot(int x, int y) {
        checkArguments(x, y);
        return board[x][y];
    }

    public Cell getKingSpot(Color color) {
        return kingSpots.get(color);
    }

    public void updateKingSpot(Color color, Cell newSpot) {
        kingSpots.put(color, newSpot);
    }

    private void checkArguments(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new IllegalArgumentException("Coordinates out of bounds: " + x + ", " + y);
        }
    }
}