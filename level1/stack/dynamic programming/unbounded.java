import java.io.*;
import java.util.*;

public class unbounded {

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

        // Unbounded Knapsack
        // note : we use 1d array dp

        int[] dp = new int[cap + 1];
        dp[0] = 0;

        // in the dp the maximum value possible is stored
        for (int j = 1; j <= cap; j++) {
            int maxv = 0;
            for (int i = 0; i < values.length; i++) {
                int val = 0;
                if (weights[i] <= j) {
                    val = values[i] + dp[j - weights[i]];
                } else {
                    val = dp[j];
                }
                if (val > maxv)
                    maxv = val;
            }
            dp[j] = maxv;
        }
        System.out.println(dp[cap]);
    }
}