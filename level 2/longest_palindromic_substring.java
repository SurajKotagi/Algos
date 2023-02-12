import java.util.*;
import java.io.*;

public class longest_palindromic_substring {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        String res = longestps(s);
        System.out.println(res);
    }

    public static String longestps(String s) {

        // making 2d boolean array of string length x string length
        // initially the value is false in all blocks as default
        boolean[][] dp = new boolean[s.length()][s.length()];
        // int max_val = 0;

        // iterating through the array diagonally
        // 0 1 2 3 4
        // 0 x x x x x
        // 1 x x x x
        // 2 x x x
        // 3 x x
        // 4 x

        // i 0 1 2 3 4 i - index
        // 0 1 6 10 13 15 // we have to iterate diagonally from 1 to 15
        // 1 2 7 11 14
        // 2 3 8 12
        // 3 4 9
        // 4 5

        // b a b a d
        // 0 1 2 3 4
        // b 0 t x t x x
        // a 1 t x x x
        // b 2 t x x
        // a 3 t x
        // d 4 t

        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0, g = i; g < s.length(); j++, g++) {
                if (i == 0) {
                    dp[j][g] = true;
                } else if (i == 1) {
                    if (s.charAt(j) == s.charAt(g)) {
                        dp[j][g] = true;
                    }
                } else {
                    if ((s.charAt(j) == s.charAt(g)) && dp[j + 1][g - 1] == true) {
                        dp[j][g] = true;
                    }
                }
                if (dp[j][g] == true) {
                    // max_val = g - j + 1;
                    ans = s.substring(j, g + 1);
                }
            }
        }

        return ans;
    }
}
