class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = cost[0];

        for (int i = 2; i <= n; i++) {
            int op1 = dp[i - 2] + cost[i - 2];
            int op2 = dp[i - 1] + cost[i - 1];
            dp[i] = Math.min(op1, op2);
        }

        return dp[n];

    }
}