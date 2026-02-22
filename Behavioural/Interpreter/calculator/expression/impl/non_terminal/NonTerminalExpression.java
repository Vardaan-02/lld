package Behavioural.Interpreter.calculator.expression.impl.non_terminal;

import Behavioural.Interpreter.calculator.expression.Expression;

public abstract class NonTerminalExpression implements Expression{
    protected Expression left;
    protected Expression right;

    public NonTerminalExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public abstract int interpret();
}
