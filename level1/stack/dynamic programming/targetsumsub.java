import java.io.*;
import java.util.*;

public class targetsumsub {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();

        // - 0 1 2 3 4 5 6 7 8 9 10
        // 4 o x x x o x x x x x x
        // 2 o x o x o x o x x x x
        // 7 o x o x o x o o x o x
        // 1 o o x o o o o o o o o
        // 3 o o x o o x o o o o o

        boolean dp[][] = new boolean[n][target + 1];
        int lastrow = dp.length - 1;
        int lastcol = dp[0].length - 1;

        for (int i = 0; i <= lastrow; i++) {
            for (int j = 0; j <= lastcol; j++) {
                if (j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = (j == arr[i]);
                else if (dp[i - 1][j] == true ||
                        j == arr[i] ||
                        (arr[i] < j && dp[i - 1][j - arr[i]] == true)) {
                    dp[i][j] = true;
                }
            }
            if (dp[i][target] == true) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}