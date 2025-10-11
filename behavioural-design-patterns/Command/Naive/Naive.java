class Robot{
    void forward(){
        System.out.println("Forward");
    }

    void backward(){
        System.out.println("Backward");
    }

    void rotate(){
        System.out.println("Rotate");
    }
}

public class Naive{
    public static void main(String[] args){
        Robot r = new Robot();

        r.forward();
        r.forward();
        r.backward();
    }
}