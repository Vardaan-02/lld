package Creational.Prototype;

public class Weapon implements Prototype<Weapon>{
    int damage;

    Weapon(int damage){
        this.damage = damage;
    }

    public Weapon clone(){
        return new Weapon(this.damage);
    }

    public String toString(){
        return damage + " ";
    }
}
