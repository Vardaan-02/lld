class Room {
    int doors;
    int windows;

    private Room(Builder builder) {
        this.doors = builder.doors;
        this.windows = builder.windows;
    }

    public static class Builder {
        private int doors;
        private int windows;

        public Builder doors(int doors) { this.doors = doors; return this; }
        public Builder windows(int windows) { this.windows = windows; return this; }
        public Room build() { return new Room(this); }
    }

    @Override
    public String toString() {
        return "Room { doors=" + doors + ", windows=" + windows + " }";
    }
}

class Castle {
    String walls;
    String roof;
    java.util.List<Room> rooms = new java.util.ArrayList<>();

    private Castle() {}

    interface WallStep { RoofStep buildWalls(String walls); }
    interface RoofStep { BuildStep buildRoof(String roof); }
    interface BuildStep { BuildStep addRoom(Room room); Castle build(); }

    public static class Builder implements WallStep, RoofStep, BuildStep {
        private Castle castle = new Castle();

        @Override
        public RoofStep buildWalls(String walls) {
            castle.walls = walls;
            return this;
        }

        @Override
        public BuildStep buildRoof(String roof) {
            castle.roof = roof;
            return this;
        }

        @Override
        public BuildStep addRoom(Room room) {
            castle.rooms.add(room);
            return this;
        }

        @Override
        public Castle build() {
            return castle;
        }
    }

    @Override
    public String toString() {
        return "Castle { walls='" + walls + "', roof='" + roof + "', rooms=" + rooms + " }";
    }
}

public class Advanced {
    public static void main(String[] args) {
        Room room1 = new Room.Builder().doors(1).windows(2).build();
        Room room2 = new Room.Builder().doors(2).windows(1).build();

        Castle castle = new Castle.Builder()
                .buildWalls("Stone")
                .buildRoof("Tile")
                .addRoom(room1)
                .addRoom(room2)
                .build();

        System.out.println(castle);
    }
}
