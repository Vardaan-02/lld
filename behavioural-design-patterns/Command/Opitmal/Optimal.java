import java.util.*;

interface Command{
    void execute();
    void undo();
}

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

class ForwardCommand implements Command{
    private final Robot r;

    ForwardCommand(Robot r){
        this.r = r;
    }

    @Override 
    public void execute(){
        this.r.forward();
    }

    @Override
    public void undo(){
        this.r.backward();
    }
}

class BackwardCommand implements Command{
    private final Robot r;

    BackwardCommand(Robot r){
        this.r = r;
    }

    @Override 
    public void execute(){
        this.r.backward();
    }

    @Override
    public void undo(){
        this.r.forward();
    }
}

class RotateCommand implements Command{
    private final Robot r;

    RotateCommand(Robot r){
        this.r = r;
    }

    @Override 
    public void execute(){
        this.r.rotate();
    }

    @Override
    public void undo(){
        this.r.rotate();
    }
}

class RemoteControl{
    private Command slot;
    private final Deque<Command> history = new ArrayDeque<>();

    public void setCommand(Command c){
        this.slot = c;
    }

    public void pressButton(){
        if(this.slot == null) { System.out.println("No Command to Execute"); }
        else { slot.execute(); history.push(this.slot); }
    }

    public void pressUndo(){
        if( this.history.isEmpty() ) { System.out.println("No Command executed till now"); }
        else { this.history.pop().undo(); }
    }
}

public class Optimal{
    public static void main(String[] args){
        Robot r = new Robot();

        Command arr[] = {new ForwardCommand(r), new BackwardCommand(r), new RotateCommand(r) };

        RemoteControl rt = new RemoteControl();

        rt.setCommand(arr[0]);
        rt.pressButton();
        rt.setCommand(arr[2]);
        rt.pressButton();
        rt.pressUndo();
        rt.setCommand(arr[1]);
        rt.pressButton();
    }
}