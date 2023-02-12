import java.util.*;
import java.io.*;

public class l125_max_profit_with_k_transactions {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                max = Math.max(max, dp[i - 1][j - 1] - p[j - 1]);
                dp[i][j] = Math.max(max + p[j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[k][n - 1]);
    }
}