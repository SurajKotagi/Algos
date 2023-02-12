import java.util.HashMap;
import java.util.Scanner;

public class highwaybillboard {
    public static int solution(int road, int[] f, int[] rs, int d) {
        int[] dp = new int[f.length];
        dp[0] = rs[0];
        int ans = 0;
        for (int i = 1; i < f.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (f[i] - f[j] > d) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + rs[i];
            // System.out.print(dp[i] +" ");
            // -2147483640 10 8 6 10

            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    public static int solution2(int road, int[] f, int[] rs, int d) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < f.length; i++) {
            int idx = f[i];
            int value = rs[i];
            hm.put(idx, value);
        }
        int[] dp = new int[road + 1];
        for (int i = 1; i <= road; i++) {
            if (hm.containsKey(i) == false) {
                dp[i] = dp[i - 1];
            } else {
                int weput = ((i - d <= 0) ? hm.get(i) : dp[i - d - 1] + hm.get(i));
                int weleft = dp[i - 1];
                dp[i] = Math.max(weput, weleft);
                // System.out.print(dp[i] + " ");
            }
        }
        return dp[road];
    }

    public static void input(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue, scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}