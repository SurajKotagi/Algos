import java.util.*;
import java.io.*;

public class l100_min_cost_in_maze_traversal {
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
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {

                if (i == r - 1 && j == c - 1) {
                    dp[i][j] = maze[i][j];
                } else if (i == r - 1) {
                    dp[i][j] = maze[i][j] + dp[i][j + 1];
                } else if (j == c - 1) {
                    dp[i][j] = maze[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + maze[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}