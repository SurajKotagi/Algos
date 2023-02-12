import java.util.*;
import java.io.*;

public class l103_coin_change_combination {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int amt = scn.nextInt();

        int[][] dp = new int[n + 1][amt + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amt; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // System.out.println(j + " ");
                    // System.out.println(amt);

                    for (int a = arr[i - 1]; a <= j; a = a + arr[i - 1]) {
                        dp[i][j] += dp[i - 1][j - a];
                        // System.out.print(a + " " + j + amt);
                    }

                    dp[i][j] += dp[i - 1][j];
                    // System.out.println();
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        // for (int j = 0; j < dp[0].length; j++) {
        // System.out.print(dp[i][j] + " ");
        // }
        // System.out.println();
        // }
        System.out.println(dp[n][amt]);
    }
}