package commands;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandHistory {
    private final Deque<Command> history;

    public CommandHistory(){
        history = new ArrayDeque<Command>();
    }

    public void push(Command c){
        c.execute();
        history.push(c);
    }

    public void pop(){
        if (!history.isEmpty()) {
            Command c = history.pop();
            c.undo();
        } else {
            System.out.println("Nothing to undo!");
        }
    }
}
