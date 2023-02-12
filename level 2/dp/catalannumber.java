import java.io.*;
import java.util.*;

public class catalannumber {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0, k = i - 1; j < i; j++, k--) {
                dp[i] += dp[j] * dp[k];
            }
        }
        System.out.println(dp[n]);
    }

}