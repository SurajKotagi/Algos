import java.io.*;
import java.util.*;

public class l148_infix_conversions {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // logic
        // digits - operands push
        // ( - operator push
        // ) - pop till (
        // else pop till size != 0 || is != ( || priority of peek >= current

        Stack<String> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch <= 'z' && ch >= 'a') {
                operands.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '(' && priority(operators.peek()) >= priority(ch)) {
                    String val2 = operands.pop();
                    String val1 = operands.pop();
                    operands.push(calculate(val1, operators.pop(), val2));
                }
                operators.push(ch);
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(' && priority(operators.peek()) >= priority(ch)) {
                    String val2 = operands.pop();
                    String val1 = operands.pop();
                    operands.push(calculate(val1, operators.pop(), val2));
                }
                operators.pop();
            }
        }
        while (operators.size() > 0) {
            String val2 = operands.pop();
            String val1 = operands.pop();
            operands.push(calculate(val1, operators.pop(), val2));
        }
        System.out.println(operands.pop());

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch <= 'z' && ch >= 'a') {
                operands.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '(' && priority(operators.peek()) >= priority(ch)) {
                    String val2 = operands.pop();
                    String val1 = operands.pop();
                    operands.push(calculate2(val1, operators.pop(), val2));
                }
                operators.push(ch);
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(' && priority(operators.peek()) >= priority(ch)) {
                    String val2 = operands.pop();
                    String val1 = operands.pop();
                    operands.push(calculate2(val1, operators.pop(), val2));
                }
                operators.pop();
            }
        }
        while (operators.size() > 0) {
            String val2 = operands.pop();
            String val1 = operands.pop();
            operands.push(calculate2(val1, operators.pop(), val2));
        }
        System.out.println(operands.pop());
    }

    public static int priority(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }

    public static String calculate(String v1, char op, String v2) {
        if (op == '+') {
            return v1 + v2 + "+";
        } else if (op == '-') {
            return v1 + v2 + "-";
        } else if (op == '*') {
            return v1 + v2 + "*";
        } else if (op == '/') {
            return v1 + v2 + "/";
        }
        return 0 + "";
    }

    public static String calculate2(String v1, char op, String v2) {
        if (op == '+') {
            return "+" + v1 + v2;
        } else if (op == '-') {
            return "-" + v1 + v2;
        } else if (op == '*') {
            return "*" + v1 + v2;
        } else if (op == '/') {
            return "/" + v1 + v2;
        }
        return 0 + "";
    }
}