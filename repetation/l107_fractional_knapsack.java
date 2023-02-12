import java.util.*;
import java.io.*;

public class l107_fractional_knapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        double[] price = new double[n];
        double[] weight = new double[n];

        for (int i = 0; i < n; i++) {
            price[i] = scn.nextInt();
        }

        for (int i = 0; i < n; i++) {
            weight[i] = scn.nextInt();
        }
        int cap = scn.nextInt();

        double[][] dp = new double[n + 1][cap + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= cap; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    double op2 = Integer.MIN_VALUE;
                    for (int k = j; k >= 0; k--) {
                        double val = (j - k) * price[i - 1] / weight[i - 1];
                        double max = val + dp[i - 1][k];
                        // if (i == 1 && k == 0 && j == 1) {
                        // System.out.println(price[i - 1] / weight[i - 1]);
                        // }
                        op2 = Math.max(max, op2);
                    }
                    dp[i][j] = op2;
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= cap; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[n][cap]);
    }
}