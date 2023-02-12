import java.io.*;
import java.util.*;

public class printallpathswithtargetsumsubset {

    public static class Pair {
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        boolean[][] dp = new boolean[n + 1][tar + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= tar; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    continue;
                } else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                    if (j >= arr[i - 1] && dp[i - 1][j - arr[i - 1]] == true) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        System.out.println(dp[n][tar]);

        Pair p = new Pair(n, tar, "");
        Queue<Pair> q = new ArrayDeque<>();
        q.add(p);

        while (q.size() > 0) {

            Pair rem = q.remove();

            if (rem.j == 0 || rem.i == 0) {
                System.out.println(rem.psf);
            } else {
                if (rem.j >= arr[rem.i - 1]) {
                    boolean inc = dp[rem.i - 1][rem.j - arr[rem.i - 1]];
                    if (inc) {
                        q.add(new Pair(rem.i - 1, rem.j - arr[rem.i - 1], rem.i - 1 + " " + rem.psf));
                    }
                }

                boolean exc = dp[rem.i - 1][rem.j];
                if (exc) {
                    q.add(new Pair(rem.i - 1, rem.j, rem.psf));
                }

            }

        }
    }
}
