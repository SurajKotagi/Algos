import java.io.*;
import java.util.*;

public class painthouse2 {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[r][c];

        // setting base case values for all cols of first row
        for (int col = 0; col < c; col++) {
            dp[0][col] = arr[0][col];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < c; k++) {
                    if (k != j) {
                        if (dp[i - 1][k] < min) {
                            min = dp[i - 1][k];
                        }
                    }
                }
                dp[i][j] = min + arr[i][j];
            }
        }

        int MIN = Integer.MAX_VALUE;
        for (int j = 0; j < c; j++) {
            if (dp[r - 1][j] < MIN) {
                MIN = dp[r - 1][j];
            }
        }
        System.out.println(MIN);
    }
}