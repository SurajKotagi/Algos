import java.io.*;
import java.util.*;

public class painthouse2optimized {

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

        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        for (int j = 0; j < c; j++) {
            dp[0][j] = arr[0][j];

            if (dp[0][j] < least) {
                sleast = least;
                least = dp[0][j];
            } else if (dp[0][j] < sleast) {
                sleast = dp[0][j];
            }
        }
        // System.out.println(least + " " + sleast);

        for (int i = 1; i < r; i++) {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;

            for (int j = 0; j < c; j++) {
                if (least == dp[i - 1][j]) {
                    dp[i][j] = sleast + arr[i][j];
                } else {
                    dp[i][j] = least + arr[i][j];
                }

                if (dp[i][j] < nleast) {
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if (dp[i][j] < nsleast) {
                    nsleast = dp[i][j];
                }
            }

            least = nleast;
            sleast = nsleast;
        }

        System.out.println(least);
    }
}