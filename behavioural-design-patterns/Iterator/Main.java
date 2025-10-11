import java.util.*;

class Toy{
    String name;

    Toy(String s){
        this.name = s;
    }

    @Override
    public String toString() {
        return name;
    }
}

class ToyList implements Iterable<Toy>{
    List<Toy> toys = new ArrayList<>();

    void add(Toy t) { toys.add(t); }
    void remove(Toy t) { toys.remove(t); }

    @Override
    public Iterator<Toy> iterator() {
        return new ToyListIterator();
    } ~

    private class ToyListIterator implements Iterator<Toy>{
        private int index = 0;

        public boolean hasNext() { return index < toys.size(); }

        public Toy next() { 
            if ( hasNext() ) return toys.get(index++);
            else throw new NoSuchElementException();
        }
    }
}

public class Main{
    public static void main(String[] args){
        ToyList toys = new ToyList();

        toys.add(new Toy("Car")); 
        toys.add(new Toy("Doll")); 
        toys.add(new Toy("Ball"));

        for (Toy toy : toys) {            
            System.out.println(toy);
        }
    }
}