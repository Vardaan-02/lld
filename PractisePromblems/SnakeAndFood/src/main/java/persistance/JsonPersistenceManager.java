package main.java.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.java.state.GameStateMemento;

public class JsonPersistenceManager implements PersistenceManager {

    private final Gson gson;

    public JsonPersistenceManager() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void saveGame(GameStateMemento memento, String filepath) {
        Path targetPath = Paths.get(filepath);
        
        Path tempPath = Paths.get(filepath + ".tmp");

        try {
            String json = gson.toJson(memento);
            
            Files.writeString(tempPath, json);

            Files.move(tempPath, targetPath, 
                       StandardCopyOption.REPLACE_EXISTING, 
                       StandardCopyOption.ATOMIC_MOVE);
            
        } catch (IOException e) {
            throw new PersistenceException("Failed to save game state to " + filepath, e);
        }
    }

    @Override
    public GameStateMemento loadGame(String filepath) {
        Path path = Paths.get(filepath);
        if (!Files.exists(path)) {
            throw new PersistenceException("Save file not found: " + filepath);
        }

        try {
            String json = Files.readString(path);
            return gson.fromJson(json, GameStateMemento.class);
            
        } catch (IOException e) {
            throw new PersistenceException("Failed to read save file from " + filepath, e);
        } catch (Exception e) {
             throw new PersistenceException("Save file is corrupted or incompatible.", e);
        }
    }

    @Override
    public void saveHighScore(int score, String playerName) {
        // In a full implementation, this would read an existing leaderboard.json,
        // append the new score, sort it, and write it back using the same atomic approach.
    }
}