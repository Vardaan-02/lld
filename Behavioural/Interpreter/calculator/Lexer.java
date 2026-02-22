package Behavioural.Interpreter.calculator;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private String input;
    private int pos;

    public Lexer(String input){
        this.input = input.replaceAll(" ", "");
        this.pos = 0;
    }

    public List<String> tokenize(){
        List<String> tokens = new ArrayList<>();

        while (pos < input.length()) {
            char ch = input.charAt(pos);

            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (pos < input.length() && Character.isDigit(input.charAt(pos))) {
                    sb.append(input.charAt(pos++));
                }
                tokens.add(sb.toString());
                continue;
            }

            tokens.add(String.valueOf(ch));
            pos++;
        }

        return tokens;
    }
}
