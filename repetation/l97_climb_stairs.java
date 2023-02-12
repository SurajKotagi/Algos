import java.util.*;
import java.io.*;

public class l97_climb_stairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                dp[i] = 1;
            } else {
                int from1 = (i - 1 >= 0) ? dp[i - 1] : 0;
                int from2 = (i - 2 >= 0) ? dp[i - 2] : 0;
                int from3 = (i - 3 >= 0) ? dp[i - 3] : 0;

                dp[i] = from1 + from2 + from3;
            }
        }

        System.out.println(dp[n]);

    }
}