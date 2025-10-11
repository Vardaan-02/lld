import java.util.*;

class Event{
    int stat1;
    int stat2;

    Event(int t,int s){
        this.stat1 = t;
        this.stat2 = s;
    }
}

interface Observer{
    void update();
}

class PrimaryUser implements Observer{
    @Override 
    public void update(){
        System.out.println("Primary Notification");
    }
}

class SecondaryUser implements Observer{
    @Override 
    public void update(){
        System.out.println("Secondary Notification");
    }
}

class ThertiaryUser implements Observer{
    @Override 
    public void update(){
        System.out.println("Thertiary Notification");
    }
}

class Subject{
    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o){ observers.add(o); }
    public void removeObserver(Observer o){ observers.remove(o); }

    public void notifyObserver(){
        for ( Observer o : observers ){
            o.update();
        }
    }
}

public class Main{
    public static void main(String[] args){
        Observer arr[] = {new PrimaryUser(), new PrimaryUser(), new SecondaryUser(), new ThertiaryUser()};

        Subject s = new Subject();

        s.addObserver(arr[0]);
        s.addObserver(arr[2]);
        s.addObserver(arr[3]);
        
        s.notifyObserver();

        s.removeObserver(arr[3]);
        s.addObserver(arr[1]);

        s.notifyObserver();
    }
}