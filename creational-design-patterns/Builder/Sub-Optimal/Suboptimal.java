class House{
    private String walls;
    private int rooms;
    private boolean hasGarage;
    private boolean hasPool;
    private boolean hasGarden;

    private House(){} ;

    public static class Builder {
        private House house = new House();

        public Builder walls(String walls) { house.walls = walls; return this; } 
        public Builder rooms(int rooms) { house.rooms = rooms; return this; }
        public Builder garage(boolean hasGarage) { house.hasGarage = hasGarage; return this; }
        public Builder pool(boolean hasPool) { house.hasPool = hasPool; return this; }
        public Builder garden(boolean hasGarden) { house.hasGarden = hasGarden; return this; }

        public House build() { return house; }
    }

    @Override
    public String toString() {
        return "House{ " + "walls='" + walls + '\'' 
        + ", rooms = " + rooms +", garage = " + hasGarage +", pool = " + hasPool + ", garden = " + hasGarden + " }";
    }
}

// you can use factory here. the factory will take in a house builder and create different types of houses for you

public class Suboptimal{
    public static void main(String[] args){
        House house = new House.Builder().walls("Brick").rooms(4).garage(true).pool(true).build();

        System.out.println(house);
    }
}