import java.util.*;
import java.io.*;

public class l115_paint_fence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int[][] dp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i][2] = k;
            } else if (i == 2) {
                dp[i][0] = k;
                dp[i][1] = k * (k - 1);
                dp[i][2] = dp[i][0] + dp[i][1];
            } else {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][2] * (k - 1);
                dp[i][2] = dp[i][0] + dp[i][1];
            }
        }
        System.out.println(dp[n][2]);
    }
}