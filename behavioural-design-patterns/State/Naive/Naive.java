class Robot{
    private String state; 

    public Robot(String state) { this.state = state; }

    public void pressButton() {
        if ("playing".equals(state)) {
            System.out.println("Wheels spin, robot dances!");
        } else if ("sleeping".equals(state)) {
            System.out.println("Beep... zzz. No response.");
        } else if ("charging".equals(state)) {
            System.out.println("Charging... can't play.");
        } else {
            System.out.println("Unknown state.");
        }
    }

    public void setState(String state) { this.state = state; }
}

public class Naive {
    public static void main(String[] args) {
        Robot r = new Robot("playing");
        r.pressButton();      
        r.setState("sleeping");
        r.pressButton();    
    }
}
