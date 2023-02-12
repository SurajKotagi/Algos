import java.io.*;
import java.util.*;

public class optimumbst {

    private static void optimalbst(int[] nodes, int[] count, int n) {

        int[] psum = new int[n];
        psum[0] = count[0];
        for (int i = 1; i < n; i++) {
            psum[i] = psum[i - 1] + count[i];
        }
        int[][] dp = new int[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = count[i];
                } else if (g == 1) {
                    int right = 1 * count[i] + 2 * count[j];
                    int left = 1 * count[j] + 2 * count[i];

                    dp[i][j] = Math.min(right, left);
                } else {
                    int min = Integer.MAX_VALUE;
                    int dfault = psum[j] - ((i > 1) ? psum[i - 1] : 0);

                    for (int k = i; k <= j; k++) {
                        int temp = 0;
                        if (k > i) {
                            temp += dp[i][k - 1];
                        }
                        if (k < j) {
                            temp += dp[k + 1][j];
                        }
                        temp += dfault;
                        min = Math.min(temp, min);
                    }
                    // System.out.println(i + " " + j);
                    dp[i][j] = min;
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            frequency[i] = scn.nextInt();
        }
        optimalbst(keys, frequency, n);
    }

}