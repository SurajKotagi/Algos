import java.util.*;
import java.io.*;

public class l24_pattern_13 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // method 1

        // int[][] dp = new int[n][n];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // if (j <= i) {
        // if (j == 0) {
        // dp[i][j] = 1;
        // System.out.print("1\t");
        // } else if (i == j) {
        // dp[i][j] = 1;
        // System.out.print("1\t");
        // } else {
        // dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
        // System.out.print(dp[i][j] + "\t");
        // }
        // } else {
        // System.out.print("\t");
        // }
        // }
        // System.out.println();
        // }

        // method 2
        // combination method
        // nC(r+1) = nCr.(n-r) / r+1

        for (int i = 0; i < n; i++) {
            int x = 1;
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    System.out.print("1\t");
                } else {
                    x = x * (i - (j - 1)) / (j);
                    System.out.print(x + "\t");
                }

            }
            System.out.println();
        }
    }
}