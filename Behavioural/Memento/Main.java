package Behavioural.Memento;

import Behavioural.Memento.gameEngine.GameState;
import Behavioural.Memento.gameEngine.Player;
import Behavioural.Memento.gameEngine.SaveManager;

public class Main {
    public static void main(String[] args) {

        GameState gameState = new GameState("Forest");
        SaveManager saveManager = new SaveManager();

        Player player = new Player(100, 50, "Sword");
        gameState.setPlayer(player);
        gameState.movePlayer(10, 20);
        gameState.addItem("Potion", 5);

        // Save Slot 1
        saveManager.saveToSlot(1, gameState);

        // Modify state
        gameState.movePlayer(50, 80);
        gameState.addItem("Gold", 100);
        gameState.completeQuest("Dragon Hunt");

        // Save Slot 2
        saveManager.saveToSlot(2, gameState);

        // Load Slot 1
        saveManager.loadFromSlot(1, gameState);
    }

}
