// Return the fewest number of coins that you need to make up that amount. If
// that amount of money cannot be made up by any combination of the coins,
// return -1.

// You may assume that you have an infinite number of each kind of coin.

class Solution {
    // Dynamic programming
    public int coinChange(int[] coins, int target) {
        // edge case
        if (target == 0)
            return 0;

        // dp of range 0 to target
        Integer[] dp = new Integer[target + 1]; // default is null Integer which is necessary while returning -1

        // at each spot, the minimum coins needed to pay the index value is stored
        dp[0] = 0; // no coins needed to pay amt 0

        // outer loop runs for each dp spot from 1 to target (as 0 is already filled)
        // note : indexes of dp array represent amounts
        for (int amt = 1; amt <= target; amt++) {

            dp[amt] = Integer.MAX_VALUE;
            // count - number of coins needed to pay the amt
            int count = 0;

            // each amt spot is checked with all possible options from coins array
            for (int coin : coins) {
                // for amt to be paid by a coin it should be greater than or equal to coin value
                if (amt >= coin) {
                    // dp[amt] is equal to 1 + the minimum dp[] th position to which we can go
                    // null means not possible 0 means possible by using 0 coins
                    if (dp[amt - coin] != null) {
                        count = dp[amt - coin];

                        if (count < dp[amt]) {
                            dp[amt] = count + 1;
                        }
                    }
                }
            }
            if (dp[amt] == Integer.MAX_VALUE)
                dp[amt] = null;
        }

        // if target is not 0 and minimum coins required is 1 then
        if (dp[target] == null) {
            return -1;
        }
        return dp[target];
    }

    // Below method is using recursion (gives TLE)
    // public int coinChange(int[] coins, int amount) {
    // slen = Integer.MAX_VALUE;
    // coinChange(0, amount, coins, 0);
    // if(slen == Integer.MAX_VALUE) return -1;
    // return slen;
    // }
    // static int slen = Integer.MAX_VALUE;

    // public static void coinChange(int idx, int ramt, int[] coins, int len){
    // if(idx == coins.length){
    // if(ramt == 0){
    // if(len < slen){
    // slen = len;
    // }
    // }
    // return;
    // }

    // for(int j = ramt/coins[idx]; j >= 1; j--){
    // for(int i = 0; i < j; i++){
    // ramt = ramt - coins[idx];
    // len++;
    // }
    // coinChange(idx+1, ramt, coins, len);
    // for(int i = 0; i < j; i++){
    // ramt = ramt + coins[idx];
    // len--;
    // }
    // }
    // coinChange(idx+1, ramt, coins, len);
    // }
}