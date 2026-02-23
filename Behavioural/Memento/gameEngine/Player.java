package Behavioural.Memento.gameEngine;


public class Player{
    private int health;
    private int mana;
    private String equippedWeapon;

    public Player(int health, int mana, String weapon) {
        this.health = health;
        this.mana = mana;
        this.equippedWeapon = weapon;
    }

    public Player clone() {
        return new Player(health, mana, equippedWeapon);
    }
}
