import java.util.*;
import java.io.*;

public class Qn1614_maximum_nesting_depth_of_parenthesis {
    public static void main(String[] args) {
        String s = "sdgfjhsgdjh";

        // code
        int res = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else if (s.charAt(i) == ')') {
                st.pop();
            }
            res = Math.max(res, st.size());
        }
        return res;

        int count = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                c++;
            } else if (s.charAt(i) == ')') {
                c--;
            }
            count = Math.max(count, c);
        }
        return count;
    }
}