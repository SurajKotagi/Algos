import java.io.*;
import java.util.*;

public class goldmine {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = scn.nextInt();
            }
        }

        int lastrow = maze.length - 1;
        int lastcol = maze[0].length - 1;

        int[][] dp = new int[n][m];

        int max = Integer.MIN_VALUE;
        for (int j = lastcol; j >= 0; j--) {
            for (int i = lastrow; i >= 0; i--) {
                if (j == lastcol)
                    dp[i][j] = maze[i][j];
                else if (i == 0)
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + maze[i][j];
                else if (i == lastrow)
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j + 1]) + maze[i][j];
                else
                    dp[i][j] = Math.max(dp[i + 1][j + 1], Math.max(dp[i][j + 1], dp[i - 1][j + 1])) + maze[i][j];
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
}