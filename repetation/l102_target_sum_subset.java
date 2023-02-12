import java.util.*;
import java.io.*;

public class l102_target_sum_subset {
    public static String bs(int n) {
        String res = "";
        while (n > 0) {
            int d = n % 2;

            res += d + "";
            n = n / 2;
        }
        return res;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();

        boolean[][] dp = new boolean[n + 1][tar + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= tar; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (dp[i - 1][j - arr[i - 1]] == true || dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        System.out.println(dp[n][tar]);
    }
}
