package Behavioural.Visitor;

public class BonusVisitor implements EmployeeVisitor{
    public void visit(Engineer e){
        System.out.println("Engineer bonus: " + e.getSalary() * 0.1);
    }

    public void visit(Manager m){
        System.out.println("Engineer bonus: " + m.getSalary() * 0.1);
    }
}
