package Behavioural.Visitor;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Engineer(100000);
        Employee e2 = new Manager(200000);

        EmployeeVisitor bonusVisitor = new BonusVisitor();

        e1.accept(bonusVisitor);
        e2.accept(bonusVisitor);
    }
}
