package main.java.consumable;

import main.java.entity.Snake;
import main.java.state.GameState;

public class Apple implements Consumable{
    private static final int BONUS_SCORE = 50;

    @Override
    public void applyEffect(Snake snake, GameState state) {
        state.addScore(BONUS_SCORE);
    }

    @Override
    public char getRenderIcon() {
        return '*'; 
    }
}
