import java.util.*;
import java.io.*;

public class l62_string_compression {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        compression1(s);
        compression2(s);

    }

    public static void compression1(String s) {
        String res = s.charAt(0) + "";

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                continue;
            } else {
                res += s.charAt(i);
            }
        }

        System.out.println(res);
    }

    public static void compression2(String s) {
        String res = s.charAt(0) + "";

        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
            } else {
                res += (count == 1) ? "" + s.charAt(i) : count + "" + s.charAt(i);
                count = 1;
            }
        }
        res += (count == 1) ? "" : count;

        System.out.println(res);
    }
}