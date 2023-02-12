import java.io.*;
import java.util.*;

public class ktrans {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        int t = scn.nextInt();

        int[][] dp = new int[t + 1][prices.length];

        // for(int i = 1; i <= t; i++){
        // for(int j = 1; j < prices.length; j++){
        // int max = 0;
        // for(int k = j-1; k >= 0; k--){
        // int cmax = prices[j] - prices[k] + dp[i-1][k];
        // if(cmax > max) max = cmax;
        // }
        // dp[i][j] = Math.max(dp[i][j-1], max);
        // }
        // }
        // Or
        for (int i = 1; i <= t; i++) {
            int max = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + max);
                if (dp[i - 1][j] - prices[j] > max) {
                    max = dp[i - 1][j] - prices[j];
                }
            }
        }

        // for(int i = 1; i <= t; i++){
        // for(int j = 0; j < prices.length; j++){
        // System.out.print(dp[i][j]+" ");
        // }
        // System.out.println();
        // }

        System.out.println(dp[t][n - 1]);
    }
}