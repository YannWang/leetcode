package leetcode;

import java.util.Stack;

/**
 * Created by tech4 on 2015/7/16.
 */
public class BasicCalculator {
    public static int calculate(String s) {
        if (s == "") return 0;
        int result;
        String[] tokens = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String st : tokens) {
            sb.append(st.trim());
        }
        s = sb.toString();
        char[] seq = s.toCharArray();
        Stack<String> stack = new Stack<>();
        String expression = "";
        for (char aSeq : seq) {
            if (aSeq == '(') {
                stack.push(expression);
                expression = "";
                stack.push("(");
            } else if (aSeq == ')') {
                String current = expression;
                expression = "";
                while (!stack.peek().equals("(")) {
                    current = stack.pop() + current;
                }
                stack.pop();
                stack.push(calcOrdinaryExpression(current));
            } else {
                expression += aSeq;
            }
        }
        while (!stack.isEmpty()) {
            expression = stack.pop() + expression;
        }
        return Integer.valueOf(calcOrdinaryExpression(expression));
    }

    private static String calcOrdinaryExpression(String s) {
        String token = "0";
        int result = 0;
        char operator = '+';
        char[] seq = s.toCharArray();
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == '+' || seq[i] == '-') {
                if (i != 0 && (seq[i - 1] == '+' || seq[i - 1] == '-')) {
                    if (operator == seq[i]) operator = '+';
                    else operator = '-';
                } else {
                    result = (operator == '+') ? result + Integer.valueOf(token) : result - Integer.valueOf(token);
                    operator = seq[i];
                    token = "0";
                }
            } else {
                token += seq[i];
            }
        }
        result = (operator == '+') ? result + Integer.valueOf(token) : result - Integer.valueOf(token);
        return "" + result;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
//        String s = " 2-1 + 2 ";
//        String s = "1 + 1";
//        String s = "2-(5-6)";
//        String s = "(5-(1+(5)))";
//        System.out.println(calcOrdinaryExpression(s));
//        char[] seq = s.toCharArray();
        System.out.println(calculate(s));
    }
}
