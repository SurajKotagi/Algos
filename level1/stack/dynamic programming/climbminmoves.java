import java.io.*;
import java.util.*;

public class climbminmoves {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        csmin(arr);
        // System.out.println(min);
    }

    public static void csmin(int[] arr) {
        int n = arr.length;

        // using Integer because we need null
        Integer[] dp = new Integer[n + 1];

        // base case
        // 0 moves required to go from n to n
        dp[n] = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;

            // arr[i] gives ho many steps we can jump from ith step
            // i + j th index should within range and element at that index should not be
            // null
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {

                if (dp[i + j] != null) {
                    min = Math.min(min, dp[i + j]);
                }
            }

            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1; // +1 (important)
            }
        }
        System.out.println(dp[0]);
    }

}