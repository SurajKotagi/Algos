import java.io.*;
import java.util.*;

public class mincostmaze {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] maze = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                maze[i][j] = scn.nextInt();
            }
        }

        Integer[][] dp = new Integer[r][c];
        dp[maze.length - 1][maze[0].length - 1] = maze[maze.length - 1][maze[0].length - 1];

        // specially assigning last column of dp
        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i][dp[0].length - 1] = dp[i + 1][dp[0].length - 1] + maze[i][maze[0].length - 1];
        }

        // specially assigning last row of dp
        for (int j = dp[0].length - 2; j >= 0; j--) {
            dp[dp.length - 1][j] = dp[dp.length - 1][j + 1] + maze[maze.length - 1][j];
        }

        // coming reverse from last spot first box
        // in dp[][] min value of next row and col box in dp[][] + its own value in maze
        // [][] is added
        for (int i = maze.length - 2; i >= 0; i--) {
            for (int j = maze[0].length - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + maze[i][j];
            }
        }
        System.out.println(dp[0][0]);
    }

}