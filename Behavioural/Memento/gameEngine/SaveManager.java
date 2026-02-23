package Behavioural.Memento.gameEngine;

import java.util.*;

public class SaveManager {

    private Map<Integer, GameState.GameStateSnapshot> saveSlots = new HashMap<>();
    private GameState.GameStateSnapshot autoSave;
    private GameState.GameStateSnapshot checkpoint;

    public void saveToSlot(int slot, GameState state) {
        saveSlots.put(slot, state.save());
        System.out.println("Saved to slot " + slot);
    }

    public void loadFromSlot(int slot, GameState state) {
        if (!saveSlots.containsKey(slot)) {
            throw new RuntimeException("No save found in slot " + slot);
        }
        state.restore(saveSlots.get(slot));
        System.out.println("Loaded from slot " + slot);
    }

    public void autoSave(GameState state) {
        autoSave = state.save();
        System.out.println("Auto-saved");
    }

    public void loadAutoSave(GameState state) {
        if (autoSave != null)
            state.restore(autoSave);
    }

    public void saveCheckpoint(GameState state) {
        checkpoint = state.save();
    }

    public void loadCheckpoint(GameState state) {
        if (checkpoint != null)
            state.restore(checkpoint);
    }
}
