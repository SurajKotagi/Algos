import java.io.*;
import java.util.*;

public class pathsof01knapsack {

    public static class Pair {
        int i;
        int j;
        int val;
        String psf;

        Pair(int i, int j, int val, String psf) {
            this.i = i;
            this.j = j;
            this.val = val;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= wts[i - 1]) {
                    if (dp[i - 1][j - wts[i - 1]] + values[i - 1] > dp[i][j]) {
                        dp[i][j] = dp[i - 1][j - wts[i - 1]] + values[i - 1];
                    }
                }
            }
        }
        System.out.println(dp[n][cap]);

        Queue<Pair> q = new ArrayDeque<>();
        Pair p = new Pair(n, cap, dp[n][cap], "");
        q.add(p);

        // BFS
        while (q.size() > 0) {
            Pair rem = q.remove();

            if (rem.val == 0) {
                System.out.println(rem.psf);
            } else {
                if (rem.val == dp[rem.i - 1][rem.j]) {
                    q.add(new Pair(rem.i - 1, rem.j, dp[rem.i - 1][rem.j], rem.psf));
                }
                if (rem.j >= wts[rem.i - 1]) {
                    if (rem.val == dp[rem.i - 1][rem.j - wts[rem.i - 1]] + values[rem.i - 1]) {
                        q.add(new Pair(rem.i - 1, rem.j - wts[rem.i - 1], dp[rem.i - 1][rem.j - wts[rem.i - 1]],
                                rem.i - 1 + " " + rem.psf));
                    }
                }

            }

        }

    }
}
