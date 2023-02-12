import java.util.*;
import java.io.*;

public class l122_profit_with_transactionfee_infinite_transactions {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] price = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            price[i] = scn.nextInt();
        }

        int fee = scn.nextInt();

        int[][] dp = new int[n + 1][2];
        dp[1][0] = -1 * price[1];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - price[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + price[i] - fee);
        }

        System.out.println(dp[n][1]);
    }
}