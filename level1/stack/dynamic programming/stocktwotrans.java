import java.io.*;
import java.util.*;

public class stocktwotrans {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        int max_profit = solution1(prices, n);
        System.out.println(max_profit);
    }

    public static int solution1(int[] prices, int n) {
        int[][] dp = new int[3][n];

        // row 0 - max profit possible till today

        int minimum = prices[0];
        for (int j = 0; j < n; j++) {
            if (prices[j] < minimum) {
                minimum = prices[j];
                dp[0][j] = dp[0][j - 1];
            } else {
                if (j != 0) {
                    dp[0][j] = Math.max(prices[j] - minimum, dp[0][j - 1]);
                } else {
                    dp[0][j] = prices[j] - minimum;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            System.out.print(dp[0][j] + " ");
        }
        System.out.println();
        // row 2 - max profit in future if buy today

        int maximum = prices[n - 1];
        for (int j = n - 1; j >= 0; j--) {
            if (prices[j] > maximum) {
                maximum = prices[j];
                dp[2][j] = dp[2][j + 1];
            } else {
                if (j != n - 1) {
                    dp[2][j] = Math.max(maximum - prices[j], dp[2][j + 1]);
                } else {
                    dp[2][j] = maximum - prices[j];
                }
            }
        }
        for (int j = 0; j < n; j++) {
            System.out.print(dp[2][j] + " ");
        }
        System.out.println();

        // row 1 - max profit
        int max_prof = 0;
        for (int j = 0; j < n; j++) {
            if (dp[0][j] + dp[2][j] > max_prof) {
                max_prof = dp[0][j] + dp[2][j];
            }
        }
        for (int j = 0; j < n; j++) {
            System.out.print(dp[1][j] + " ");
        }
        System.out.println();
        return max_prof;
    }
}