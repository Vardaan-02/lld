interface MoveStrategy{
    void move();
}

class WalkStrategy implements MoveStrategy{
    public void move(){ System.out.println("Walking"); }
}

class RunStrategy implements MoveStrategy{
    public void move(){ System.out.println("Running"); }
}

class HopStrategy implements MoveStrategy{
    public void move(){ System.out.println("Hopping"); }
}

class Robot{
    private MoveStrategy strategy;

    public Robot(MoveStrategy m) { this.strategy = m; }

    public void setStrategy(MoveStrategy m) { this.strategy = m; }

    public void move(){ strategy.move(); }
}

public class Optimal{
    public static void main(String[] args){
        MoveStrategy strategies[] = {new WalkStrategy(), new RunStrategy(), new HopStrategy()};
        Robot r = new Robot(strategies[0]);
        r.move();
        r.setStrategy(strategies[1]);
        r.move();
    }
}