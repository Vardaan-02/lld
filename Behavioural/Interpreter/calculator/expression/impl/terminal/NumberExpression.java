package Behavioural.Interpreter.calculator.expression.impl.terminal;

import Behavioural.Interpreter.calculator.expression.Expression;

public class NumberExpression implements Expression{
    private int number;

    public NumberExpression(int n){
        this.number = n;
    }

    public int interpret(){
        return this.number;
    }
}
