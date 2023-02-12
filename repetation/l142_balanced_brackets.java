import java.util.*;
import java.io.*;

public class l142_balanced_brackets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')') {
                while (st.size() > 0 && st.peek() != '(')
                    st.pop();
                if (st.size() == 0) {
                    System.out.println(false);
                    return;
                }
                st.pop();
            } else if (ch == '}') {
                while (st.size() > 0 && st.peek() != '{')
                    st.pop();
                if (st.size() == 0) {
                    System.out.println(false);
                    return;
                }
                st.pop();
            } else if (ch == ']') {
                while (st.size() > 0 && st.peek() != '[')
                    st.pop();
                if (st.size() == 0) {
                    System.out.println(false);
                    return;
                }
                st.pop();
            }
        }
        if (st.size() == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}