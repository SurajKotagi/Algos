import java.io.*;
import java.util.*;

public class painthouse {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][3];

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i - 1][j + 2]) + arr[i][j];
                } else if (j == 2) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j - 2]) + arr[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]) + arr[i][j];
                }
                // System.out.println(dp[i][j]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (dp[n - 1][i] < min) {
                min = dp[n - 1][i];
            }
        }
        System.out.println(min % 1000000007);
    }
}