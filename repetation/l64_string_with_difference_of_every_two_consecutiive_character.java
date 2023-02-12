import java.util.*;
import java.io.*;

public class l64_string_with_difference_of_every_two_consecutiive_character {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        String res = s.charAt(0) + "";
        for (int i = 1; i < s.length(); i++) {
            int diff = s.charAt(i) - s.charAt(i - 1);
            res += diff;
            res += s.charAt(i) + "";
        }
        System.out.println(res);
    }
}