package Behavioural.Command;

import Behavioural.Command.commands.Command;

public class Worker {

    public void process(Command command){
        command.execute();
    }
}
