import java.io.*;
import java.util.*;

public class l150_pewfix_evaluation_and_conversion {
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
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch <= '9' && ch >= '0') {
                operands.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String val1 = operands.pop();
                String val2 = operands.pop();
                operands.push(calculate(val1, ch, val2));
            }
        }
        System.out.println(operands.pop());

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch <= '9' && ch >= '0') {
                operands.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String val1 = operands.pop();
                String val2 = operands.pop();
                operands.push(calculate2(val1, ch, val2));
            }
        }
        System.out.println(operands.pop());

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch <= '9' && ch >= '0') {
                operands.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String val1 = operands.pop();
                String val2 = operands.pop();
                operands.push(calculate3(val1, ch, val2));
            }
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
            return (Integer.parseInt(v1) + Integer.parseInt(v2)) + "";
        } else if (op == '-') {
            return (Integer.parseInt(v1) - Integer.parseInt(v2)) + "";
        } else if (op == '*') {
            return (Integer.parseInt(v1) * Integer.parseInt(v2)) + "";
        } else if (op == '/') {
            return (Integer.parseInt(v1) / Integer.parseInt(v2)) + "";
        }
        return 0 + "";
    }

    public static String calculate2(String v1, char op, String v2) {
        if (op == '+') {
            return "(" + v1 + "+" + v2 + ")";
        } else if (op == '-') {
            return "(" + v1 + "-" + v2 + ")";
        } else if (op == '*') {
            return "(" + v1 + "*" + v2 + ")";
        } else if (op == '/') {
            return "(" + v1 + "/" + v2 + ")";
        }
        return 0 + "";
    }

    public static String calculate3(String v1, char op, String v2) {
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
}