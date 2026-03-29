package main.java.consumable;

import main.java.entity.Snake;
import main.java.state.GameState;

public interface Consumable {

    public void applyEffect(Snake snake, GameState state);

    public char getRenderIcon();

}
