package Behavioural.Interpreter.calculator.expression.impl.non_terminal;

import Behavioural.Interpreter.calculator.expression.Expression;

public class AddExpression extends NonTerminalExpression{

    public AddExpression(Expression left, Expression right){
        super(left, right);
    }

    @Override
    public int interpret(){
        return this.left.interpret() + this.right.interpret();
    }
}
