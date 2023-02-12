import java.io.*;
import java.util.*;

public class buyandsellcooldowninfinite {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        int max_profit = solution2(prices, n);
        System.out.println(max_profit);
    }

    public static int solution(int[] prices, int n) {
        int[][] dp = new int[n][4];

        // dp[][0] - stockprices
        // dp[][1] - maximum profit possible with having one share
        // dp[][2] - maximum amount in hand with no shares left
        // dp[][3] - maximum cool downed amount which can be used for buying share next
        // day

        for (int i = 0; i < n; i++) {
            dp[i][0] = prices[i];
        }
        dp[0][1] = -dp[0][0];
        // System.out.println(dp[0][1] + " " + dp[0][2] + " " + dp[0][3]);

        for (int i = 1; i < n; i++) {
            if (dp[i - 1][3] - dp[i][0] >= dp[i - 1][1]) {
                dp[i][1] = dp[i - 1][3] - dp[i][0];
            } else {
                dp[i][1] = dp[i - 1][1];
            }

            if (dp[i - 1][1] + dp[i][0] >= dp[i - 1][2]) {
                dp[i][2] = dp[i - 1][1] + dp[i][0];
            } else {
                dp[i][2] = dp[i - 1][2];
            }

            if (dp[i - 1][2] >= dp[i - 1][3]) {
                dp[i][3] = dp[i - 1][2];
            } else {
                dp[i][3] = dp[i - 1][3];
            }
            // System.out.println(dp[i][1] + " " + dp[i][2] + " " + dp[i][3]);
        }
        return dp[n - 1][2];
    }

    public static int solution2(int[] prices, int n) {
        // osmp - maximum profit with one share in hand
        // nsmp - no share maximum amount in hand
        // cda - cool downed amount
        int osmp = -prices[0];
        int nsmp = 0;
        int cda = 0;

        for (int i = 1; i < n; i++) {
            int nosmp = (cda - prices[i] >= osmp) ? cda - prices[i] : osmp;
            int nnsmp = (osmp + prices[i] >= nsmp) ? osmp + prices[i] : nsmp;
            int ncda = (nsmp >= cda) ? nsmp : cda;

            osmp = nosmp;
            nsmp = nnsmp;
            cda = ncda;
        }

        return nsmp;
    }
}