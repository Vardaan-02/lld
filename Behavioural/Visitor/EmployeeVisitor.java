package Behavioural.Visitor;

public interface EmployeeVisitor {
    void visit(Engineer e);
    void visit(Manager m);
}
