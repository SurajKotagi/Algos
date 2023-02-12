import java.util.*;
import java.io.*;

public class l98_climb_stairs_with_variable_jumps {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] steps = new int[n];
        for (int i = 0; i < n; i++) {
            steps[i] = scn.nextInt();
        }

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = 1;
            }
            for (int j = 1; j <= steps[i]; j++) {
                if (i + j <= n) {
                    dp[i + j] += dp[i];
                }
            }
        }
        System.out.println(dp[n]);
    }
}