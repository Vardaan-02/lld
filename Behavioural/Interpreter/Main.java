package Behavioural.Interpreter;

import java.util.List;

import Behavioural.Interpreter.calculator.Lexer;
import Behavioural.Interpreter.calculator.Parser;
import Behavioural.Interpreter.calculator.expression.Expression;

public class Main {
    public static void main(String[] args) {

        String input = "2 * (3 + 5) / 2 + 7"; // 15

        Lexer lexer = new Lexer(input);
        List<String> tokens = lexer.tokenize();

        Parser parser = new Parser(tokens);
        Expression expression = parser.parse();

        int result = expression.interpret();

        System.out.println("Result: " + result);
    }
}
