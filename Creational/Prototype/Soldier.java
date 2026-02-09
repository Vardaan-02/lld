package Creational.Prototype;

public class Soldier implements Prototype<Soldier> {
    int health;
    Weapon weapon;

    Soldier(int health, Weapon weapon){
        this.health = health;
        this.weapon = weapon;
    }

    public Soldier clone(){
        return new Soldier(this.health, this.weapon.clone());
    }

    public String toString(){
        return health + " " + weapon;
    }
}
