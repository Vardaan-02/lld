package Behavioural.Visitor;

public class Engineer implements Employee{
    private int salary;

    public Engineer(int salary){
        this.salary = salary;
    }

    int getSalary(){
        return this.salary;
    }

    public void accept(EmployeeVisitor ev){
        ev.visit(this);
    }
}
