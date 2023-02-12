import java.io.*;
import java.util.*;

public class cstairswithjump {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        // cswj - climb stairs with jumps
        int paths = cswj(arr);
        System.out.println(paths);
    }

    public static int cswj(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        // we need to calculate paths possible from 0 to N

        // base case
        dp[n] = 1;

        // arr - 0 1 2 3 4 5 6 7 8 (i starts from 8)
        // dp - 0 1 2 3 4 5 6 7 8 9 (9 is base case already filled)
        for (int i = arr.length - 1; i >= 0; i--) {

            // from ith position we can move arr[i] steps so
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                dp[i] += dp[i + j];
            }
        }
        return dp[0];
    }

}