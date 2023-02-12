import java.util.*;
import java.io.*;

public class l63_toggle_case {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (Character.isUpperCase(x) == true) {
                res += Character.toLowerCase(x);
            } else {
                res += Character.toUpperCase(x);
            }
        }
        System.out.println(res);
    }
}