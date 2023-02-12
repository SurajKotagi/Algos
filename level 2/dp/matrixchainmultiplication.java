import java.io.*;
import java.util.*;

public class matrixchainmultiplication {

    public static int mcm(int[] arr) {

        int n = arr.length - 1;
        int[][] dp = new int[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 0;
                } else if (g == 1) {
                    dp[i][j] = arr[i] * arr[j] * arr[j + 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j] + (arr[i] * arr[k + 1] * arr[j +
                                1]));
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[0][n - 1];

        // int[] dp = new int[n];
        // dp[0] = 0;
        // for (int i = 1; i < n; i++) {
        // for (int k = i; k > 0; k--) {

        // }
        // }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(mcm(arr));
    }

}