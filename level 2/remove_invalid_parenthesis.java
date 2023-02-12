import java.io.*;
import java.util.*;

public class remove_invalid_parenthesis {

    public static void solution(String str, int minRemoval, HashSet<String> ans) {
        if (minRemoval == 0) {
            int remnow = getMin(str);
            if (remnow == 0) {
                if (ans.contains(str) == false) {
                    System.out.println(str);
                    ans.add(str);
                }
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String sleft = str.substring(0, i);
            String sright = str.substring(i + 1);

            solution(sleft + sright, minRemoval - 1, ans);
        }
    }

    public static int getMin(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.size() == 0) {
                    st.push(ch);
                } else if (st.peek() == ')') {
                    st.push(ch);
                } else if (st.peek() == '(') {
                    st.pop();
                }
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str, getMin(str), new HashSet<>());
    }

}