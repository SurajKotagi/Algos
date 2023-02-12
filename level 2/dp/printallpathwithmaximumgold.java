import java.io.*;
import java.util.*;

public class printallpathwithmaximumgold {

    private static class Pair {
        String psf;
        int i;
        int j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        int[][] dp = new int[n][m];

        int omax = 0;
        for (int j = m - 1; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                if (j == m - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == n - 1) {
                    dp[i][j] = Math.max(dp[i - 1][j + 1], dp[i][j + 1]) + arr[i][j];
                } else if (i == 0) {
                    dp[i][j] = Math.max(dp[i + 1][j + 1], dp[i][j + 1]) + arr[i][j];
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]), dp[i][j + 1]) + arr[i][j];
                }
                if (j == 0 && dp[i][j] > omax) {
                    omax = dp[i][j];
                }
            }
        }
        System.out.println(omax);
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] == omax) {
                Pair p = new Pair(i + " ", i, 0);
                q.add(p);
            }
        }

        while (q.size() > 0) {
            Pair rem = q.remove();
            if (rem.j == m - 1) {
                System.out.println(rem.psf);
            } else if (rem.i == 0) {
                int max_val = Math.max(dp[rem.i][rem.j + 1], dp[rem.i + 1][rem.j + 1]);

                if (dp[rem.i][rem.j + 1] == max_val) {
                    q.add(new Pair(rem.psf + "d2 ", rem.i, rem.j + 1));
                }
                if (dp[rem.i + 1][rem.j + 1] == max_val) {
                    q.add(new Pair(rem.psf + "d3 ", rem.i + 1, rem.j + 1));
                }
            } else if (rem.i == n - 1) {
                int max_val = Math.max(dp[rem.i][rem.j + 1], dp[rem.i - 1][rem.j + 1]);

                if (dp[rem.i - 1][rem.j + 1] == max_val) {
                    q.add(new Pair(rem.psf + "d1 ", rem.i - 1, rem.j + 1));
                }
                if (dp[rem.i][rem.j + 1] == max_val) {
                    q.add(new Pair(rem.psf + "d2 ", rem.i, rem.j + 1));
                }

            } else {
                int max_val = Math.max(dp[rem.i][rem.j + 1],
                        Math.max(dp[rem.i - 1][rem.j + 1], dp[rem.i + 1][rem.j + 1]));

                if (dp[rem.i - 1][rem.j + 1] == max_val) {
                    q.add(new Pair(rem.psf + "d1 ", rem.i - 1, rem.j + 1));
                }
                if (dp[rem.i][rem.j + 1] == max_val) {
                    q.add(new Pair(rem.psf + "d2 ", rem.i, rem.j + 1));
                }
                if (dp[rem.i + 1][rem.j + 1] == max_val) {
                    q.add(new Pair(rem.psf + "d3 ", rem.i + 1, rem.j + 1));
                }
            }
        }
    }
}