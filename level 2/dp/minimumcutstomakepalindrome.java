import java.io.*;
import java.util.*;

public class minimumcutstomakepalindrome {

    public static int minPalindromicCut(String s) {
        // write your code here
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int g = 0; g < n; g++) {

            for (int i = 0, j = g; j < n; j++, i++) {
                char sch = s.charAt(i);
                char ech = s.charAt(j);
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (sch == ech) {
                        dp[i][j] = true;
                    }
                } else {
                    if (sch == ech) {
                        if (dp[i + 1][j - 1] == true) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        // System.out.println(dp[0][n - 1]);
        // int[][] strg = new int[n][n];
        // for (int g = 0; g < n; g++) {
        // for (int i = 0, j = g; j < n; i++, j++) {
        // if (g == 0) {
        // strg[i][j] = 0;
        // } else if (g == 1) {
        // if (dp[i][j] == true) {
        // strg[i][j] = 0;
        // } else {
        // strg[i][j] = 1;
        // }
        // } else {
        // if (dp[i][j] == true) {
        // strg[i][j] = 0;
        // } else {
        // int min = Integer.MAX_VALUE;
        // for (int k = i; k < j; k++) {
        // if (strg[i][k] + strg[k + 1][j] < min) {
        // min = strg[i][k] + strg[k + 1][j];
        // }
        // }
        // strg[i][j] = min + 1;
        // }
        // }
        // }
        // }
        // // System.out.println();

        // return strg[0][n - 1];

        int[] strg = new int[n];
        // int j = strg.length - 1;
        for (int i = 0; i < n; i++) {
            if (dp[0][i] == true) {
                // System.out.println("yes");
                strg[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for (int k = i; k > 0; k--) {
                    if (dp[k][i] == true) {
                        min = Math.min(min, strg[k - 1]);
                    }
                }
                strg[i] = min + 1;
            }
        }
        return (strg[n - 1]);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(minPalindromicCut(str));
    }
}