import java.util.*;
import java.io.*;

public class l99_climb_stairs_with_mninimum_moves {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] steps = new int[n];
        for (int i = 0; i < n; i++) {
            steps[i] = scn.nextInt();
        }

        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= steps[i]; j++) {
                if (i + j <= n && dp[i + j] != null) {
                    min = Math.min(min, dp[i + j]);
                }
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
                // System.out.println(dp[i]);
            }
        }
        System.out.println(dp[0]);
    }
}