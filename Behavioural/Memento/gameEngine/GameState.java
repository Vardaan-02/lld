package Behavioural.Memento.gameEngine;

import java.util.*;

public class GameState {

    private String worldId;
    private int playerX;
    private int playerY;
    private Player player;
    private Map<String, Integer> inventory;
    private List<String> completedQuests;
    private long playTime;

    public GameState(String worldId) {
        this.worldId = worldId;
        this.inventory = new HashMap<>();
        this.completedQuests = new ArrayList<>();
    }

    public void movePlayer(int x, int y) {
        this.playerX = x;
        this.playerY = y;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addItem(String item, int quantity) {
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    public void completeQuest(String quest) {
        completedQuests.add(quest);
    }

    public void incrementPlayTime(long seconds) {
        playTime += seconds;
    }

    public GameStateSnapshot save() {
        return new GameStateSnapshot(
                worldId,
                playerX,
                playerY,
                player.clone(),
                new HashMap<>(inventory),
                new ArrayList<>(completedQuests),
                playTime);
    }

    public void restore(GameStateSnapshot snapshot) {
        this.worldId = snapshot.worldId;
        this.playerX = snapshot.playerX;
        this.playerY = snapshot.playerY;
        this.player = snapshot.player.clone();
        this.inventory = new HashMap<>(snapshot.inventory);
        this.completedQuests = new ArrayList<>(snapshot.completedQuests);
        this.playTime = snapshot.playTime;
    }

    public static class GameStateSnapshot {
        private final String worldId;
        private final int playerX;
        private final int playerY;
        private final Player player;
        private final Map<String, Integer> inventory;
        private final List<String> completedQuests;
        private final long playTime;

        private GameStateSnapshot(String worldId, int playerX, int playerY, Player player, Map<String, Integer> inventory, List<String> completedQuests, long playTime) {
            this.worldId = worldId;
            this.playerX = playerX;
            this.playerY = playerY;
            this.player = player;
            this.inventory = inventory;
            this.completedQuests = completedQuests;
            this.playTime = playTime;
        }
    }
}
