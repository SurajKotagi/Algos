import java.util.*;
import java.io.*;

public class l61_print_all_palindromic_substrings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int n = s.length();

        // method 1

        // boolean[][] dp = new boolean[n][n];

        // for (int g = 0; g < n; g++) {
        // for (int i = 0, j = g; j < n; i++, j++) {
        // String ss = s.substring(i, j + 1);
        // if (g == 0) {
        // dp[i][j] = true;
        // System.out.println(ss);
        // } else if (g == 1) {
        // if (ss.charAt(0) == ss.charAt(1)) {
        // dp[i][j] = true;
        // System.out.println(ss);
        // }
        // } else {
        // if (ss.charAt(0) == s.charAt(ss.length() - 1) && dp[i + 1][j - 1] == true) {
        // System.out.println(ss);
        // dp[i][j] = true;
        // }
        // }
        // }

        // }

        // method 2
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String ss = s.substring(i, j + 1);
                if (isPalindrome(ss) == true) {
                    System.out.println(ss);
                }
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int st = 0;
        int en = s.length() - 1;
        while (st < en) {
            if (s.charAt(st) == s.charAt(en)) {
                st++;
                en--;
            } else {
                return false;
            }
        }
        return true;
    }
}