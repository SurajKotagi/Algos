import java.io.*;
import java.util.*;

public class largestsubsquarematrix {

    public static int solution(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];

        int max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j--) {
                if (arr[i][j] == 1) {
                    if (i == arr.length - 1 && j == arr[0].length - 1) {
                        dp[i][j] = 1;
                    } else if (i == arr.length - 1) {
                        dp[i][j] = 1;
                    } else if (j == arr[0].length - 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;

                    }
                }

                if (dp[i][j] > max)
                    max = dp[i][j];
            }

        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        System.out.println(solution(arr));
    }

}