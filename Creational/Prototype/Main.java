package Creational.Prototype;

public class Main {
    public static void main(String args[]){
        Initialization.init();

        Weapon excalibur = PrototypeRegistry.getClone(PrototypeType.WEAPON);
        excalibur.damage = 1000;

        Soldier elite = PrototypeRegistry.getClone(PrototypeType.SOLDIER);
        elite.health = 1000;
        elite.weapon = excalibur;

        System.out.println(elite);
    }
}
