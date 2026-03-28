package main.java.dto;

import main.java.models.PieceType;

public class MoveIntent {
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;
    private final PieceType promotionChoice;

    public MoveIntent(int startX, int startY, int endX, int endY, PieceType promotionChoice) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.promotionChoice = promotionChoice;
    }

    public int getStartX() { return startX; }
    public int getStartY() { return startY; }
    public int getEndX() { return endX; }
    public int getEndY() { return endY; }
    public PieceType getPromotionChoice() { return promotionChoice; }
}