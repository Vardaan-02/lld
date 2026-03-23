package Behavioural.Visitor;

public class Manager implements Employee{
    private int salary;

    public Manager(int salary){
        this.salary = salary;
    }

    int getSalary(){
        return this.salary;
    }

    public void accept(EmployeeVisitor ev){
        ev.visit(this);
    }
}
