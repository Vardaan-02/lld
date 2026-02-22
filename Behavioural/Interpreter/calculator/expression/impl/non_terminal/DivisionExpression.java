package Behavioural.Interpreter.calculator.expression.impl.non_terminal;

import Behavioural.Interpreter.calculator.expression.Expression;

public class DivisionExpression extends NonTerminalExpression{
    
    public DivisionExpression(Expression left, Expression right){
        super(left, right);
    }

    @Override
    public int interpret(){
        return this.left.interpret() / this.right.interpret();
    }
}
