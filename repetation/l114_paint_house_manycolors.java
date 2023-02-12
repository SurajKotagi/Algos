import java.util.*;
import java.io.*;

public class l114_paint_house_manycolors {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int[][] arr = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][k];
        int final_min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (i == 0) {
                    dp[i][j] = arr[i][j];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int l = 0; l < k; l++) {
                        if (l != j) {
                            min = Math.min(min, dp[i - 1][l]);
                        }
                    }
                    dp[i][j] = min + arr[i][j];
                    if (i == n - 1) {
                        final_min = Math.min(final_min, dp[i][j]);
                    }
                }
            }
        }
        System.out.println(final_min);

    }
}