import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class printalllongestincreasingsubsequences {

    public static class Pair {
        int dp_val;
        int i;
        int v;
        String psf;

        Pair(int dp_val, int i, int v, String psf) {
            this.dp_val = dp_val;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }

    public static void solution(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 0;

        int omax = 0;
        int oi = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    if (dp[j] > max)
                        max = dp[j];
                }
            }
            dp[i] = max + 1;
            if (dp[i] > omax) {
                omax = dp[i];
                oi = i;
            }
        }
        System.out.println(omax);
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == omax) {
                q.add(new Pair(omax, i, arr[i], arr[i] + ""));
            }
        }
        while (q.size() > 0) {
            Pair rem = q.remove();

            if (rem.dp_val == 1) {
                System.out.println(rem.psf);
            } else {
                for (int j = rem.i - 1; j >= 0; j--) {
                    if (arr[j] <= rem.v && dp[j] == rem.dp_val - 1) {
                        q.add(new Pair(dp[j], j, arr[j], arr[j] + " -> " + rem.psf));
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}