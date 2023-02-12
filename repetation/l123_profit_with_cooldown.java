import java.util.*;
import java.io.*;

public class l123_profit_with_cooldown {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] price = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            price[i] = scn.nextInt();
        }

        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[1][0] = -1 * price[1];
            } else {
                dp[i][0] = Math.max(dp[i - 1][2] - price[i], dp[i - 1][0]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + price[i]);
                dp[i][2] = dp[i - 1][1];
            }
        }
        System.out.println(dp[n][1]);
    }
}