import java.util.*;
import java.io.*;

public class l101_gold_mine {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] maze = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                maze[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[r][c];
        int max = Integer.MIN_VALUE;
        for (int j = c - 1; j >= 0; j--) {
            for (int i = r - 1; i >= 0; i--) {
                if (j == c - 1) {
                    dp[i][j] = maze[i][j];
                } else {
                    int nexttop = (i - 1 >= 0) ? dp[i - 1][j + 1] : 0;
                    int nextmid = dp[i][j + 1];
                    int nextdown = (i + 1 < maze.length) ? dp[i + 1][j + 1] : 0;

                    dp[i][j] = maze[i][j] + Math.max(Math.max(nexttop, nextmid), nextdown);

                    if (j == 0) {
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        System.out.println(max);

    }
}