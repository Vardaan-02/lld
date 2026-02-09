package Creational.Prototype;

public class Initialization {
    public static void init(){
        Weapon baseWeapon = new Weapon(100);
        Soldier baseSolider = new Soldier(100, baseWeapon);

        PrototypeRegistry.register(PrototypeType.WEAPON, baseWeapon);
        PrototypeRegistry.register(PrototypeType.SOLDIER, baseSolider);
    }
}
