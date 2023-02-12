import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class printpathwithminjump {
    static class Pair {
        String psf;
        int steps;
        int dp_val;
        int idx;

        Pair(String psf, int idx, int steps, int dp_val) {
            this.psf = psf;
            this.steps = steps;
            this.dp_val = dp_val;
            this.idx = idx;
        }
    }

    public static void Solution(int arr[]) {
        int n = arr.length;
        Integer[] dp = new Integer[n];

        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int steps = arr[i];

            int min = Integer.MAX_VALUE;
            for (int step = 1; step <= steps; step++) {
                if (step + i < n) {
                    if (dp[step + i] != null && dp[step + i] < min) {
                        min = dp[step + i];
                    }
                }
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        // for(int i = 0; i < dp.length; i++){
        // System.out.print(dp[i] + " ");
        // }
        System.out.println(dp[0]);
        Queue<Pair> q = new ArrayDeque<>();
        Pair p = new Pair("0", 0, arr[0], dp[0]);
        q.add(p);
        while (q.size() > 0) {
            Pair rem = q.remove();
            if (rem.dp_val == 0) {
                System.out.println(rem.psf + " .");
            }
            for (int i = 1; i <= rem.steps && rem.idx + i < n; i++) {
                int ci = rem.idx + i;
                if (dp[ci] != null && rem.dp_val - 1 == dp[ci]) {
                    q.add(new Pair(rem.psf + " -> " + ci, ci, arr[ci], dp[ci]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}
