import java.util.*;
import java.io.*;

public class l118_friends_pairing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + (dp[i - 2] * (i - 1));
        }

        System.out.println(dp[n]);
    }
}