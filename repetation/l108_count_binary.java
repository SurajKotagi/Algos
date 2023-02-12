import java.util.*;
import java.io.*;

public class l108_count_binary {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] dp = new int[2][n + 1];
        dp[1][0] = 0;
        dp[1][1] = 2;

        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[1][i] = dp[1][i - 1] + dp[1][i - 1] - dp[0][i - 1];
            dp[0][i] = dp[0][i - 1] + dp[0][i - 2];

            // System.out.print(dp[1][i] + " ");
        }

        System.out.println(dp[1][n]);

    }
}