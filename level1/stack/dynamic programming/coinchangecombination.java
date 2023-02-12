import java.io.*;
import java.util.*;

public class coinchangecombination {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // scn.close();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scn.nextInt();
        }

        int amount = scn.nextInt();

        // 2 3 5
        // 0 1 2 3 4 5 6 7

        // algorithm
        // this is the dp problem
        // there isinfifnite suply of coins
        // we need to find the combinations of coins by which the amt can be paid
        // to eliminate permutes we have unique important method
        // first we find all theways ny which we can pay amt with using only 2 rupee
        // coin
        // then the same for coin 3 ,then for coin 5
        // thsis stops permutation occuring
        // note : there is 1 way to pay 0 amt (not giving any coin)

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            // taking one coin
            int coin = coins[i];
            // finding all ways by which we can pay j amount using only selected coin
            for (int j = coin; j <= amount; j++) {
                // if we pay COIN.rs of amount j then w should see whether there is way to pay
                // remaining amount ,if its there then ways get added up
                if (dp[j - coin] > 0)
                    dp[j] += dp[j - coin];
            }
        }
        System.out.println(dp[amount]);
    }
}