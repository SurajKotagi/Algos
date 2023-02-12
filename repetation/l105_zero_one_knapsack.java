import java.util.*;
import java.io.*;

public class l105_zero_one_knapsack {
    // public class pair {
    // int price;
    // int weight;

    // pair(int price, int weight) {
    // this.price = price;
    // this.weight = weight;
    // }
    // }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scn.nextInt();
        }
        int cap = scn.nextInt();

        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= cap; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int leave = dp[i - 1][j];
                    int select = prices[i - 1] + dp[i - 1][j - weights[i - 1]];

                    dp[i][j] = Math.max(leave, select);
                }
            }
        }
        System.out.println(dp[n][cap]);
    }
}