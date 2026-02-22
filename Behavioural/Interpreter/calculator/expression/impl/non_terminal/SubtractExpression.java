package Behavioural.Interpreter.calculator.expression.impl.non_terminal;

import Behavioural.Interpreter.calculator.expression.Expression;

public class SubtractExpression extends NonTerminalExpression{
    public SubtractExpression(Expression left, Expression right){
        super(left, right);
    }

    @Override
    public int interpret(){
        return this.left.interpret() - this.right.interpret();
    }
}
