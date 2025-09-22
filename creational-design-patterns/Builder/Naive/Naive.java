class House {
    String walls;
    int rooms;
    boolean hasGarage;
    boolean hasPool;
    boolean hasGarden;

    public House(String walls, int rooms, boolean hasGarage, boolean hasPool, boolean hasGarden) {
        this.walls = walls;
        this.rooms = rooms;
        this.hasGarage = hasGarage;
        this.hasPool = hasPool;
        this.hasGarden = hasGarden;
    }

    @Override
    public String toString() {
        return "House with\n" + walls + " walls\n" + rooms + " rooms" + "\nGarage: " + hasGarage + "\nPool: " + hasPool
        + "\nGarden: " + hasGarden + "\n";
    }
}

public class Naive {
    public static void main(String[] args) {

        House house1 = new House("Brick", 3, true, false, true);
        House house2 = new House("Wood", 2, false, false, false);
        House house3 = new House("Concrete", 5, true, true, true);

        System.out.println(house1);
        System.out.println(house2);
        System.out.println(house3);
    }
}
