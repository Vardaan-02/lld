class Animal{
    static {
        System.out.println("Animal static block\n\n");
    } // jab pheli baar object bnega tab static block lauch hoga

    Animal(){
        System.out.println("Animal Constructor");
    }

    void sound(){
        System.out.println("Some sound");
    }
}

class Dog extends Animal{
    Dog(){
        System.out.println("Dog Constructor");
    }

    void eat(){
        System.out.println("Pedigree");
    }

    @Override
    void sound(){
        System.out.println("Bark");
    }
}

class Cat extends Animal{
    Cat(){
        System.out.println("Cat Constructor");
    }

    @Override
    void sound(){
        System.out.println("Meow");
    }
}

class Bat extends Animal{
    Bat(){
        System.out.println("Bat Constructor");
    }
}

interface Calculator{
    default void calculate(){
        System.out.println("Calculation Done form Calculator 1");
    } // defautl function defination, hehe DRY
}

interface Calculator2{
    default void calculate(){
        System.out.println("Calculation Done from Calculator 2");
    }
}

class ModernCalculator implements Calculator, Calculator2{
    @Override
    public void calculate(){
        Calculator2.super.calculate(); // multiple inhertance solved without diamond problem 
        // forced to override this 
    }
}

class SemiModernCalculator implements Calculator{
    // no need to override calculate
}

public class Test{

    static{
        System.out.println("Hello\n\n");
    }

    public static void main(String args[]){
        Animal a = new Cat();
        // constutor of Animal called before constrtor of Cat

        System.out.println("\n\n");

        Animal arr[] = {new Cat(), new Dog(), new Bat()}; // jiska object hoga vhi bnega
        
        // arr[0].bark(); // this is animal, therefore it has no bark method // throws compile time error

        System.out.println("\n\n");

        arr[0].sound(); // but this is a cat object so method is called for cat object

        System.out.println("\n\n");

        ModernCalculator m = new ModernCalculator();

        m.calculate();

        System.out.println("\n\n");

        SemiModernCalculator sm = new SemiModernCalculator();

        sm.calculate();        
    }
}