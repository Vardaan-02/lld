package main.java.consumable;

import main.java.entity.Snake;
import main.java.state.GameState;

public class SpeedBoost implements Consumable {
    private static final int BONUS_SCORE = 50;
    private static final long SPEED_INCREASE_MS = 15L;

    @Override
    public void applyEffect(Snake snake, GameState state) {
        state.addScore(BONUS_SCORE);
        state.decreaseTickDelay(SPEED_INCREASE_MS);
    }

    @Override
    public char getRenderIcon() {
        return 'S'; 
    }
}