import java.io.*;
import java.util.*;

public class stocksinfcharge {
    // Explained
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        int charge = scn.nextInt();

        // tabulation method
        // solution(n, prices, charge);

        // tabulation method(no ectra space)
        solution2(n, prices, charge);

    }

    public static void solution(int n, int[] prices, int charge) {
        int[][] dp = new int[n + 1][3];

        // i - day
        // dp[i][0] - stock prices
        // dp[i][1] - maximum profit with having one share
        // dp[i][2] - maximum profit with no share left

        // base cases
        // initially as we have no money we have to take the first share with loan
        // note: we cannot sell the share brought at same day (we will be in loss)
        // so at day 1 the profit with having 1 share is -(stock price) and maximum
        // profit with no shares in hand is 0

        // making dp[][] ready (0th column as stock prices and assigning base cases)

        for (int i = 0; i < n; i++) {
            dp[i + 1][0] = prices[i];
        }
        dp[1][1] = -(dp[1][0]);

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < 3; j++) {
                // Algorithm
                // if you bought today's share with the money you had and you are on profit then
                // buy it

                if (j == 1) {
                    if (dp[i - 1][2] - dp[i][0] < dp[i - 1][1]) {
                        dp[i][1] = dp[i - 1][1];
                    } else {
                        dp[i][1] = dp[i - 1][2] - dp[i][0];
                    }
                }
                // Algorithm
                // if you are on profit by selling your current share and buying new one then
                // store the profit in amount with no shares in hand else hold same value

                if (j == 2) {
                    if (dp[i - 1][1] + dp[i][0] - charge >= dp[i - 1][2]) {
                        dp[i][2] = dp[i - 1][1] + dp[i][0] - charge;
                    } else {
                        dp[i][2] = dp[i - 1][2];
                    }
                }
            }
        }
        System.out.println(dp[n][2]);
    }

    public static void solution2(int n, int[] prices, int charge) {
        // aws - amount with having share
        // awns - amount with having no share left
        int prev_price = prices[0];
        int prev_aws = -(prev_price);
        int prev_awns = 0;

        for (int i = 1; i < n; i++) {
            int new_price = prices[i];
            int new_aws = (prev_awns - new_price >= prev_aws) ? prev_awns - new_price : prev_aws;
            int new_awns = (prev_aws + new_price - charge >= prev_awns) ? prev_aws + new_price - charge : prev_awns;

            prev_price = new_price;
            prev_aws = new_aws;
            prev_awns = new_awns;
        }
        System.out.println(prev_awns);
    }
}
