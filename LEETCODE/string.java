import java.util.*;
import java.io.*;

public class string {
    public static StringBuilder rev(StringBuilder s) {
        int i = 0;
        int j = s.length();
        while (i > j) {
            char temp = s.charAt(i);
            s.setCharAt(i, s.charAt(j));
            s.setCharAt(j, temp);
            i++;
            j--;
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "gasdfgjhasgdjg";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                StringBuilder pre = new StringBuilder(s.substring(0, i + 1));
                StringBuilder remaining = new StringBuilder(s.substring(i + 1, s.length()));
                StringBuilder revPre = rev(pre);
                return revPre.append(remaining).toString();
            }
        }
        return s;
    }
}