import java.util.Date;

// Shallow Copy
class Toy implements Cloneable{
    String name;
    Date producedOn; 

    Toy(String name, Date producedOn) {
        this.name = name;
        this.producedOn = producedOn;
    }

    @Override
    public Toy clone() {
        try {
            return (Toy) super.clone(); // Shallow Copy
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString(){
        return "Toy has name " + this.name + " and it was produced on " + this.producedOn;
    }
}


// Deep Copy
// class Toy {
//     String name;
//     Date producedOn;

//     Toy(String name, Date producedOn) {
//         this.name = name;
//         this.producedOn = producedOn;
//     }

//     Toy(Toy other) {
//         this.name = other.name;
//         this.producedOn = new Date(other.producedOn.getTime()); // Deep Copy
//     }

//     @Override
//     public Toy clone() {
//         return new Toy(this);
//     }

//     @Override
//     public String toString(){
//         return "Toy has name " + this.name + " and it was produced on " + this.producedOn;
//     }
// }


public class Prototype{
    public static void main(String[] args){
        Toy a = new Toy("Teddy", new Date());

        Toy b = a.clone();
        b.name = "Teddy Jr.";
        b.producedOn.setTime(0);

        System.out.println(a);
        System.out.println(b);
    }
}