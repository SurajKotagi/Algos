import java.io.*;
import java.util.*;

public class o1lnapsack {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scn.nextInt();
        }

        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scn.nextInt();
        }

        int cap = scn.nextInt();

        // --------- 0 1 2 3 4 5 6 7 upto cap
        // wt1(val1)
        // wt2(val2)
        // continues

        // in every dp[][], max value possible is stored
        int[][] dp = new int[n][cap + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= cap; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    if (weights[i] <= j) {
                        dp[i][j] = values[i];
                    }
                } else {
                    if (weights[i] <= j) {
                        int no = dp[i - 1][j];
                        int yes = values[i] + dp[i - 1][j - weights[i]];

                        dp[i][j] = Math.max(no, yes);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }

                }
            }
        }
        System.out.println(dp[n - 1][cap]);
    }
}