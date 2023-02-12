import java.io.*;
import java.util.*;

public class coincjangepermutation {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scn.nextInt();
        }

        int amount = scn.nextInt();

        // 2 3 5 (coins)
        // 0 1 2 3 4 5 6 7 (amts)
        // 7 --> amount

        int[] permutations_of_paying = new int[amount + 1];
        permutations_of_paying[0] = 1;

        for (int amt = 1; amt <= amount; amt++) {
            // every amt has to be checked with all the coin of coins
            int count = 0;
            for (int coin : coins) {
                if (amt >= coin)
                    count += permutations_of_paying[amt - coin];
            }
            permutations_of_paying[amt] = count;
        }
        System.out.println(permutations_of_paying[amount]);
    }
}