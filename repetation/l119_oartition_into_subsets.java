import java.util.*;
import java.io.*;

public class l119_oartition_into_subsets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == 0 || j == 0) {
                } else if (j == 1 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + j * dp[i - 1][j];
                }
            }
        }
        // for (int i = 0; i <= n; i++) {
        // for (int j = 0; j <= k; j++) {
        // System.out.print(dp[i][j] + " ");
        // }
        // System.out.println();
        // }
        System.out.println(dp[n][k]);
    }
}