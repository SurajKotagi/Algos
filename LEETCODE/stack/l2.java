import java.util.*;
import java.io.*;

public class l2 {
    public static void main(String[] args) {
        String s = "(()())(())";

        // StringBuilder sb = new StringBuilder();
        // Stack<Character> st = new Stack<>();
        // for (int i = 0; i < s.length(); i++) {
        // if (s.charAt(i) == ')') {
        // st.pop();
        // }
        // if (st.size() >= 1) {
        // sb.append(s.charAt(i));
        // }
        // if (s.charAt(i) == '(') {
        // st.push('(');
        // }
        // }
        // System.out.println(sb);

        // StringBuilder sb = new StringBuilder();
        // int c = 0;
        // for (int i = 0; i < s.length(); i++) {
        // if (s.charAt(i) == ')') {
        // c--;
        // }
        // if (c >= 1) {
        // sb.append(s.charAt(i));
        // }
        // if (s.charAt(i) == '(') {
        // c++;
        // }
        // }
        // System.out.println(sb);

        String res = "";
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                c--;
            }
            if (c >= 1) {
                res += s.charAt(i);
            }
            if (s.charAt(i) == '(') {
                c++;
            }
        }
        System.out.println(res);
    }
}