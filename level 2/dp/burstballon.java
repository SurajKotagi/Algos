import java.io.*;
import java.util.*;

public class burstballon {

    public static int solution(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {

                    int left = (i > 0) ? arr[i - 1] : 1;
                    int right = (j < n - 1) ? arr[j + 1] : 1;
                    dp[i][j] = left * arr[i] * right;

                } else {
                    int max = Integer.MIN_VALUE;
                    for (int k = i; k <= j; k++) {
                        int left = (i > 0) ? arr[i - 1] : 1;
                        int right = (j < n - 1) ? arr[j + 1] : 1;

                        int left_dp = (k > i) ? dp[i][k - 1] : 0;
                        int right_dp = (k < j) ? dp[k + 1][j] : 0;

                        int temp = (left * arr[k] * right) + left_dp + right_dp;

                        max = Math.max(max, temp);
                    }
                    dp[i][j] = max;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}