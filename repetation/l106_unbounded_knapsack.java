import java.util.*;
import java.io.*;

public class l106_unbounded_knapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = scn.nextInt();
        }

        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = scn.nextInt();
        }
        int cap = scn.nextInt();

        int[] dp = new int[cap + 1];
        for (int i = 0; i <= cap; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else {
                int max = Integer.MIN_VALUE;
                for (int j = 0; j < n; j++) {
                    if (weight[j] <= i) {
                        max = Math.max(max, price[j] + dp[i - weight[j]]);
                    }
                }
                dp[i] = (max == Integer.MIN_VALUE) ? 0 : max;
            }
        }
        // for (int x : dp) {
        // System.out.print(x + " ");
        // }
        System.out.println(dp[cap]);
    }

}