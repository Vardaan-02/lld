enum MoveType { WALK, RUN, HOP; }

class Robot{
    private MoveType type;

    public Robot(MoveType t) { this.type = t; }

    public void setType(MoveType t) { this.type = t; }

    public void move() { 
        switch (type) {
            case WALK:
                System.out.println("Walking");
                break;
            case RUN:
                System.out.println("Running");
                break;
            case HOP:
                System.out.println("Hopping");
                break;
            default:
                System.out.println("Standing");
        }
    }
}

public class Naive{
    public static void main(String[] args){
        Robot r = new Robot(MoveType.WALK);
        r.move();
        r.setType(MoveType.RUN);
        r.move();
    }
}