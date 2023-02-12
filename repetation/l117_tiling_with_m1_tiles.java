import java.util.*;
import java.io.*;

public class l117_tiling_with_m1_tiles {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int c = scn.nextInt();
        int r = scn.nextInt();

        int[] dp = new int[c + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= c; i++) {
            if (i < r) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + dp[i - r];
            }
        }
        System.out.println(dp[c]);
    }
}