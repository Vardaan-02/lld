package Behavioural.Interpreter.calculator;

import java.util.List;

import Behavioural.Interpreter.calculator.expression.Expression;
import Behavioural.Interpreter.calculator.expression.impl.non_terminal.AddExpression;
import Behavioural.Interpreter.calculator.expression.impl.non_terminal.DivisionExpression;
import Behavioural.Interpreter.calculator.expression.impl.non_terminal.MultiplyExpression;
import Behavioural.Interpreter.calculator.expression.impl.non_terminal.SubtractExpression;
import Behavioural.Interpreter.calculator.expression.impl.terminal.NumberExpression;

public class Parser {
    private List<String> tokens;
    private int pos = 0;

    public Parser(List<String> tokens) {
        this.tokens = tokens;
    }

    public Expression parse() {
        return parseExpression();
    }

    private Expression parseExpression() {
        Expression expr = parseTerm();

        while (pos < tokens.size()) {
            String token = tokens.get(pos);

            if (token.equals("+")) {
                pos++;
                expr = new AddExpression(expr, parseTerm());
            } else if (token.equals("-")) {
                pos++;
                expr = new SubtractExpression(expr, parseTerm());
            } else {
                break;
            }
        }

        return expr;
    }

    private Expression parseTerm() {
        Expression expr = parseFactor();

        while (pos < tokens.size()) {
            String token = tokens.get(pos);

            if (token.equals("*")) {
                pos++;
                expr = new MultiplyExpression(expr, parseFactor());
            } else if (token.equals("/")) {
                pos++;
                expr = new DivisionExpression(expr, parseFactor());
            } else {
                break;
            }
        }

        return expr;
    }

    private Expression parseFactor() {
        String token = tokens.get(pos);

        if (token.equals("(")) {
            pos++;
            Expression expr = parseExpression();
            pos++;
            return expr;
        }

        pos++;
        return new NumberExpression(Integer.parseInt(token));
    }
}
