import java.util.*;
import java.io.*;

public class l111_count_apbpcp {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        int n = s.length();
        int[][] dp = new int[3][n + 1];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                dp[0][i + 1] = dp[0][i + 1 - 1] * 2 + 1;
                dp[1][i + 1] = dp[1][i];
                dp[2][i + 1] = dp[2][i];
            } else if (s.charAt(i) == 'b') {
                dp[1][i + 1] = (2 * dp[1][i + 1 - 1]) + dp[0][i + 1 - 1];
                dp[0][i + 1] = dp[0][i];
                dp[2][i + 1] = dp[2][i];
            } else if (s.charAt(i) == 'c') {
                dp[2][i + 1] = (2 * dp[2][i + 1 - 1]) + dp[1][i + 1 - 1];
                dp[1][i + 1] = dp[1][i];
                dp[0][i + 1] = dp[0][i];
            }
        }
        // for (int i = 0; i <= 2; i++) {
        // for (int j = 0; j <= n; j++) {
        // System.out.print(dp[i][j] + " ");
        // }
        // System.out.println();
        // }

        System.out.println(dp[2][n]);
    }
}